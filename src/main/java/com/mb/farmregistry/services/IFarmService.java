package com.mb.farmregistry.services;

import com.mb.farmregistry.dtos.FarmDto;
import com.mb.farmregistry.models.User;

import java.util.List;

public interface IFarmService {

    List<FarmDto> getByUserId(Long userId);
}
