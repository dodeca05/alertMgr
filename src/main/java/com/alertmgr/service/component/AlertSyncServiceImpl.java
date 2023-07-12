package com.alertmgr.service.component;

import com.alertmgr.dto.AlertRequestDto;
import com.alertmgr.dto.AlertResponseDto;
import com.alertmgr.service.port.AlertService;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class AlertSyncServiceImpl {

    private List<AlertService>[] alertServiceLayer;
    final AlertServiceManager alertServiceManager;
    @Autowired
    public AlertSyncServiceImpl(AlertServiceManager alertServiceManager)
    {
        this.alertServiceManager = alertServiceManager;
        alertServiceLayer=new List[3];
        //TODO : 이걸 별도의 파일로 관리하도록 하자 yaml 같은거
        alertServiceLayer[0]=new ArrayList<AlertService>();
        alertServiceLayer[0].add(alertServiceManager.findAlertServiceByClassName("FrontMonitorService"));
        //
        alertServiceLayer[1]=new ArrayList<AlertService>();
        alertServiceLayer[1].add(alertServiceManager.findAlertServiceByClassName("STMPservice"));
        //
        alertServiceLayer[2]=new ArrayList<AlertService>();
        alertServiceLayer[2].add(alertServiceManager.findAlertServiceByClassName("WebHookSendService"));
        //
    }

    public AlertResponseDto alertToEveryone(AlertRequestDto alertRequestDto) throws ExecutionControl.NotImplementedException {

        List<String> methodList=new ArrayList<String>();
        for(int logLevel=0;logLevel<=alertRequestDto.getLogLevel()&&logLevel< alertServiceLayer.length;logLevel++)
        {
            for(AlertService alertService : alertServiceLayer[logLevel])
            {
                methodList.add(alertService.getClass().getName());
                if(alertRequestDto.getLogType().equals("INFO"))
                {
                    alertService.sendInfo(alertRequestDto.getMsg());
                }
                else if (alertRequestDto.getLogType().equals("ERROR"))
                {
                    alertService.sendError(alertRequestDto.getMsg());
                }
            }
        }
        return alertRequest2Response(methodList,alertRequestDto);
    }

    public AlertResponseDto alertWithSpecificMethod(String methodName,AlertRequestDto alertRequestDto) throws ExecutionControl.NotImplementedException {
        AlertService alertService=alertServiceManager.findAlertServiceByClassName(methodName);
        if(alertRequestDto.getLogType().equals("INFO"))
            alertService.sendInfo(alertRequestDto.getMsg());
        else if(alertRequestDto.getLogType().equals("ERROR"))
            alertService.sendError(alertRequestDto.getMsg());
        return alertRequest2Response(methodName,alertRequestDto);
    }

    private AlertResponseDto alertRequest2Response(String method,AlertRequestDto alertRequestDto)throws ExecutionControl.NotImplementedException
    {
        ArrayList<String> methods=new ArrayList<>();
        methods.add(method);
        AlertResponseDto result = new AlertResponseDto(methods,alertRequestDto.getLogType(),alertRequestDto.getLogLevel(),alertRequestDto.getMsg(), LocalDateTime.now());
        return result;
    }
    private AlertResponseDto alertRequest2Response(List<String> methodList,AlertRequestDto alertRequestDto)throws ExecutionControl.NotImplementedException
    {
        AlertResponseDto result = new AlertResponseDto(methodList,alertRequestDto.getLogType(),alertRequestDto.getLogLevel(),alertRequestDto.getMsg(), LocalDateTime.now());
        return result;
    }
}
