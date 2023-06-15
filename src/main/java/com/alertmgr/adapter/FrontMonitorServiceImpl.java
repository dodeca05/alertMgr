package com.alertmgr.adapter;

import com.alertmgr.port.alertService;

public class FrontMonitorServiceImpl implements alertService {
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
