package com.example.niitiproduct.mapper;

import com.example.niitiproduct.dto.SettingDTO;
import com.example.niitiproduct.models.Setting;
import org.springframework.stereotype.Component;

@Component
public class SettingMapper {
    public SettingDTO toDTO(Setting setting) {
        return SettingDTO.builder(
                ).id(setting.getId())
                .company_contact(setting.getCompany_contact())
                .telephone_contact(setting.getTelephone_contact())
                .fax_contact(setting.getFax_contact())
                .website_name(setting.getWebsite_name())
                .website_contact(setting.getWebsite_contact())
                .email_contact(setting.getEmail_contact())
                .address_contact(setting.getAddress_contact())
                .logo_header_company(setting.getLogo_header_company())
                .logo_footer_company(setting.getLogo_footer_company())
                .copyright_left(setting.getCopyright_left())
                .copyright_right(setting.getCopyright_right())
                .facebook(setting.getFacebook())
                .youtube(setting.getYoutube())
                .instagram(setting.getInstagram())
                .twitter(setting.getTwitter())
                .google(setting.getGoogle())
                .tiktok(setting.getTiktok())
                .meta_title(setting.getMeta_title())
                .meta_keyword(setting.getMeta_keyword())
                .meta_description(setting.getMeta_description())
                .meta_image(setting.getMeta_image())
                .created_at(setting.getCreated_at())
                .created_by(setting.getCreated_by())
                .updated_at(setting.getUpdated_at())
                .updated_by(setting.getUpdated_by())
                .deleted_at(setting.getDeleted_at())
                .deleted_by(setting.getDeleted_by())
                .build();
    }
}
