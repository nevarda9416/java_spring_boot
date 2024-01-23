package com.example.niitiproduct.mapper;

import com.example.niitiproduct.dto.ManufactureDTO;
import com.example.niitiproduct.models.Manufacture;
import org.springframework.stereotype.Component;

@Component
public class ManufactureMapper {
    public ManufactureDTO toDTO(Manufacture manufacture) {
        return ManufactureDTO.builder(
                ).id(manufacture.getId())
                .name(manufacture.getM00_name())
                .description(manufacture.getM01_description())
                .created_at(manufacture.getM02_created_at())
                .created_by(manufacture.getM03_created_by())
                .updated_at(manufacture.getM04_updated_at())
                .updated_by(manufacture.getM05_updated_by())
                .deleted_at(manufacture.getM06_deleted_at())
                .deleted_by(manufacture.getM07_deleted_by())
                .build();
    }
}