package com.tensquare.base.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 李聪
 * @date 2020/3/29 12:52
 * 消息总线刷新配置
 */

@RestController
@RefreshScope
public class TestController {
    @Value("${sms.ip}")
    private String ip;

    @RequestMapping(value = "/ip",method = RequestMethod.GET)
    public String ip() {
        return ip;
    }

}
