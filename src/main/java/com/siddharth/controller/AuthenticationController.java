package com.siddharth.controller;

import com.siddharth.dto.AuthenticationRequestDTO;
import com.siddharth.dto.AuthenticationResponseDTO;
import com.siddharth.dto.RegisterRequestDTO;
import com.siddharth.service.AuthenticationService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequestDTO registerRequestDTO) {
        AuthenticationResponseDTO token=authenticationService.register(registerRequestDTO);
        return ResponseEntity.ok().body(token);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody AuthenticationRequestDTO request) {
        AuthenticationResponseDTO token=authenticationService.authenticate(request);
        return ResponseEntity.ok().body(token);
    }

    @GetMapping("/logout")
    public ResponseEntity<String> register(HttpServletResponse response) {

        authenticationService.logout();
        return ResponseEntity.ok().build();
    }

}

