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
    public List<ManufactureDTO> getAll() {
        return manufactureRepository.findAllByOrderByIdDesc().stream().map(e->manufactureMapper.toDTO(e)).toList();
    }
    public boolean save(Manufacture  manufacture) {
        try {
            Manufacture manufactureData = new Manufacture();
            manufactureData.setM00_name(manufacture.getM00_name());
            manufactureData.setM01_description(manufacture.getM01_description());
            manufactureData.setM02_created_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            manufactureData.setM03_created_by(String.valueOf(1));
            manufactureData.setM04_updated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            manufactureData.setM05_updated_by(String.valueOf(1));
            manufactureRepository.save(manufactureData);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}




