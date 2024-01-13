package com.example.niitiproduct.services;

import com.example.niitiproduct.dto.CustomerDTO;
import com.example.niitiproduct.mapper.CustomerMapper;
import com.example.niitiproduct.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerMapper customerMapper;
    @Autowired
    private CustomerRepository customerRepository;
    public List<CustomerDTO> getAll() {
        return customerRepository.findAll().stream().map(e->customerMapper.toDTO(e)).toList();
    }
}
