package com.aioria.controller;

import com.aioria.feign.UserClient;
import com.aioria.msg.ObjectRestResponse;
import com.aioria.service.LogAService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
@Slf4j
public class LogController {

    @Autowired
    private LogAService logAService;

    @Autowired
    private UserClient userClient;

    @RequestMapping("info")
    public String logInfo() {
        logAService.logInfo();
        return "测试日志打印";
    }

    @RequestMapping("error")
    public String logError() {
        logAService.logError();
        return "测试错误日志打印";
    }

    @RequestMapping("throwserror")
    public String logThrowsError() throws Exception {
        logAService.logThrowsError();
        return "测试异常抛出日志打印";
    }

    @RequestMapping("/user/{id}")
    public ObjectRestResponse getUser(@PathVariable("id") Long id) throws Exception {
        log.info("准备获取用户");
        return userClient.getUser(id);
    }
}
