package com.example.niitiproduct.services;

import com.example.niitiproduct.dto.OrderDTO;
import com.example.niitiproduct.mapper.OrderMapper;
import com.example.niitiproduct.models.Order;
import com.example.niitiproduct.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    private OrderRepository orderRepository;
    public List<OrderDTO> getAll() {
        return orderRepository.findAllByOrderByIdDesc().stream().map(e->orderMapper.toDTO(e)).toList();
    }
}




