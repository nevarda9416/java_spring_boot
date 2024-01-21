package com.example.niitiproduct.services;

import com.example.niitiproduct.dto.OrderLogDTO;
import com.example.niitiproduct.mapper.OrderLogMapper;
import com.example.niitiproduct.repositories.OrderLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderLogService {
    @Autowired
    OrderLogMapper orderLogMapper;
    @Autowired
    private OrderLogRepository orderLogRepository;
    public List<OrderLogDTO> getAll() {
        return orderLogRepository.findAllByOrderByIdDesc().stream().map(e->orderLogMapper.toDTO(e)).toList();
    }
}