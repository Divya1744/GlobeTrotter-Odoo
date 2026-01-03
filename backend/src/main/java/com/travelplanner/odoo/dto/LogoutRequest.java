package com.travelplanner.odoo.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class LogoutRequest {
    private String email;
}

