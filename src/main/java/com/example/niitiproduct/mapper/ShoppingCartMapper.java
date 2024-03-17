package com.example.niitiproduct.mapper;

import com.example.niitiproduct.dto.ShoppingCartDTO;
import com.example.niitiproduct.models.ShoppingCart;

public class ShoppingCartMapper {
    public ShoppingCartDTO toDTO(ShoppingCart shoppingCart) {
        return ShoppingCartDTO.builder(
                ).id(shoppingCart.getId())
                .identifier(shoppingCart.getIdentifier())
                .note(shoppingCart.getNote())
                .customer_id(shoppingCart.getCustomer_id())
                .shipping_method(shoppingCart.getShipping_method())
                .shipping_date(shoppingCart.getShipping_date())
                .shipping_fullname(shoppingCart.getShipping_fullname())
                .shipping_address(shoppingCart.getShipping_address())
                .shipping_email(shoppingCart.getShipping_email())
                .shipping_fee(shoppingCart.getShipping_fee())
                .shipping_phone(shoppingCart.getShipping_phone())
                .province_id(shoppingCart.getProvince_id())
                .province_name(shoppingCart.getProvince_name())
                .district_id(shoppingCart.getDistrict_id())
                .district_name(shoppingCart.getDistrict_name())
                .sub_district_id(shoppingCart.getSub_district_id())
                .sub_district_name(shoppingCart.getSub_district_name())
                .customer_note(shoppingCart.getCustomer_note())
                .payment_method(shoppingCart.getPayment_method())
                .payment_date(shoppingCart.getPayment_date())
                .discount_code(shoppingCart.getDiscount_code())
                .discount_amount(shoppingCart.getDiscount_amount())
                .order_value(shoppingCart.getOrder_value())
                .created_at(shoppingCart.getCreated_at())
                .created_by(shoppingCart.getCreated_by())
                .updated_at(shoppingCart.getUpdated_at())
                .updated_by(shoppingCart.getUpdated_by())
                .deleted_at(shoppingCart.getDeleted_at())
                .deleted_by(shoppingCart.getDeleted_by())
                .build();
    }
}
