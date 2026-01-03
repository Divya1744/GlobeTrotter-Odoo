package com.travelplanner.odoo.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class AuthRequest {
    private String email;
    private String password;
}


