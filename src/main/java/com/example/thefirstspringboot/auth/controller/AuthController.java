package com.example.thefirstspringboot.auth.controller;

import com.example.thefirstspringboot.auth.dto.LoginRequestDto;
import com.example.thefirstspringboot.auth.dto.LoginResponseDto;
import com.example.thefirstspringboot.auth.dto.RegisterRequestDto;
import com.example.thefirstspringboot.auth.service.AuthService;
import com.example.thefirstspringboot.common.util.RestResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Auth", description = "Auth API")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad Request")
    })
    public ResponseEntity<RestResponse<LoginResponseDto>> register(
            @Valid @RequestBody RegisterRequestDto request
    ) {
        try {
            LoginResponseDto response = authService.register(request);
            return new RestResponse<LoginResponseDto>().withData(response).buildHttpResponseEntity();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return new RestResponse<LoginResponseDto>()
                    .withMessage(e.getMessage())
                    .withStatusCode(400)
                    .buildHttpResponseEntity();
        }

    }

    @PostMapping("/login")
    public ResponseEntity<RestResponse<LoginResponseDto>> authenticate(
            @RequestBody LoginRequestDto request
    ) {
        LoginResponseDto response = authService.login(request);

        return new RestResponse<LoginResponseDto>().withData(response).buildHttpResponseEntity();
    }
}
