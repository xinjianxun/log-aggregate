package com.aioria.service;

public interface LogAService {

    public void logInfo();

    public void logError();

    public void logThrowsError() throws Exception;

}
