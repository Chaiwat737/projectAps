package com.aps.ProjectAps.repository;

import com.aps.ProjectAps.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {
}
