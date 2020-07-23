package com.lml.qrzt.config;

import org.quartz.Scheduler;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.io.IOException;
import java.util.Properties;

/**
 * creator：李茂林
 * date: 2020/7/22
 */
@Configuration
public class SchedulerConfig {
    /**
     * 调度器工厂对象,并设置quartz属性
     * @return
     * @throws IOException
     */
    @Bean(name="SchedulerFactory")
    public SchedulerFactoryBean schedulerFactoryBean(@Qualifier("quartzProperties") Properties quartzProperties) throws IOException {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setQuartzProperties(quartzProperties);
        return factory;
    }

    /**
     * 加载quartz的配置
     * @return
     * @throws IOException
     */
    @Bean(name = "quartzProperties")
    public Properties quartzProperties() throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
        //在quartz.properties中的属性被读取并注入后再初始化对象
        propertiesFactoryBean.afterPropertiesSet();
        return propertiesFactoryBean.getObject();
    }

    /*
     * quartz初始化监听器
     */
    @Bean
    public QuartzInitializerListener executorListener() {
        return new QuartzInitializerListener();
    }

    /*
     * 通过SchedulerFactoryBean获取Scheduler 调度器的实例
     */
    @Bean(name="Scheduler")
    public Scheduler scheduler( SchedulerFactoryBean schedulerFactoryBean) throws IOException {
        return schedulerFactoryBean.getScheduler();
    }

}