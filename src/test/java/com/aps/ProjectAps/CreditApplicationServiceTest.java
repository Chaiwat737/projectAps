package com.aps.ProjectAps;

import com.aps.ProjectAps.entity.CreditApplication;
import com.aps.ProjectAps.repository.CreditApplicationRepository;
import com.aps.ProjectAps.service.CreditApplicationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CreditApplicationServiceTest {

    @Mock
    private CreditApplicationRepository repository;

    @InjectMocks
    private CreditApplicationService service;

    @Test
    void testSaveApplication() {
        CreditApplication application = new CreditApplication();
        application.setName("John Doe");
        application.setIncome(2000.0);
        application.setCreditScore("750");

        when(repository.save(application)).thenReturn(application);

        CreditApplication savedApplication = service.saveApplication(application);
        verify(repository, times(1)).save(application);
    }
}
