package com.example.niitiproduct.mapper;

import com.example.niitiproduct.dto.OrderDTO;
import com.example.niitiproduct.models.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public OrderDTO toDTO(Order order) {
        return OrderDTO.builder(
                ).id(order.getId())
                .user_id(order.getUser_id())
                .total_price(order.getTotal_price())
                .total_amount(order.getTotal_amount())
                .total_tax(order.getTotal_tax())
                .status(order.getStatus())
                .created_at(order.getCreated_at())
                .created_by(order.getCreated_by())
                .updated_at(order.getUpdated_at())
                .updated_by(order.getUpdated_by())
                .deleted_at(order.getDeleted_at())
                .deleted_by(order.getDeleted_by())
                .build();
    }
}