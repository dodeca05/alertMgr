package com.alertmgr.database.repository;

import com.alertmgr.database.entity.AlertLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertLogRepository extends JpaRepository<AlertLogEntity,String> {
}
