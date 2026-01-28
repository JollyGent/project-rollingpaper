package com.example.rollingpaper.service;

import com.example.rollingpaper.domain.PostMessageRequest;
import com.example.rollingpaper.domain.entity.Message;

import java.util.List;

public interface RollingPaperService {

    Message postMessage(PostMessageRequest request);


    List<Message> listMessages();


}
