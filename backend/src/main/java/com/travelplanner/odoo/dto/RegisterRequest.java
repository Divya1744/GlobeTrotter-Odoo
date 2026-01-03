package com.travelplanner.odoo.dto;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterRequest {
    @NotBlank(message = "Name should not be empty")
    private String username;
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String confirmPassword;
    @Email(message = "Enter valid Email address")
    @NotNull(message = "Email should not be empty")
    private String email;
    private String phoneNumber;
    private String city;
    private String country;
}

