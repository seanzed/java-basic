package com.sean.study.spring.ioc;

/**
 * @Description: 轮子类
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-03-11 10:47
 * @Version: 1.0
 */
public class Wheel {

    /**
     * 商标
     */
    private String brand;

    /**
     * 说明书
     */
    private String specification ;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    @Override
    public String toString() {
        return "Wheel{" +
            "brand='" + brand + '\'' +
            ", specification='" + specification + '\'' +
            '}';
    }
}
