package com.aps.ProjectAps.controller;

import com.aps.ProjectAps.entity.Application;
import com.aps.ProjectAps.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;


    @RequestMapping(value = "createApplication", method = RequestMethod.POST)
    public ResponseEntity<Application> createApplication(@RequestBody Application application) {
        Application createdApp = applicationService.createApplication(application);
        return ResponseEntity.ok(createdApp);
    }


    @RequestMapping(value = "getAllApplications", method = RequestMethod.GET)
    public List<Application> getAllApplications() {
        return applicationService.getAllApplications();
    }

    @RequestMapping(value = "getApplicationById/{appId}", method = RequestMethod.POST)
    public ResponseEntity<Application> getApplicationById(@PathVariable Integer appId) {
        Optional<Application> application = applicationService.getApplicationById(appId);
        return application.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "updateApplication/{appId}", method = RequestMethod.PUT)
    public ResponseEntity<Application> updateApplication(@PathVariable Integer appId, @RequestBody Application application) {
        Application updatedApp = applicationService.updateApplication(appId, application);
        return updatedApp != null ? ResponseEntity.ok(updatedApp) : ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "deleteApplication/{appId}", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteApplication(@PathVariable Integer appId) {
        return applicationService.deleteApplication(appId) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}