package com.alertmgr.dto;

import com.alertmgr.database.entity.AlertLogEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Getter
public class AlertResponseDto {
    List<String> methods;
    String type;
    int level;
    String msg;
    LocalDateTime date;
    public AlertLogEntity toEntity()
    {
        AlertLogEntity alertLog = new AlertLogEntity();
        String methodNames="";
        for (String temp:methods) {
            methodNames+=temp+",";
        }
        methodNames = methodNames.substring(0, methodNames.length() - 1);

        alertLog.setAlertServiceName(methodNames);
        alertLog.setType(type);
        alertLog.setTarget("All");
        alertLog.setMsg(msg);
        alertLog.setDate(date);

        return alertLog;
    }
}
