package org.AdCloud.ad.index;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Application;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Component
public class DataTable implements ApplicationContextAware, PriorityOrdered {

    private static ApplicationContext applicationContext;

    public static final Map<Class, Object> dataTableMap =
            new ConcurrentHashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        DataTable.applicationContext = applicationContext;
    }

    @Override
    public int getOrder() {
        return PriorityOrdered.HIGHEST_PRECEDENCE;
    }

    @SuppressWarnings("all")
    private static <T> T bean(String beanName) {
        return (T) applicationContext.getBean(beanName);
    }

    @SuppressWarnings("all")
    private static <T> T bean(Class className) {
        return (T) applicationContext.getBean(className);
    }

    @SuppressWarnings("all")
    public static <T> T of(Class<T> className) {
        T instance = (T) dataTableMap.get(className);
        if (instance != null) {
            return instance;
        }
        dataTableMap.put(className, bean(className));
        return (T) dataTableMap.get(className);
    }
}
