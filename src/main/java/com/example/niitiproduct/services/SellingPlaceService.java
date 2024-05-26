package com.example.niitiproduct.services;

import com.example.niitiproduct.dto.SellingPlaceDTO;
import com.example.niitiproduct.mapper.SellingPlaceMapper;
import com.example.niitiproduct.models.SellingPlace;
import com.example.niitiproduct.repositories.SellingPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class SellingPlaceService {
    @Autowired
    SellingPlaceMapper sellingPlaceMapper;
    @Autowired
    private SellingPlaceRepository sellingPlaceRepository;

    /**
     * Get all selling places
     * @return
     */
    public List<SellingPlaceDTO> getAll() {
        return sellingPlaceRepository.findAll().stream().map(e->sellingPlaceMapper.toDTO(e)).toList();
    }

    /**
     * Search by sellingPlace name
     * @param name
     * @return
     */
    public List<SellingPlace> searchByName(String name) {
        return sellingPlaceRepository.findByNameContaining(name);
    }

    /**
     * Edit sellingPlace
     * @param id
     * @return
     */
    public SellingPlace findById(Long id) {
        return sellingPlaceRepository.findById(Math.toIntExact(id)).get();
    }

    /**
     * Insert/Update sellingPlace
     * @param sellingPlace
     * @return
     */
    public boolean save(SellingPlace sellingPlace) {
        try {
            SellingPlace sellingPlaceData = new SellingPlace();
            sellingPlaceData.setId(sellingPlace.getId());
            sellingPlaceData.setName(sellingPlace.getName());
            sellingPlaceData.setArea(sellingPlace.getArea());
            sellingPlaceData.setCity(sellingPlace.getCity());
            sellingPlaceData.setDistrict(sellingPlace.getDistrict());
            sellingPlaceData.setSub_district(sellingPlace.getSub_district());
            sellingPlaceData.setAddress(sellingPlace.getAddress());
            sellingPlaceData.setHotline(sellingPlace.getHotline());
            sellingPlaceData.setStatus(sellingPlace.getStatus());
            sellingPlaceData.setCreated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            sellingPlaceData.setCreated_by(String.valueOf(1));
            sellingPlaceData.setUpdated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            sellingPlaceData.setUpdated_by(String.valueOf(1));
            sellingPlaceRepository.save(sellingPlaceData);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Delete sellingPlace
     * @param id
     */
    public void delete(Long id) {
        try {
            sellingPlaceRepository.deleteById(Math.toIntExact(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ResponseEntity<Object> getAllSellingPlaces() {
        List<SellingPlace> sellingPlaceList = sellingPlaceRepository.findAll();
        return new ResponseEntity<>(sellingPlaceList, HttpStatus.OK);
    }
}