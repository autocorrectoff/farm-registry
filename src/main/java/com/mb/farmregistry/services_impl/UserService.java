package com.mb.farmregistry.services_impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.mb.farmregistry.dtos.UserDto;
import com.mb.farmregistry.models.User;
import com.mb.farmregistry.repositories.UserRepository;
import com.mb.farmregistry.services.IUserService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

import static java.util.Map.entry;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Map<String, Object> createUser(UserDto dto) {
        User user = UserDto.dtoToEntity(dto);
        Optional<User> userExists = userRepository.findByEmail(dto.getEmail());
        if(userExists.isPresent()) {
            System.out.println("Email already registered");
            return Map.ofEntries(entry("error", "Email already registered"));
        }
        User created = userRepository.save(user);
        return Map.ofEntries(entry("userId", created.getId()));
    }

    @Override
    public UserDto loginUser(UserDto dto) {
        Optional<User> userExists = userRepository.findByEmail(dto.getEmail());
        if(userExists.isPresent()) {
            User user = userExists.get();
            BCrypt.Result result = BCrypt.verifyer().verify(dto.getPassword().toCharArray(), user.getPassword());
            if(result.verified) {
                return UserDto.entityToDto(user);
            }
        }
        return null;
    }

    @Override
    public boolean isAdminUser(Long id) {
        Optional<User> userOpt = userRepository.findById(id);
        if(userOpt.isPresent()) {
            return userOpt.get().getIsAdmin();
        }
        return false;
    }
}
