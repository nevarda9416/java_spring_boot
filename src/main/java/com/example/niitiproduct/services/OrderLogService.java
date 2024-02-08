package com.example.niitiproduct.services;

import com.example.niitiproduct.dto.OrderLogDTO;
import com.example.niitiproduct.mapper.OrderLogMapper;
import com.example.niitiproduct.models.OrderLog;
import com.example.niitiproduct.repositories.OrderLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrderLogService {
    @Autowired
    OrderLogMapper orderLogMapper;
    @Autowired
    private OrderLogRepository orderLogRepository;

    /**
     * Get all orderLogs
     * @return
     */
    public List<OrderLogDTO> getAll() {
        return orderLogRepository.findAllByOrderByIdDesc().stream().map(e->orderLogMapper.toDTO(e)).toList();
    }

    /**
     * Edit orderLog
     * @param id
     * @return
     */
    public OrderLog findById(Long id) {
        return orderLogRepository.findById(Math.toIntExact(id)).get();
    }

    /**
     * Insert/Update orderLog
     * @param orderLog
     * @return
     */
    public boolean save(OrderLog orderLog) {
        try {
            OrderLog orderLogData = new OrderLog();
            orderLogData.setId(orderLog.getId());
            orderLogData.setCustomer_id(orderLog.getCustomer_id());
            orderLogData.setOrder_id(orderLog.getOrder_id());
            orderLogData.setOrder_value(orderLog.getOrder_value());
            orderLogData.setPayment_method(orderLog.getPayment_method());
            orderLogData.setCreated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            orderLogData.setCreated_by(String.valueOf(1));
            orderLogData.setUpdated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            orderLogData.setUpdated_by(String.valueOf(1));
            orderLogRepository.save(orderLogData);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Delete orderLog
     * @param id
     */
    public void delete(Long id) {
        try {
            orderLogRepository.deleteById(Math.toIntExact(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}