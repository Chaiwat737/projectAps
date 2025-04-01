package com.aps.ProjectAps.service;

import com.aps.ProjectAps.entity.CreditApplication;

public interface CreditApplicationService {


    public CreditApplication saveApplication(CreditApplication application) ;

    public CreditApplication validateAndProcess(CreditApplication application) ;
    public CreditApplication getApplication(Long id);
}
