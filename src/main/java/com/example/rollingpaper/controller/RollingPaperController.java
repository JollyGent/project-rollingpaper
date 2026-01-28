package com.example.rollingpaper.controller;


import com.example.rollingpaper.domain.PostMessageRequest;
import com.example.rollingpaper.domain.dto.MessageDto;
import com.example.rollingpaper.domain.dto.PostMessageRequestDto;
import com.example.rollingpaper.domain.entity.Message;
import com.example.rollingpaper.domain.mapper.MessageMapper;
import com.example.rollingpaper.service.RollingPaperService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/messages")
public class RollingPaperController {

    private final RollingPaperService rollingPaperService;
    private final MessageMapper messageMapper;


    public RollingPaperController(RollingPaperService rollingPaperService, MessageMapper messageMapper) {
        this.rollingPaperService = rollingPaperService;
        this.messageMapper = messageMapper;
    }



    @PostMapping
    public ResponseEntity<MessageDto> postMessage(
        @Valid @RequestBody PostMessageRequestDto postMessageRequestDto
    ) {
       PostMessageRequest postMessageRequest =  messageMapper.fromDto(postMessageRequestDto);
       Message message = rollingPaperService.postMessage(postMessageRequest);
       MessageDto postMessageDto = messageMapper.toDto(message);
       return new ResponseEntity<>(postMessageDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MessageDto>> getMessages() {
        List<Message> messages = rollingPaperService.listMessages();
        List<MessageDto> messageDtos = messages.stream().map(messageMapper::toDto).toList();
        return ResponseEntity.ok(messageDtos);
    }

}
