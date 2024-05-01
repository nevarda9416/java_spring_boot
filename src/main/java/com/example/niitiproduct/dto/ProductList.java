package com.example.niitiproduct.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductList {
    private List<Integer> productList;
}
