package com.aps.ProjectAps.service;

import com.aps.ProjectAps.entity.Application;

import java.util.List;
import java.util.Optional;


public interface ApplicationService {



    public Application createApplication(Application application);

    public List<Application> getAllApplications() ;

    public Optional<Application> getApplicationById(Integer appId) ;

    public Application updateApplication(Integer appId, Application application) ;

    public boolean deleteApplication(Integer appId) ;
}
