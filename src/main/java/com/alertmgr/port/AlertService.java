package com.alertmgr.port;

public interface AlertService {
    boolean sendInfo(String msg);
    boolean sendInfoSpecific(String targetID,String msg);
    boolean sendError(String msg);
    boolean sendError(Exception exception);
    boolean sendErrorSpecific(String targetID, String msg);
    boolean sendErrorSpecific(String targetID, Exception exception);

}
