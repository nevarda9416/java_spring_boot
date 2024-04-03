package com.example.niitiproduct.forms;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubscriberData {
    private Integer id;
    private String email;
    private String status;
    private String token;
    private String created_at;
    private String created_by;
    private String updated_at;
    private String updated_by;
    private String deleted_at;
    private String deleted_by;
}



