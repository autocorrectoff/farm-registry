package com.mb.farmregistry.controllers;

import com.mb.farmregistry.dtos.FarmDto;
import com.mb.farmregistry.models.Farm;
import com.mb.farmregistry.services.IFarmService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
