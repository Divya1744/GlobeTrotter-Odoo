package com.travelplanner.odoo.controller;



import com.travelplanner.odoo.dto.*;
import com.travelplanner.odoo.model.UserEntity;
import com.travelplanner.odoo.repository.UserRepository;
import com.travelplanner.odoo.service.AuthService;
import com.travelplanner.odoo.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;
    private final EmailService emailService;
    private final UserRepository userRepository;

    @GetMapping("/home")
    public String home(){
        return "welcome";
    }
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request){
        RegisterResponse response = authService.register(request);
        String otp = authService.generateOtp();
        long expiryTime = authService.generateOtpExpiry();
        UserEntity user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found"));
        user.setVerifyOtpExpiry(expiryTime);
        user.setVerifyOtp(otp);
        userRepository.save(user);
        emailService.welcomeMailWithOtp(response,otp);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/verify")
    public void verifyEmail(@RequestBody Map<String,String> request){
        authService.verifyEmail(request.get("email"),request.get("otp"));
    }

    @PostMapping("/refresh")
    public ResponseEntity<RefreshTokenResponse> refresh(@RequestBody RefreshTokenRequest request){
        return authService.refresh(request);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestBody LogoutRequest request){
        return authService.logout(request);
    }
}

