package com.example.demo.service;

import com.example.demo.dto.UserRequestDto;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import com.example.demo.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponseDto signup (UserRequestDto dto) {
        User saved = userRepository.save(
                User.builder()
                        .email(dto.getEmail())
                        .username(dto.getUsername())
                        .password(passwordEncoder.encode(dto.getPassword()))
                .build()
        );
        return UserResponseDto.builder()
                .id(saved.getId())
                .email(saved.getEmail())
                .username(saved.getUsername())
                .build();
    }
}
