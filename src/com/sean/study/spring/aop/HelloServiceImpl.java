package com.sean.study.spring.aop;

/**
 * @Description: TODO
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-03-11 15:34
 * @Version: 1.0
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHelloWorld() {
        System.out.println("hello world!");
    }
}
