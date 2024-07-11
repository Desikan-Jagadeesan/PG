package com.palani.PoultryAssist.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;
import software.amazon.awssdk.services.sns.model.SnsException;

@Service
public class AWSSNSService {

    private final SnsClient snsClient;

    @Autowired
    public AWSSNSService(SnsClient snsClient) {
        this.snsClient = snsClient;
    }

    public void sendSms(String phoneNumber, String message) {
        try {
            PublishRequest request = PublishRequest.builder()
                    .message(message)
                    .phoneNumber(phoneNumber) // Phone number must be in E.164 format
                    .build();

            PublishResponse response = snsClient.publish(request);

            System.out.println("SMS sent successfully with message ID: " + response.messageId());
        } catch (SnsException e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            // Log the error or take other appropriate action
        }
    }
}
