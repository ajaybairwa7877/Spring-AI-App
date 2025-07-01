package com.spring.ai.controller;


import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.stringtemplate.v4.ST;

@RestController
@RequestMapping("/ai")
public class ChatController {

    @Autowired
    ChatModel chatModel;

    @GetMapping("/chat")
    public String getResponse(@RequestParam String message){
        return chatModel.call(new Prompt(message)).getResult().getOutput().getText();
    }

}
