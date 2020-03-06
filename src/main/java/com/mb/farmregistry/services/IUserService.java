package com.mb.farmregistry.services;

import com.mb.farmregistry.dtos.UserDto;
import com.mb.farmregistry.models.User;

import java.util.Map;

public interface IUserService {

    Map<String, Object> createUser(UserDto dto);

    UserDto loginUser(UserDto dto);
}
