package com.travelplanner.odoo.controller;


import com.travelplanner.odoo.dto.UserDTO;
import com.travelplanner.odoo.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/admin")
@RequiredArgsConstructor
@RestController
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return adminService.getAllUsers();
    }

}

