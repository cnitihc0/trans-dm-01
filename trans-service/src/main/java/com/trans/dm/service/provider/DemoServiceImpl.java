package com.trans.dm.service.provider;

import com.trans.dm.service.api.DemoService;

/**
 * @author mashaobo
 * @date 17/3/22
 * @blog http://blog.csdn.net/cnitihc0
 * @email cnitihc0@163.com
 */
public class DemoServiceImpl implements DemoService {
    public String sayHello(String name) {
        return "Hello World";
    }
}
