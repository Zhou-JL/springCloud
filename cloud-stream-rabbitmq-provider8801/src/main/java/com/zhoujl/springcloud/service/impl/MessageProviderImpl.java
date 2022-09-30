package com.zhoujl.springcloud.service.impl;


import com.zhoujl.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;

import org.springframework.messaging.MessageChannel;
import org.springframework.integration.support.MessageBuilder;

import javax.annotation.Resource;

import org.springframework.cloud.stream.messaging.Source;

import java.util.UUID;

/**
 * @Author: zjl
 * @company: 北京汉唐智创科技有限公司
 * @time: 2022-4-13 17:00
 * @see: com.zhoujl.springcloud.service.impl
 * @Version: 1.0
 */
@EnableBinding(Source.class) //定义消息的推送管道
public class MessageProviderImpl implements IMessageProvider {
    @Resource
    private MessageChannel output; // 消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*****serial: " + serial);
        return null;
    }
}
