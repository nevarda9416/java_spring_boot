package com.example.niitiproduct.mapper;

import com.example.niitiproduct.dto.SellingPlaceDTO;
import com.example.niitiproduct.models.SellingPlace;
import org.springframework.stereotype.Component;

@Component
public class SellingPlaceMapper {
    public SellingPlaceDTO toDTO(SellingPlace sellingPlace) {
        return SellingPlaceDTO.builder(
                ).id(sellingPlace.getId())
                .name(sellingPlace.getName())
                .area(sellingPlace.getArea())
                .city(sellingPlace.getCity())
                .district(sellingPlace.getDistrict())
                .sub_district(sellingPlace.getSub_district())
                .address(sellingPlace.getAddress())
                .hotline(sellingPlace.getHotline())
                .status(sellingPlace.getStatus())
                .created_at(sellingPlace.getCreated_at())
                .created_by(sellingPlace.getCreated_by())
                .updated_at(sellingPlace.getUpdated_at())
                .updated_by(sellingPlace.getUpdated_by())
                .deleted_at(sellingPlace.getDeleted_at())
                .deleted_by(sellingPlace.getDeleted_by())
                .build();
    }
}