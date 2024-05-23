package com.example.niitiproduct.services;

import com.example.niitiproduct.dto.SettingDTO;
import com.example.niitiproduct.mapper.SettingMapper;
import com.example.niitiproduct.models.Setting;
import com.example.niitiproduct.repositories.SettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class SettingService {
    @Autowired
    private SettingMapper settingMapper;
    @Autowired
    private SettingRepository settingRepository;

    /**
     * Get all posts
     */
    public List<SettingDTO> getAll() {
        return settingRepository.findAll().stream().map(e->settingMapper.toDTO(e)).toList();
    }

    /**
     * Insert/Update post
     */
    public boolean save(Setting setting) {
        try {
            Setting settingData = new Setting();
            settingData.setId(setting.getId());
            settingData.setCompany_contact(setting.getCompany_contact());
            settingData.setTelephone_contact(setting.getTelephone_contact());
            settingData.setFax_contact(setting.getFax_contact());
            settingData.setWebsite_name(setting.getWebsite_name());
            settingData.setWebsite_contact(setting.getWebsite_contact());
            settingData.setEmail_contact(setting.getEmail_contact());
            settingData.setAddress_contact(setting.getAddress_contact());
            settingData.setLogo_header_company(setting.getLogo_header_company());
            settingData.setLogo_footer_company(setting.getLogo_footer_company());
            settingData.setCopyright_left(setting.getCopyright_left());
            settingData.setCopyright_right(setting.getCopyright_right());
            settingData.setFacebook(setting.getFacebook());
            settingData.setYoutube(setting.getYoutube());
            settingData.setInstagram(setting.getInstagram());
            settingData.setTwitter(setting.getTwitter());
            settingData.setGoogle(setting.getGoogle());
            settingData.setTiktok(setting.getTiktok());
            settingData.setMeta_title(setting.getMeta_title());
            settingData.setMeta_keyword(setting.getMeta_keyword());
            settingData.setMeta_description(setting.getMeta_description());
            settingData.setMeta_image(setting.getMeta_image());
            settingData.setCreated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            settingData.setCreated_by(String.valueOf(1));
            settingData.setUpdated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            settingData.setUpdated_by(String.valueOf(1));
            settingRepository.save(settingData);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Delete post
     */
    public void delete(Integer id) {
        try {
            settingRepository.deleteById(Math.toIntExact(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
