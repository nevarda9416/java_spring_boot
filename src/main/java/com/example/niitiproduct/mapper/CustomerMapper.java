package com.example.niitiproduct.mapper;

import com.example.niitiproduct.dto.CustomerDTO;
import com.example.niitiproduct.models.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public CustomerDTO toDTO(Customer customer) {
        return CustomerDTO.builder(
                ).id(customer.getId())
                .email(customer.getC00_email())
                .password(customer.getC01_password())
                .is_actived(customer.getC02_is_actived())
                .first_name(customer.getC03_first_name())
                .last_name(customer.getC04_last_name())
                .birthday(customer.getC05_birthday())
                .gender(customer.getC06_gender())
                .telephone(customer.getC07_telephone())
                .address(customer.getC08_address())
                .created_at(customer.getC09_created_at())
                .created_by(customer.getC10_created_by())
                .updated_at(customer.getC11_updated_at())
                .updated_by(customer.getC12_updated_by())
                .deleted_at(customer.getC13_deleted_at())
                .deleted_by(customer.getC14_deleted_by())
                .build();
    }
}