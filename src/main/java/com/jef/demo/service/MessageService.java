package com.jef.demo.service;

import com.jef.demo.entity.Message;
import com.jef.demo.repository.MessageRepository;
import com.jef.demo.utils.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Transactional
    public Message insertRandomExtensionMessage(Message message) {
        message.setText(message.getText() + " " + MessageUtils.generateRandomString(5));
        messageRepository.save(message);
        return message;
    }

    public Long getSize() {
        return messageRepository.count();
    }

    public Message getRandomMessage() {
        long generatedLong = (long) (Math.random() * getSize());

        return messageRepository.findById(generatedLong).orElse(new Message());
    }
}
