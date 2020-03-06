package com.mb.farmregistry.services;

import com.mb.farmregistry.dtos.FarmDto;
import com.mb.farmregistry.models.Farm;
import com.mb.farmregistry.models.User;

import java.util.List;
import java.util.Map;

public interface IFarmService {

    List<FarmDto> getByUserId(Long userId);
    Map<String, Long> createFarm(FarmDto dto);
}
