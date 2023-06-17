package com.alertmgr.controller;

import com.alertmgr.service.component.AdapterFinder;
import com.alertmgr.dto.AlertRequestDto;
import com.alertmgr.dto.AlertResponseDto;
import io.swagger.annotations.ApiOperation;
import jdk.jshell.spi.ExecutionControl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class alertController {

    final AdapterFinder adapterFinder;
    @GetMapping("/alert")
    @ApiOperation(value = "알림 기능 목록", notes = "현재 사용 가능한 알림 서비스 목록을 조회 합니다.")
    public Set<String> getAlertServiceList() {
        return adapterFinder.getAlertServiceNames();
    }

    @PostMapping("/alert")
    @ApiOperation(value = "알림", notes = "사용자들에게 알림을 보냅니다.")
    public AlertResponseDto createAlert(@RequestBody AlertRequestDto requestDto) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("아직 구현 안됨");
    }
    @PostMapping("/alert/{method}")
    @ApiOperation(value = "알림-Service 지정", notes = "알림 서비스를 지정해서 사용자들에게 알림을 보냅니다.")
    public AlertResponseDto createAlertWithSpecificMethod(@RequestBody AlertRequestDto requestDto, @RequestParam String method) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("아직 구현 안됨");
    }
}
