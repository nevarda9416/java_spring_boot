package com.example.niitiproduct.mapper;

import com.example.niitiproduct.dto.PageDTO;
import com.example.niitiproduct.models.Pages;
import org.springframework.stereotype.Component;

@Component
public class PageMapper {
    public PageDTO toDTO(Pages page) {
        return PageDTO.builder(
                ).id(page.getId())
                .title(page.getTitle())
                .slug(page.getSlug())
                .excerpt(page.getExcerpt())
                .plain_text(page.getPlain_text())
                .content(page.getContent())
                .author_name(page.getAuthor_name())
                .user_id(page.getUser_id())
                .status(page.getStatus())
                .category_id(page.getCategory_id())
                .page_type(page.getPage_type())
                .meta_title(page.getMeta_title())
                .meta_keyword(page.getMeta_keyword())
                .meta_description(page.getMeta_description())
                .meta_image(page.getMeta_image())
                .created_at(String.valueOf(page.getCreated_at()))
                .created_by(page.getCreated_by())
                .updated_at(String.valueOf(page.getUpdated_at()))
                .updated_by(page.getUpdated_by())
                .deleted_at(String.valueOf(page.getDeleted_at()))
                .deleted_by(page.getDeleted_by())
                .build();
    }
}