package com.mb.farmregistry.controllers;

import com.mb.farmregistry.dtos.UserDto;
import com.mb.farmregistry.services.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("users")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createUser(@RequestBody UserDto dto) {
        Map<String, Object> id = userService.createUser(dto);
        return ResponseEntity.ok(id);
    }

    @PostMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody UserDto dto) {
        UserDto user = userService.loginUser(dto);
        if(user != null) {
            return ResponseEntity.ok(user);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
