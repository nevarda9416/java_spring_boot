package com.example.niitiproduct.services;

import com.example.niitiproduct.dto.BannerDTO;
import com.example.niitiproduct.mapper.BannerMapper;
import com.example.niitiproduct.models.Banner;
import com.example.niitiproduct.models.Category;
import com.example.niitiproduct.repositories.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BannerService {
    @Autowired
    BannerMapper bannerMapper;
    @Autowired
    private BannerRepository bannerRepository;

    /**
     * Get all banners
     * @return
     */
    public List<BannerDTO> getAll() {
        return bannerRepository.findAll().stream().map(e->bannerMapper.toDTO(e)).toList();
    }

    /**
     * Search by banner name
     * @param name
     * @return
     */
    public List<Banner> searchByName(String name) {
        return bannerRepository.findByNameContaining(name);
    }

    /**
     * Edit banner
     * @param id
     * @return
     */
    public Banner findById(Long id) {
        return bannerRepository.findById(Math.toIntExact(id)).get();
    }

    /**
     * Insert/Update banner
     * @param banner
     * @return
     */
    public boolean save(Banner banner) {
        try {
            Banner bannerData = new Banner();
            bannerData.setId(banner.getId());
            bannerData.setName(banner.getName());
            bannerData.setDescription(banner.getDescription());
            bannerData.setThumbnail_url(banner.getThumbnail_url());
            bannerData.setBanner_url(banner.getBanner_url());
            bannerData.setIs_default(banner.getIs_default());
            bannerData.setIs_actived(banner.getIs_actived() != null ? banner.getIs_actived() : 0);
            bannerData.setCreated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            bannerData.setCreated_by(String.valueOf(1));
            bannerData.setUpdated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            bannerData.setUpdated_by(String.valueOf(1));
            bannerRepository.save(bannerData);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void delete(Long id) {
        try {
            bannerRepository.deleteById(Math.toIntExact(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ResponseEntity<Object> getAllBanners() {
        List<Banner> bannerList = bannerRepository.findAll();
        return new ResponseEntity<>(bannerList, HttpStatus.OK);
    }
}
