package com.mb.farmregistry.services_impl;

import com.mb.farmregistry.dtos.FarmDto;
import com.mb.farmregistry.models.Farm;
import com.mb.farmregistry.repositories.FarmRepository;
import com.mb.farmregistry.services.IFarmService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmService implements IFarmService {

    private final FarmRepository farmRepository;

    public FarmService(FarmRepository farmRepository) {
        this.farmRepository = farmRepository;
    }

    @Override
    public List<FarmDto> getByUserId(Long userId) {
        List<Farm> farms = farmRepository.findByUserId(userId);
        List<FarmDto> dtos = FarmDto.entityListToDtoList(farms);
        return dtos;

    }
}
