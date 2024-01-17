package com.example.niitiproduct.services;

import com.example.niitiproduct.dto.BannerDTO;
import com.example.niitiproduct.mapper.BannerMapper;
import com.example.niitiproduct.repositories.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerService {
    @Autowired
    BannerMapper bannerMapper;
    @Autowired
    private BannerRepository bannerRepository;
    public List<BannerDTO> getAll() {
        return bannerRepository.findAll().stream().map(e->bannerMapper.toDTO(e)).toList();
    }
}
