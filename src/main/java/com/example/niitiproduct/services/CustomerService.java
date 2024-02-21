package com.example.niitiproduct.services;

import com.example.niitiproduct.dto.CustomerDTO;
import com.example.niitiproduct.mapper.CustomerMapper;
import com.example.niitiproduct.models.Customer;
import com.example.niitiproduct.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerMapper customerMapper;
    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Get all customers
     * @return
     */
    public List<CustomerDTO> getAll() {
        return customerRepository.findAll().stream().map(e->customerMapper.toDTO(e)).toList();
    }

    /**
     * Search by customer name
     * @param email
     * @return
     */
    public List<Customer> searchByEmail(String email) {
        return customerRepository.findByEmailContaining(email);
    }

    /**
     * Edit customer
     * @param id
     * @return
     */
    public Customer findById(Long id) {
        return customerRepository.findById(Math.toIntExact(id)).get();
    }

    /**
     * Insert/Update customer
     * @param customer
     * @return
     */
    public boolean save(Customer customer) {
        try {
            Customer customerData = new Customer();
            customerData.setId(customer.getId());
            customerData.setEmail(customer.getEmail());
            customerData.setPassword(customer.getPassword());
            customerData.setIs_actived(customer.getIs_actived() != null ? customer.getIs_actived() : 0);
            customerData.setFirst_name(customer.getFirst_name());
            customerData.setLast_name(customer.getLast_name());
            customerData.setBirthday(customer.getBirthday());
            customerData.setGender(customer.getGender());
            customerData.setTelephone(customer.getTelephone());
            customerData.setAddress(customer.getAddress());
            customerData.setCreated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            customerData.setCreated_by(String.valueOf(1));
            customerData.setUpdated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            customerData.setUpdated_by(String.valueOf(1));
            customerRepository.save(customerData);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Delete customer
     * @param id
     */
    public void delete(Long id) {
        try {
            customerRepository.deleteById(Math.toIntExact(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ResponseEntity<Object> getAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }
}
