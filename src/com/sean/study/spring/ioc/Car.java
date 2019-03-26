package com.sean.study.spring.ioc;

/**
 * @Description: 轿车类
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-03-11 10:45
 * @Version: 1.0
 */
public class Car {

    /**
     * 名称
     */
    private String name;

    /**
     * 长度
     */
    private String length;

    /**
     * 宽度
     */
    private String width;

    /**
     * 高度
     */
    private String height;

    /**
     * 轮子类
     */
    private Wheel wheel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public Wheel getWheel() {
        return wheel;
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    @Override
    public String toString() {
        return "Car{" +
            "name='" + name + '\'' +
            ", length='" + length + '\'' +
            ", width='" + width + '\'' +
            ", height='" + height + '\'' +
            ", wheel=" + wheel +
            '}';
    }
}
