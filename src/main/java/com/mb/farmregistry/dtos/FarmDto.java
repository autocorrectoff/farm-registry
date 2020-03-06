package com.mb.farmregistry.dtos;

import com.mb.farmregistry.models.Customer;
import com.mb.farmregistry.models.Farm;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FarmDto {

    private Long id;

    private String name;

    private Long customerId;

    public static FarmDto entityToDto(Farm farm) {
        FarmDto dto = new FarmDto();
        dto.setId(farm.getId());
        dto.setName(farm.getName());
        dto.setCustomerId(farm.getCustomer().getId());
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

    public static Farm dtoToEntity(FarmDto dto) {
        Farm farm = Farm.builder().name(dto.getName()).customer(Customer.builder().id(dto.getId()).build()).build();
        return farm;
    }
}
