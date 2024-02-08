package com.example.niitiproduct.mapper;

import com.example.niitiproduct.dto.CustomerDTO;
import com.example.niitiproduct.models.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public CustomerDTO toDTO(Customer customer) {
        return CustomerDTO.builder(
                ).id(customer.getId())
                .email(customer.getEmail())
                .password(customer.getPassword())
                .is_actived(customer.getIs_actived())
                .first_name(customer.getFirst_name())
                .last_name(customer.getLast_name())
                .birthday(customer.getBirthday())
                .gender(customer.getGender())
                .telephone(customer.getTelephone())
                .address(customer.getAddress())
                .created_at(customer.getCreated_at())
                .created_by(customer.getCreated_by())
                .updated_at(customer.getUpdated_at())
                .updated_by(customer.getUpdated_by())
                .deleted_at(customer.getDeleted_at())
                .deleted_by(customer.getDeleted_by())
                .build();
    }
}