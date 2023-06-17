package com.alertmgr.database.entity;

import java.util.Date;

public class AlertLogEntity {
    public String alertServiceName;//어떤 방식으로 알림을 보냈는지
    public String type;//에러 또는 정보
    public String target;//누구에게 보냈는지 all 또는 전부
    public String msg;//메세지
    public Date date;//생성 날짜
}
