package com.example.niitiproduct.mapper;

import com.example.niitiproduct.dto.ManufactureDTO;
import com.example.niitiproduct.models.Manufacture;
import org.springframework.stereotype.Component;

@Component
public class ManufactureMapper {
    public ManufactureDTO toDTO(Manufacture manufacture) {
        return ManufactureDTO.builder(
                ).id(manufacture.getId())
                .name(manufacture.getName())
                .description(manufacture.getDescription())
                .created_at(manufacture.getCreated_at())
                .created_by(manufacture.getCreated_by())
                .updated_at(manufacture.getUpdated_at())
                .updated_by(manufacture.getUpdated_by())
                .deleted_at(manufacture.getDeleted_at())
                .deleted_by(manufacture.getDeleted_by())
                .build();
    }
}