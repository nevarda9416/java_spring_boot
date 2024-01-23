package com.example.niitiproduct.mapper;

import com.example.niitiproduct.dto.OrderLogDTO;
import com.example.niitiproduct.models.OrderLog;
import org.springframework.stereotype.Component;

@Component
public class OrderLogMapper {
    public OrderLogDTO toDTO(OrderLog orderLog) {
        return OrderLogDTO.builder(
                ).id(orderLog.getId())
                .customer_id(orderLog.getO00_customer_id())
                .order_id(orderLog.getO01_order_id())
                .order_value(orderLog.getO02_order_value())
                .payment_method(orderLog.getO03_payment_method())
                .created_at(orderLog.getO04_created_at())
                .created_by(orderLog.getO05_created_by())
                .updated_at(orderLog.getO06_updated_at())
                .updated_by(orderLog.getO07_updated_by())
                .deleted_at(orderLog.getO08_deleted_at())
                .deleted_by(orderLog.getO09_deleted_by())
                .build();
    }
}