package com.example.niitiproduct.services;

import com.example.niitiproduct.dto.SubscriberDTO;
import com.example.niitiproduct.mapper.SubscriberMapper;
import com.example.niitiproduct.models.Subscriber;
import com.example.niitiproduct.repositories.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class SubscriberService {
    @Autowired
    SubscriberMapper subscriberMapper;
    @Autowired
    private SubscriberRepository subscriberRepository;

    public Page<Subscriber> findPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return this.subscriberRepository.findAll(pageable);
    }

    public List<SubscriberDTO> getAll(Pageable pageable) {
        return subscriberRepository.findAllByOrderByIdDesc(pageable).stream().map(e->subscriberMapper.toDTO(e)).toList();
    }

    public Page<Subscriber> searchByEmail(String email, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return this.subscriberRepository.findByEmailContaining(email, pageable);
    }

    public Subscriber findById(Long id) {
        return subscriberRepository.findById(Math.toIntExact(id)).get();
    }

    public boolean store(Subscriber subscriber) {
        subscriberRepository.save(subscriber);
        return true;
    }

    public boolean save(Subscriber subscriber) {
        try {
            Subscriber subscriberData = new Subscriber();
            subscriberData.setId(subscriber.getId());
            subscriberData.setEmail(subscriber.getEmail());
            subscriberData.setStatus(subscriber.getStatus());
            subscriberData.setToken(subscriber.getToken());
            subscriberData.setCreated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            subscriberData.setCreated_by(String.valueOf(1));
            subscriberData.setUpdated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            subscriberData.setUpdated_by(String.valueOf(1));
            subscriberRepository.save(subscriberData);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void delete(Long id) {
        try {
            subscriberRepository.deleteById(Math.toIntExact(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ResponseEntity<Object> getAllSubcribers() {
        List<Subscriber> subscriberList = subscriberRepository.findAll();
        return new ResponseEntity<>(subscriberList, HttpStatus.OK);
    }
}




