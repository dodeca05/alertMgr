package com.alertmgr.database.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter

public class AlertLogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String alertServiceName;//어떤 방식으로 알림을 보냈는지
    private String type;//에러 또는 정보
    private String target;//누구에게 보냈는지 all 또는 전부
    private String msg;//메세지
    private LocalDateTime date;//생성 날짜

    public AlertLogEntity() {

    }
}
