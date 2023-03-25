package com.example.demo.config;

import com.example.demo.infrastructure.utils.IocUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 项目启动后执行的操作
 *
 * @author 王景阳
 * @date 2023-03-25 17:08
 */
@Slf4j
@Component
public class AppRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) {
        try {
            ConfigurableEnvironment environment = IocUtil.get(ConfigurableEnvironment.class);
            String url = InetAddress.getLocalHost().getHostAddress();
            String port = environment.getProperty("local.server.port");
            log.info("graphql playground: http://{}:{}/playground", url, port);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}