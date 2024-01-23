package com.example.niitiproduct.mapper;

import com.example.niitiproduct.dto.OrderDTO;
import com.example.niitiproduct.models.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public OrderDTO toDTO(Order order) {
        return OrderDTO.builder(
                ).id(order.getId())
                .user_id(order.getO00_user_id())
                .total_price(order.getO01_total_price())
                .total_amount(order.getO02_total_amount())
                .total_tax(order.getO03_total_tax())
                .status(order.getO04_status())
                .created_at(order.getO05_created_at())
                .created_by(order.getO06_created_by())
                .updated_at(order.getO07_updated_at())
                .updated_by(order.getO08_updated_by())
                .deleted_at(order.getO09_deleted_at())
                .deleted_by(order.getO10_deleted_by())
                .build();
    }
}