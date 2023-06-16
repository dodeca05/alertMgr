package com.alertmgr.adapter;

import com.alertmgr.port.AlertService;
import org.springframework.stereotype.Service;

@Service
public class WebHookSendService implements AlertService {
    @Override
    public boolean sendInfo(String msg) {
        return false;
    }

    @Override
    public boolean sendInfoSpecific(String targetID, String msg) {
        return false;
    }

    @Override
    public boolean sendError(String msg) {
        return false;
    }

    @Override
    public boolean sendError(Exception exception) {
        return false;
    }

    @Override
    public boolean sendErrorSpecific(String targetID, String msg) {
        return false;
    }

    @Override
    public boolean sendErrorSpecific(String targetID, Exception exception) {
        return false;
    }
}
