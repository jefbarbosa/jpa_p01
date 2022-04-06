package com.jef.demo.service;

import com.jef.demo.entity.Message;
import com.jef.demo.repository.MessageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MessageServiceUnitTest {

    @Mock
    private MessageRepository messageRepository;

    private MessageService messageService;

    @BeforeEach
    private void initConfig() {
        MockitoAnnotations.openMocks(this);
        messageService = new MessageService(messageRepository);
    }

    @Test
    void insertRandomExtensionMessageTest() {
        Mockito.when(messageRepository.save(Mockito.any())).thenReturn(new Message(1L, "XYZ"));
        Message msg = messageService.insertRandomExtensionMessage(new Message(1L, "XYZ"));

        assertNotEquals("XYZ", msg.getText());

    }

}
