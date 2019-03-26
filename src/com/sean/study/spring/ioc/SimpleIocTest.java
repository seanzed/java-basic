package com.sean.study.spring.ioc;

/**
 * @Description: TODO
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-03-11 10:50
 * @Version: 1.0
 */
public class SimpleIocTest {

    public static void main(String[] args) throws Exception {
        getBean();
    }

    public static void getBean() throws Exception {
        String xmlName = "ioc.xml";
        String location = SimpleIoc.class.getClassLoader().getResource(xmlName).getFile();
        SimpleIoc bf = new SimpleIoc(location);
        Wheel wheel = (Wheel) bf.getBean("wheel");
        System.out.println(wheel);
        Car car = (Car) bf.getBean("car");
        System.out.println(car);
    }
}
