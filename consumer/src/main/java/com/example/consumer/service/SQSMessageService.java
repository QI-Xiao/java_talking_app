package com.example.consumer.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SQSMessageService {

    @Autowired
    private AmazonSQS sqsClient;

    public void receiveMessage(String queueName){
        System.out.println("Receiving messages from MyQueue.\n");
        String queueUrl = getQueueUrl(queueName);
        final ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(queueUrl);
        final List<Message> msg = sqsClient.receiveMessage(receiveMessageRequest).getMessages();

        for (final Message message : msg) {
            System.out.println("Message");
            System.out.println("  MessageId:     " + message.getMessageId());
            System.out.println("  ReceiptHandle: " + message.getReceiptHandle());
            System.out.println("  MD5OfBody:     " + message.getMD5OfBody());
            System.out.println("  Body:          " + message.getBody());
            Map<String,String> messageAttributes = message.getAttributes();
            for (final Map.Entry<String, String> entry : messageAttributes.entrySet()) {
                System.out.println("Attribute");
                System.out.println("  Name:  " + entry.getKey());
                System.out.println("  Value: " + entry.getValue());
            }
            sqsClient.deleteMessage(queueUrl, message.getReceiptHandle());
        }
        System.out.println();
    }

    public String getQueueUrl(String queueName){
        return sqsClient.getQueueUrl(queueName).getQueueUrl();
    }
}
