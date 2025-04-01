package com.aps.ProjectAps.repository;



import com.aps.ProjectAps.entity.userInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<userInfo, Integer> {
    Optional<userInfo> findByEmail(String email);

}
