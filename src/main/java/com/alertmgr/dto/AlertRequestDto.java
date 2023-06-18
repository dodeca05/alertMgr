package com.alertmgr.dto;

import lombok.Getter;

@Getter
public class AlertRequestDto {
    public int logLevel;
    public String logType;
    public String msg;
}
