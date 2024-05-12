package com.example.niitiproduct.services.Page;

import com.example.niitiproduct.dto.PageDTO;
import com.example.niitiproduct.models.Pages;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPageService {
    Page<Pages> findPaginated(int page, int size);
    List<PageDTO> getAll(Pageable pageable);

    Page<Pages> searchByName(String name, int page, int size);

    boolean save(Pages page);

    void delete(Long id);

    Pages findById(Long id);
}
