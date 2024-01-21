package com.example.niitiproduct.mapper;

import com.example.niitiproduct.dto.OrderLogDTO;
import com.example.niitiproduct.models.OrderLog;
import org.springframework.stereotype.Component;

@Component
public class OrderLogMapper {
    public OrderLogDTO toDTO(OrderLog orderLog) {
        return OrderLogDTO.builder(
                ).id(orderLog.getId())
                .customer_id(orderLog.getCustomer_id())
                .order_id(orderLog.getOrder_id())
                .order_value(orderLog.getOrder_value())
                .payment_method(orderLog.getPayment_method())
                .created_at(orderLog.getCreated_at())
                .created_by(orderLog.getCreated_by())
                .updated_at(orderLog.getUpdated_at())
                .updated_by(orderLog.getUpdated_by())
                .deleted_at(orderLog.getDeleted_at())
                .deleted_by(orderLog.getDeleted_by())
                .build();
    }
}