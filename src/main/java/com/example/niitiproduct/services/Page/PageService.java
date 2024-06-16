package com.example.niitiproduct.services.Page;

import com.example.niitiproduct.dto.PageDTO;
import com.example.niitiproduct.mapper.PageMapper;
import com.example.niitiproduct.models.Pages;
import com.example.niitiproduct.repositories.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class PageService implements IPageService {
    @Autowired
    private PageMapper pageMapper;
    @Autowired
    private PageRepository pageRepository;

    public Page<Pages> findPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return this.pageRepository.findAll(pageable);
    }

    /**
     * Get all pages
     */
    public List<PageDTO> getAll(Pageable pageable) {
        return pageRepository.findAllByOrderByIdDesc(pageable).stream().map(e->pageMapper.toDTO(e)).toList();
    }

    @Override
    public Page<Pages> searchByName(String name, int page, int size) {
        return null;
    }

    /**
     * Search by page name
     */
    public List<Pages> searchByName(String title) {
        return pageRepository.findByTitleContaining(title);
    }

    public Pages findById(Long id) {
        return pageRepository.findById(Math.toIntExact(id)).get();
    }

    /**
     * Insert/Update page
     */
    public boolean save(Pages page) {
        try {
            Pages pageData = new Pages();
            pageData.setId(page.getId());
            pageData.setTitle(page.getTitle());
            pageData.setSlug(page.getSlug());
            pageData.setExcerpt(page.getExcerpt());
            pageData.setPlain_text(page.getPlain_text());
            pageData.setContent(page.getContent());
            pageData.setAuthor_name(page.getAuthor_name());
            pageData.setUser_id(page.getUser_id());
            pageData.setStatus(page.getStatus());
            pageData.setCategory_id(page.getCategory_id());
            pageData.setPage_type(page.getPage_type());
            pageData.setMeta_title(page.getMeta_title());
            pageData.setMeta_keyword(page.getMeta_keyword());
            pageData.setMeta_description(page.getMeta_description());
            pageData.setMeta_image(page.getMeta_image());
            pageData.setCreated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            pageData.setCreated_by(String.valueOf(1));
            pageData.setUpdated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            pageData.setUpdated_by(String.valueOf(1));
            pageRepository.save(pageData);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Delete page
     */
    public void delete(Long id) {
        try {
            pageRepository.deleteById(Math.toIntExact(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Get page by slug
     * @param slug
     * @return
     */
    public ResponseEntity<Object> getPageBySlug(String slug) {
        List<Map<String, Object>> pageDetail = pageRepository.findBySlug(slug);
        return new ResponseEntity<>(pageDetail, HttpStatus.OK);
    }
}
