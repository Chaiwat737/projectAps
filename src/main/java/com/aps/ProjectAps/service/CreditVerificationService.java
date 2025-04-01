package com.aps.ProjectAps.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CreditVerificationService {

    private final RestTemplate restTemplate = new RestTemplate();

    public boolean verifyCredit(String creditScore) {
        String creditVerificationServiceUrl = "http://credit-service/verify?score=" + creditScore;
        Boolean isVerified = restTemplate.getForObject(creditVerificationServiceUrl, Boolean.class);
        return isVerified != null && isVerified;
    }
}