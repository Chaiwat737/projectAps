package com.aps.ProjectAps.service;

import com.aps.ProjectAps.entity.CreditApplication;
import com.aps.ProjectAps.repository.CreditApplicationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CreditApplicationServiceImpl implements  CreditApplicationService{
    @Autowired
    private CreditApplicationRepository repository;

    public CreditApplication saveApplication(CreditApplication application) {
        // Save the credit application to the database
        return repository.save(application);
    }

    public CreditApplication validateAndProcess(CreditApplication application) {
        // Process the application and validate income or credit score
        // You could add more complex logic here for validation
        if (application.getIncome() < 1000) {
            throw new IllegalArgumentException("Income too low for application.");
        }
        return saveApplication(application);
    }
    public CreditApplication getApplication(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found with id: " + id));
    }
}
