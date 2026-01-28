package com.example.rollingpaper.service.impl;

import com.example.rollingpaper.domain.PostMessageRequest;
import com.example.rollingpaper.domain.entity.Message;
import com.example.rollingpaper.repository.MessageRepository;
import com.example.rollingpaper.service.RollingPaperService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RollingPaperServiceImpl implements RollingPaperService {

    private final MessageRepository messageRepository;

    public RollingPaperServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    @Override
    public Message postMessage(PostMessageRequest request) {

        Message message = new Message(
                null,
                request.message()
        );

        return messageRepository.save(message);
    }

    @Override
    public List<Message> listMessages() {
        return messageRepository.findAll();
    }
}
