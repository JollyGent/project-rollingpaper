package com.example.rollingpaper.domain.mapper.impl;

import com.example.rollingpaper.domain.PostMessageRequest;
import com.example.rollingpaper.domain.dto.MessageDto;
import com.example.rollingpaper.domain.dto.PostMessageRequestDto;
import com.example.rollingpaper.domain.entity.Message;
import com.example.rollingpaper.domain.mapper.MessageMapper;
import org.springframework.stereotype.Component;

@Component
public class MessageMapperImpl implements MessageMapper {
    @Override
    public PostMessageRequest fromDto(PostMessageRequestDto dto) {
        return new PostMessageRequest(dto.message());
    }

    @Override
    public MessageDto toDto(Message message) {
        return new MessageDto(message.getId(),message.getMessage());
    }
}
