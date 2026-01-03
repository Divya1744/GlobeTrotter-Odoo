package com.travelplanner.odoo.service;



import com.travelplanner.odoo.dto.UserDTO;
import com.travelplanner.odoo.model.UserEntity;
import com.travelplanner.odoo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final UserRepository userRepository;

    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        List<UserDTO> userList = users.stream()
                .map(user -> new UserDTO(user.getEmail(),user.getUsername(),user.isVerified())).toList();
        return ResponseEntity.ok(userList);
    }
}

