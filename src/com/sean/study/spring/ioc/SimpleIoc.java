package com.sean.study.spring.ioc;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 * @Description: 模拟spring ioc
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-03-11 9:56
 * @Version: 1.0
 */
public class SimpleIoc {

    private HashMap<String, Object> beanMap = new HashMap<>();

    public SimpleIoc(String location) throws Exception {
        loadBeans(location);
    }

    public Object getBean(String name) {
        Object bean = beanMap.get(name);
        if (bean == null) {
            throw new IllegalArgumentException("there is no bean with name " + name);
        }

        return bean;
    }

    private void loadBeans(String location) throws Exception {

        // 加载xml配置文件
        try (InputStream fileInputStream = new FileInputStream(location)) {
            // 创建一个文档解析器工厂
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            //用上面的工厂创建一个文档解析器
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            //用上面的文档解析器解析一个文件放到document对象里
            Document doc = documentBuilder.parse(location);
            Element root = doc.getDocumentElement();
            NodeList nodes = root.getChildNodes();

            // 遍历节点
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);

                if (node instanceof Element) {
                    Element ele = (Element) node;
                    String id = ele.getAttribute("id");
                    String className = ele.getAttribute("class");

                    // 加载beanClass
                    Class beanClass = null;

                    try {
                        beanClass = Class.forName(className);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                        return;
                    }

                    // 创建bean
                    Object bean = beanClass.newInstance();

                    // 遍历property标签
                    NodeList propertyNodes = ele.getElementsByTagName("property");

                    for (int j = 0; j < propertyNodes.getLength(); j++) {
                        Node propertyNode = propertyNodes.item(j);

                        if (propertyNode instanceof Element) {
                            Element propertyElement = (Element) propertyNode;
                            String name = propertyElement.getAttribute("name");
                            String value = propertyElement.getAttribute("value");

                            // 利用反射将bean相关访问权限设置为可访问
                            Field declaredField = bean.getClass().getDeclaredField(name);
                            declaredField.setAccessible(true);

                            if (value != null && value.length() > 0) {
                                // 将属性填充到相关字段中
                                declaredField.set(bean, value);
                            } else {
                                String ref = propertyElement.getAttribute("ref");

                                if (ref == null || ref.length() == 0) {
                                    throw new IllegalArgumentException("ref config error");
                                }

                                // 将引用填充到相关字段中
                                declaredField.set(bean, getBean(ref));
                            }

                            // 将bean注册到容器中

                            registerBean(id, bean);

                        }
                    }
                }
            }
        }
    }

    private void registerBean(String id, Object bean) {
        beanMap.put(id, bean);
    }
}
