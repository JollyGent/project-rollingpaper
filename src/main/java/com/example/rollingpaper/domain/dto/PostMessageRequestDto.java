package com.example.rollingpaper.domain.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record PostMessageRequestDto(
        @NotBlank (message = ERROR_MESSAGE_LENGTH)
        @Length(max = 1000, message = ERROR_MESSAGE_LENGTH)
        String message
) {

    private static final String ERROR_MESSAGE_LENGTH =
            "Message text limit is 1000 characters.";
}
