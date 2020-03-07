package com.mb.farmregistry.controllers;

import com.mb.farmregistry.dtos.FarmDto;
import com.mb.farmregistry.services.IFarmService;
import com.mb.farmregistry.services.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("farms")
public class FarmController {

    private final IFarmService farmService;
    private final IUserService userService;

    public FarmController(IFarmService farmService, IUserService userService) {
        this.farmService = farmService;
        this.userService = userService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<FarmDto>> getFarms(@RequestHeader("userId") Long userId) {
        List<FarmDto> farmList = farmService.getByUserId(userId);
        return ResponseEntity.ok(farmList);
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createFarm(@RequestBody FarmDto dto, @RequestHeader("userId") Long userId) {
        if(userService.isAdminUser(userId)) {
            Map<String, Long> id = farmService.createFarm(dto);
            return ResponseEntity.ok(id);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
