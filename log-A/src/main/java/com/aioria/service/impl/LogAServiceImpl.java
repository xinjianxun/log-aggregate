package com.aioria.service.impl;

import com.aioria.service.LogAService;
import com.aioria.util.LoggerUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;

@Slf4j
@Service
public class LogAServiceImpl implements LogAService {

    @Override
    public void logInfo() {
        log.info("测试Info日志打印123");
    }

    @Override
    public void logError() {
        try {

            int x = 1/0;
        }catch(Exception e) {
            log.error(LoggerUtil.getTrace(e));
        }

    }


    @Override
    public void logThrowsError() throws Exception{
        File file = new File("abc");
        FileInputStream fis = new FileInputStream(file);

    }



}
