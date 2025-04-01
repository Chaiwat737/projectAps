package com.aps.ProjectAps.controller;

import com.aps.ProjectAps.entity.CreditApplication;
import com.aps.ProjectAps.service.CreditApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
@RestController
@RequestMapping("/api/credit-applications")
public class CreditApplicationController {

    @Autowired
    private CreditApplicationService service;

    @RequestMapping(value = "createApplication", method = RequestMethod.POST)
    public CreditApplication createApplication(@Valid @RequestBody CreditApplication application) {
        return service.validateAndProcess(application);
    }

    @RequestMapping(value = "getApplication", method = RequestMethod.GET)
    public CreditApplication getApplication(@RequestParam(value = "id",required = false) Long id) {
        return service.getApplication(id);
    }
}
