package com.mb.farmregistry.dtos;

import com.mb.farmregistry.models.Farm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FarmDto {

    private Long id;

    private String name;

    public static FarmDto entityToDto(Farm farm) {
        FarmDto dto = new FarmDto();
        dto.setId(farm.getId());
        dto.setName(farm.getName());
        return dto;
    }

    public static List<FarmDto> entityListToDtoList(List<Farm> farms) {
        List<FarmDto> dtos = new ArrayList<>();
        for (Farm farm: farms) {
            FarmDto dto = entityToDto(farm);
            dtos.add(dto);
        }
        return dtos;
    }
}
