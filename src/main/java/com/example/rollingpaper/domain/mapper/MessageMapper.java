package com.example.rollingpaper.domain.mapper;

import com.example.rollingpaper.domain.PostMessageRequest;
import com.example.rollingpaper.domain.dto.MessageDto;
import com.example.rollingpaper.domain.dto.PostMessageRequestDto;
import com.example.rollingpaper.domain.entity.Message;

public interface MessageMapper {

    PostMessageRequest fromDto(PostMessageRequestDto dto);

    MessageDto toDto(Message message) ;
}
