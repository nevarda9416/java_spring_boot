package com.example.niitiproduct.mapper;

import com.example.niitiproduct.dto.SubscriberDTO;
import com.example.niitiproduct.models.Subscriber;
import org.springframework.stereotype.Component;

@Component
public class SubscriberMapper {
    public SubscriberDTO toDTO(Subscriber subscriber) {
        return SubscriberDTO.builder(
                ).id(subscriber.getId())
                .email(subscriber.getEmail())
                .status(subscriber.getStatus())
                .token(subscriber.getToken())
                .created_at(subscriber.getCreated_at())
                .created_by(subscriber.getCreated_by())
                .updated_at(subscriber.getUpdated_at())
                .updated_by(subscriber.getUpdated_by())
                .deleted_at(subscriber.getDeleted_at())
                .deleted_by(subscriber.getDeleted_by())
                .build();
    }
}
