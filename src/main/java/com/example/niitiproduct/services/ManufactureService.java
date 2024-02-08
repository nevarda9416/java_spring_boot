package com.example.niitiproduct.services;

import com.example.niitiproduct.dto.ManufactureDTO;
import com.example.niitiproduct.mapper.ManufactureMapper;
import com.example.niitiproduct.models.Manufacture;
import com.example.niitiproduct.repositories.ManufactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ManufactureService {
    @Autowired
    ManufactureMapper manufactureMapper;
    @Autowired
    private ManufactureRepository manufactureRepository;

    /**
     * Get all manufactures
     * @return
     */
    public List<ManufactureDTO> getAll() {
        return manufactureRepository.findAllByOrderByIdDesc().stream().map(e->manufactureMapper.toDTO(e)).toList();
    }

    /**
     * Search by manufacture name
     * @param name
     * @return
     */
    public List<Manufacture> searchByName(String name) {
        return manufactureRepository.findByNameContaining(name);
    }

    /**
     * Edit manufacture
     * @param id
     * @return
     */
    public Manufacture findById(Long id) {
        return manufactureRepository.findById(Math.toIntExact(id)).get();
    }

    /**
     * Insert/Update manufacture
     * @param manufacture
     * @return
     */
    public boolean save(Manufacture  manufacture) {
        try {
            Manufacture manufactureData = new Manufacture();
            manufactureData.setName(manufacture.getName());
            manufactureData.setDescription(manufacture.getDescription());
            manufactureData.setCreated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            manufactureData.setCreated_by(String.valueOf(1));
            manufactureData.setUpdated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            manufactureData.setUpdated_by(String.valueOf(1));
            manufactureRepository.save(manufactureData);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Delete manufacture
     * @param id
     */
    public void delete(Long id) {
        try {
            manufactureRepository.deleteById(Math.toIntExact(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}




