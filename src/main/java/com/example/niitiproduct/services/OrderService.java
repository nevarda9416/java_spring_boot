package com.example.niitiproduct.services;

import com.example.niitiproduct.dto.OrderDTO;
import com.example.niitiproduct.dto.ProductDTO;
import com.example.niitiproduct.mapper.OrderMapper;
import com.example.niitiproduct.models.Order;
import com.example.niitiproduct.models.OrderItem;
import com.example.niitiproduct.repositories.OrderItemRepository;
import com.example.niitiproduct.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @Autowired
    private OrderItemRepository orderItemRepository;

    /**
     * Get all orders
     *
     * @return
     */
    public List<OrderDTO> getAll() {
        return orderRepository.findAllByOrderByIdDesc().stream().map(e -> orderMapper.toDTO(e)).toList();
    }

    /**
     * Search by order_code
     *
     * @param order_code
     * @return
     */
    public List<Order> searchByOrderCode(String code) {
        return orderRepository.findByCodeContaining(code);
    }

    /**
     * Edit product
     *
     * @param id
     * @return
     */
    public Order findById(Long id) {
        return orderRepository.findById(Math.toIntExact(id)).get();
    }

    /**
     * Insert/Update order
     *
     * @param order
     * @return
     */
    public boolean save(Order order) {
        try {
            Order orderData = new Order();
            orderData.setId(order.getId());
            orderData.setCode(order.getCode());
            orderData.setTotal_price(order.getTotal_price());
            orderData.setTotal_amount(order.getTotal_amount());
            orderData.setTotal_tax(order.getTotal_tax());
            orderData.setStatus(order.getStatus());
            orderData.setAccounts_receivable(order.getAccounts_receivable());
            orderData.setCreated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            orderData.setCreated_by(String.valueOf(1));
            orderData.setUpdated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            orderData.setUpdated_by(String.valueOf(1));
            orderRepository.save(orderData);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Delete order
     *
     * @param id
     */
    public void delete(Long id) {
        try {
            orderRepository.deleteById(Math.toIntExact(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean saveOrder(OrderDTO orderData) {
        try {
            Order order = new Order();
            order.setCode(orderData.getCode());
            order.setTotal_price(orderData.getTotal_price());
            order.setTotal_amount(orderData.getTotal_amount());
            order.setTotal_tax(orderData.getTotal_tax());
            order.setStatus(orderData.getStatus());
            order.setAccounts_receivable(orderData.getAccounts_receivable());
            order.setNote(orderData.getNote());
            order.setCustomer_id(orderData.getCustomer_id());
            order.setShipping_method(orderData.getShipping_method());
            order.setShipping_date(orderData.getShipping_date());
            order.setShipping_fullname(orderData.getShipping_fullname());
            order.setShipping_address(orderData.getShipping_address());
            order.setShipping_email(orderData.getShipping_email());
            order.setShipping_fee(orderData.getShipping_fee());
            order.setShipping_phone(orderData.getShipping_phone());
            order.setProvince_code(orderData.getProvince_code());
            order.setProvince_name(orderData.getProvince_name());
            order.setDistrict_code(orderData.getDistrict_code());
            order.setDistrict_name(orderData.getDistrict_name());
            order.setSub_district_code(orderData.getSub_district_code());
            order.setSub_district_name(orderData.getSub_district_name());
            order.setPayment_method(orderData.getPayment_method());
            order.setPayment_date(orderData.getPayment_date());
            order.setTotal_discount_code(orderData.getTotal_discount_code());
            order.setTotal_discount_amount(orderData.getTotal_discount_amount());
            order.setCreated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            order.setCreated_by(String.valueOf(1));
            order.setUpdated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            order.setUpdated_by(String.valueOf(1));
            order = orderRepository.save(order);
            for (ProductDTO product: orderData.getProductList()) {
                System.out.println(product);
                OrderItem orderItem = new OrderItem();
                orderItem.setOrder_id(order.getId());
                orderItem.setProduct_id(product.getId());
                orderItem.setPrice(product.getPrice());
                orderItem.setQuantity(product.getQuantity());
                orderItem.setDiscount_code(product.getDiscount_code());
                orderItem.setDiscount_amount(product.getDiscount_amount());
                orderItem.setCreated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                orderItem.setCreated_by(String.valueOf(1));
                orderItem.setUpdated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                orderItem.setUpdated_by(String.valueOf(1));
                orderItemRepository.save(orderItem);
            }
            return new ResponseEntity<>(orderData, HttpStatus.OK).hasBody();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}




