package com.jef.demo.controller;

import com.jef.demo.entity.Message;
import com.jef.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping
    public ResponseEntity<Message> insertRandomExtensionMessage(@RequestBody Message message) {
        return new ResponseEntity<>(messageService.insertRandomExtensionMessage(message), HttpStatus.CREATED);
    }

    @GetMapping("/get-random-message")
    public ResponseEntity<Message> getRandomMessage() {
        return new ResponseEntity<>(messageService.getRandomMessage(),HttpStatus.OK);
    }


}
