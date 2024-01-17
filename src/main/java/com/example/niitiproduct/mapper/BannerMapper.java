package com.example.niitiproduct.mapper;

import com.example.niitiproduct.dto.BannerDTO;
import com.example.niitiproduct.models.Banner;
import org.springframework.stereotype.Component;

@Component
public class BannerMapper {
    public BannerDTO toDTO(Banner banner) {
        return BannerDTO.builder(
                ).id(banner.getId())
                .name(banner.getName())
                .description(banner.getDescription())
                .thumbnail_url(banner.getThumbnail_url())
                .banner_url(banner.getBanner_url())
                .is_default(banner.getIs_default())
                .is_actived(banner.getIs_actived())
                .created_at(banner.getCreated_at())
                .created_by(banner.getCreated_by())
                .updated_at(banner.getUpdated_at())
                .updated_by(banner.getUpdated_by())
                .deleted_at(banner.getDeleted_at())
                .deleted_by(banner.getDeleted_by())
                .build();
    }
}

