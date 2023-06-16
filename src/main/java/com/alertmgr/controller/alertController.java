package com.alertmgr.controller;

import com.alertmgr.component.AdapterFinder;
import com.alertmgr.dto.AlertRequestDto;
import com.alertmgr.dto.AlertResponseDto;
import jdk.jshell.spi.ExecutionControl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class alertController {

    final AdapterFinder adapterFinder;
    @GetMapping("/alert")
    public List<String> getAlertServiceList() {
        return adapterFinder.findAlertServiceNames();
    }

    @PostMapping("/alert")
    public AlertResponseDto createAlert(@RequestBody AlertRequestDto requestDto) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("아직 구현 안됨");
    }
    @PostMapping("/alert/{method}")
    public AlertResponseDto createAlertWithSpecificMethod(@RequestBody AlertRequestDto requestDto, @RequestParam String method) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("아직 구현 안됨");
    }
}
