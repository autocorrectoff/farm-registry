package com.mb.farmregistry.dtos;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mb.farmregistry.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    private String email;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String password;

    private Boolean isAdmin = false;

    public static User dtoToEntity(UserDto dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setIsAdmin(dto.getIsAdmin());
        user.setPassword(BCrypt.withDefaults().hashToString(12, dto.getPassword().toCharArray()));
        return user;
    }

    public static UserDto entityToDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setIsAdmin(user.getIsAdmin());
        return dto;
    }
}
