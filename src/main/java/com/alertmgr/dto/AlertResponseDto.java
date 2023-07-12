package com.alertmgr.dto;

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
}
