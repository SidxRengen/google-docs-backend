package com.siddharth.service;

import com.siddharth.dto.AuthenticationRequestDTO;
import com.siddharth.dto.AuthenticationResponseDTO;
import com.siddharth.dto.RegisterRequestDTO;

public interface AuthenticationService {
    AuthenticationResponseDTO register(RegisterRequestDTO requestAuthenticationResponseDTO);
    AuthenticationResponseDTO authenticate(AuthenticationRequestDTO request);
    void logout();
}
