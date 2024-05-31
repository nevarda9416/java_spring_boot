package com.example.niitiproduct.mapper;

import com.example.niitiproduct.dto.PostDTO;
import com.example.niitiproduct.models.Post;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {
    public PostDTO toDTO(Post post) {
        return PostDTO.builder(
                ).id(post.getId())
                .title(post.getTitle())
                .share_url(post.getShare_url())
                .slug(post.getSlug())
                .excerpt(post.getExcerpt())
                .plain_text(post.getPlain_text())
                .content(post.getContent())
                .author_name(post.getAuthor_name())
                .user_id(post.getUser_id())
                .status(post.getStatus())
                .published_at(post.getPublished_at())
                .is_comment(post.getIs_comment())
                .comment_count(post.getComment_count())
                .post_type(post.getPost_type())
                .category_id(post.getCategory_id())
                .is_highlight(post.getIs_highlight())
                .show_on_homepage(post.getShow_on_homepage())
                .meta_title(post.getMeta_title())
                .meta_keyword(post.getMeta_keyword())
                .meta_description(post.getMeta_description())
                .meta_image(post.getMeta_image())
                .created_at(post.getCreated_at())
                .created_by(post.getCreated_by())
                .updated_at(post.getUpdated_at())
                .updated_by(post.getUpdated_by())
                .deleted_at(post.getDeleted_at())
                .deleted_by(post.getDeleted_by())
                .build();
    }
}