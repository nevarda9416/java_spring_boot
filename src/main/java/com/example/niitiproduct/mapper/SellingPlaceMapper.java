package com.example.niitiproduct.mapper;

import com.example.niitiproduct.dto.SellingPlaceDTO;
import com.example.niitiproduct.models.SellingPlace;
import org.springframework.stereotype.Component;

@Component
public class SellingPlaceMapper {
    public SellingPlaceDTO toDTO(SellingPlace sellingPlace) {
        return SellingPlaceDTO.builder(
                ).id(sellingPlace.getId())
                .name(sellingPlace.getS00_name())
                .area(sellingPlace.getS01_area())
                .city(sellingPlace.getS02_city())
                .district(sellingPlace.getS03_district())
                .sub_district(sellingPlace.getS04_sub_district())
                .address(sellingPlace.getS05_address())
                .hotline(sellingPlace.getS06_hotline())
                .created_at(sellingPlace.getS07_created_at())
                .created_by(sellingPlace.getS08_created_by())
                .updated_at(sellingPlace.getS09_updated_at())
                .updated_by(sellingPlace.getS10_updated_by())
                .deleted_at(sellingPlace.getS11_deleted_at())
                .deleted_by(sellingPlace.getS12_deleted_by())
                .build();
    }
}