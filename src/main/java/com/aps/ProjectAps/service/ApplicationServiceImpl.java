package com.aps.ProjectAps.service;

import com.aps.ProjectAps.entity.Application;
import com.aps.ProjectAps.repository.ApplicationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ApplicationServiceImpl implements  ApplicationService{
    @Autowired
    private ApplicationRepository applicationRepository;

    public Application createApplication(Application application) {
        application.setCreatedOn(LocalDateTime.now());
        application.setModifiedOn(LocalDateTime.now());
        return applicationRepository.save(application);
    }

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    public Optional<Application> getApplicationById(Integer appId) {
        return applicationRepository.findById(appId);
    }

    public Application updateApplication(Integer appId, Application application) {
        if (applicationRepository.existsById(appId)) {
            application.setAppId(appId);
            application.setModifiedOn(LocalDateTime.now());
            return applicationRepository.save(application);
        }
        return null;
    }

    public boolean deleteApplication(Integer appId) {
        if (applicationRepository.existsById(appId)) {
            applicationRepository.deleteById(appId);
            return true;
        }
        return false;
    }
}
