package com.example.niitiproduct.services;

import com.example.niitiproduct.dto.UserDTO;
import com.example.niitiproduct.mapper.UserMapper;
import com.example.niitiproduct.models.User;
import com.example.niitiproduct.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<Object> getAllUsers() {
        List<User> userList = userRepository.findAll();
        if (userList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    /**
     * Get all users
     * @return
     */
    public List<UserDTO> getAll() {
        return userRepository.findAll().stream().map(e->userMapper.toDTO(e)).toList();
    }

    /**
     * Search by user name
     * @param name
     * @return
     */
    public List<User> searchByName(String name) {
        return userRepository.findByNameContaining(name);
    }

    /**
     * Edit user
     * @param id
     * @return
     */
    public User findById(Long id) {
        return userRepository.findById(Math.toIntExact(id)).get();
    }

    /**
     * Insert/Update user
     * @param user
     * @return
     */
    public boolean save(User user) {
        try {
            User userData = new User();
            userData.setId(user.getId());
            userData.setName(user.getName());
            userData.setEmail(user.getEmail());
            userData.setEmail_verified_at(user.getEmail_verified_at());
            userData.setPassword(user.getPassword());
            userData.setRemember_token(user.getRemember_token());
            userData.setCreated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            userData.setCreated_by(String.valueOf(1));
            userData.setUpdated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            userData.setUpdated_by(String.valueOf(1));
            userRepository.save(userData);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    /**
     * Delete user
     * @param id
     */
    public void delete(Long id) {
        try {
            userRepository.deleteById(Math.toIntExact(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
