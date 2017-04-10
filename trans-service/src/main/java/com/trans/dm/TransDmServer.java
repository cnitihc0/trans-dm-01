package com.trans.dm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author mashaobo
 * @date 17/3/22
 * @blog http://blog.csdn.net/cnitihc0
 * @email cnitihc0@163.com
 */
@SpringBootApplication
@ImportResource("classpath:application-*.xml")
public class TransDmServer {
    public static void main(String[] args) {
        SpringApplication.run(TransDmServer.class, args);
    }

}
