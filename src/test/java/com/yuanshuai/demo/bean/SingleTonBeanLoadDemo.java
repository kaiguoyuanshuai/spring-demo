package com.yuanshuai.demo.bean;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2018/9/21
 */
public class SingleTonBeanLoadDemo {

    /**
     * 演示一个没有任何内容的bean 的加载过程
     */
    @Test
    public void loadSingonTenBean() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("application-ioc-1.xml");
        SingletonBean singletonBean = (SingletonBean) classPathXmlApplicationContext.getBean("singletonBean");
        System.out.println(singletonBean);
    }


    /**
     * 演示从 singleTon 缓存中获取 bean
     */
    @Test
    public void loadSingonTenBeanTwice() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("application-ioc-1.xml");
        SingletonBean singletonBean = (SingletonBean) classPathXmlApplicationContext.getBean("singletonBean");
        SingletonBean singletonBean2 = (SingletonBean) classPathXmlApplicationContext.getBean("singletonBean");
        System.out.println(singletonBean);
        System.out.println(singletonBean2);
    }


    /**
     * 演示一个接口初始化bean的时候报错
     */
    @Test
    public void loadSingonTenBeanInteface() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("application-ioc-2.xml");
        SingletonBeanInterface singletonBean = (SingletonBeanInterface) classPathXmlApplicationContext.getBean("singletonBeanFace");
        System.out.println(singletonBean);
    }


}
