package org.example.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest
public class SQSMessageServiceTest {

    @Autowired
    SQSMessageService sqsMessageService;

    @Autowired
    private AmazonSQS sqs;

    @Mock
    private GetQueueUrlResult getQueueUrlResult;

    @Test
    public void sendMessageTest(){
        when(sqs.getQueueUrl(anyString())).thenReturn(getQueueUrlResult);

        sqsMessageService.sendMessage(anyString(), "anyString()", 5);

        verify(sqs, times(1)).sendMessage(any(SendMessageRequest.class));
    }
}
