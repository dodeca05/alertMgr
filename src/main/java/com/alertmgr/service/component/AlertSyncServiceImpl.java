package com.alertmgr.service.component;

import com.alertmgr.dto.AlertRequestDto;
import com.alertmgr.dto.AlertResponseDto;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.stereotype.Service;

@Service
public class AlertSyncServiceImpl {
    public AlertResponseDto alertToEveryone(AlertRequestDto alertRequestDto) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("아직 구현되지 않음");
    }
}
