package com.example.niitiproduct.services;

import com.example.niitiproduct.dto.PostDTO;
import com.example.niitiproduct.mapper.PostMapper;
import com.example.niitiproduct.models.Post;
import com.example.niitiproduct.models.Promotion;
import com.example.niitiproduct.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private PostRepository postRepository;

    /**
     * Get all posts
     */
    public List<PostDTO> getAll() {
        return postRepository.findAll().stream().map(e->postMapper.toDTO(e)).toList();
    }

    /**
     * Search by post name
     */
    public List<Post> searchByName(String title) {
        return postRepository.findByTitleContaining(title);
    }

    /**
     * Edit post
     * @param id
     * @return
     */
    public Post findById(Long id) {
        return postRepository.findById(Math.toIntExact(id)).get();
    }

    /**
     * Insert/Update post
     */
    public boolean save(Post post) {
        try {
            Post postData = new Post();
            postData.setId(post.getId());
            postData.setTitle(post.getTitle());
            postData.setShare_url(post.getShare_url());
            postData.setSlug(post.getSlug());
            postData.setExcerpt(post.getExcerpt());
            postData.setPlain_text(post.getPlain_text());
            postData.setContent(post.getContent());
            postData.setAuthor_name(post.getAuthor_name());
            postData.setUser_id(post.getUser_id());
            postData.setStatus(post.getStatus());
            postData.setPublished_at(post.getPublished_at());
            postData.setIs_comment(post.getIs_comment());
            postData.setComment_count(post.getComment_count());
            postData.setPost_type(post.getPost_type());
            postData.setCategory_id(post.getCategory_id());
            postData.setIs_highlight(post.getIs_highlight());
            postData.setShow_on_homepage(post.getShow_on_homepage());
            postData.setMeta_title(post.getMeta_title());
            postData.setMeta_keyword(post.getMeta_keyword());
            postData.setMeta_description(post.getMeta_description());
            postData.setMeta_image(post.getMeta_image());
            postData.setCreated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            postData.setCreated_by(String.valueOf(1));
            postData.setUpdated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            postData.setUpdated_by(String.valueOf(1));
            postRepository.save(postData);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Delete post
     */
    public void delete(Integer id) {
        try {
            postRepository.deleteById(Math.toIntExact(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ResponseEntity<Object> getAllPosts() {
        List<Post> postList = postRepository.findAll();
        return new ResponseEntity<>(postList, HttpStatus.OK);
    }

    public ResponseEntity<Object> getPostsByCategoryId(Integer categoryId) {
        List<Post> postList = postRepository.findPostsByCategory_id(categoryId);
        return new ResponseEntity<>(postList, HttpStatus.OK);
    }
}
