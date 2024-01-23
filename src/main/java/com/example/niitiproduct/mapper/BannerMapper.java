package com.example.niitiproduct.mapper;

import com.example.niitiproduct.dto.BannerDTO;
import com.example.niitiproduct.models.Banner;
import org.springframework.stereotype.Component;

@Component
public class BannerMapper {
    public BannerDTO toDTO(Banner banner) {
        return BannerDTO.builder(
                ).id(banner.getId())
                .name(banner.getB00_name())
                .description(banner.getB01_description())
                .thumbnail_url(banner.getB02_thumbnail_url())
                .banner_url(banner.getB03_banner_url())
                .is_default(banner.getB04_is_default())
                .is_actived(banner.getB05_is_actived())
                .created_at(banner.getB06_created_at())
                .created_by(banner.getB07_created_by())
                .updated_at(banner.getB08_updated_at())
                .updated_by(banner.getB09_updated_by())
                .deleted_at(banner.getB10_deleted_at())
                .deleted_by(banner.getB11_deleted_by())
                .build();
    }
}

