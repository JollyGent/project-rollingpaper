package com.example.rollingpaper.domain.dto;

import java.util.UUID;

public record MessageDto(
        UUID id,
        String message
) {
}
