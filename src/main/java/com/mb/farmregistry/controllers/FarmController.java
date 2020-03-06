package com.mb.farmregistry.controllers;

import com.mb.farmregistry.dtos.FarmDto;
import com.mb.farmregistry.models.Farm;
import com.mb.farmregistry.services.IFarmService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("farms")
public class FarmController {

    private final IFarmService farmService;

    public FarmController(IFarmService farmService) {
        this.farmService = farmService;
    }

    @GetMapping("/search/{userId}")
    public ResponseEntity<List<FarmDto>> getFarms(@PathVariable Long userId) {
        List<FarmDto> farmList = farmService.getByUserId(userId);
        return ResponseEntity.ok(farmList);
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Long>> createFarm(@RequestBody FarmDto dto) {
        Map<String, Long> id = farmService.createFarm(dto);
        return ResponseEntity.ok(id);
    }
}
