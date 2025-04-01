package com.aps.ProjectAps;

import com.aps.ProjectAps.entity.Application;
import com.aps.ProjectAps.service.ApplicationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ApplicationServiceTest {

	@Autowired
	private ApplicationService applicationService;

	@Test
	public void testCreateApplication() {
		boolean IsVip = true;
		Application application = new Application();
		application.setProductType("Product A");
		application.setProductProgram("Program X");
		application.setCardType("Credit");
		application.setCampaignCode("CAMPAIGN123");
		application.setIsVip(IsVip);
		application.setAppStatus("PENDING");

		Application savedApp = applicationService.createApplication(application);

		assertNotNull(savedApp);
		assertEquals("Product A", savedApp.getProductType());
	}
}
