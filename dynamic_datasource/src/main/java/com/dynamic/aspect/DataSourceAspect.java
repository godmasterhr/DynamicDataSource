package com.dynamic.aspect;


import com.dynamic.anno.DataSource;
import com.dynamic.util.DBContextHolder;
import org.apache.ibatis.binding.MapperMethod;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by hr on 2017/10/9.
 */
public class DataSourceAspect {

    /**
     * 前置方法
     * @param point
     */
    public void intercept(JoinPoint point){
        //1.获取目标对象的类类型
        Class<?> target = point.getTarget().getClass();
        //2.获取目标方法的签名对象
        MethodSignature methodSignature = (MethodSignature)point.getSignature();
        //接口上注解
        for (Class<?> clazz : target.getInterfaces()) {
            //获取接口上的注解 为DBContextHolder赋值
            resolveDataSource(clazz,methodSignature.getMethod());
        }
        //类上的注解
        resolveDataSource(target,methodSignature.getMethod());

    }

    public void resolveDataSource(Class<?> clazz,Method method){
        try {
            //类上有注解
            Class<?>[] parameterTypes = method.getParameterTypes();
            if(clazz.isAnnotationPresent(DataSource.class)){
                DataSource anno = clazz.getAnnotation(DataSource.class);
                DBContextHolder.setDBType(anno.value());
            }
            //方法上也有注解
            Method m = clazz.getMethod(method.getName(), parameterTypes);
            if(m!=null&&m.isAnnotationPresent(DataSource.class)){
                DataSource source = m.getAnnotation(DataSource.class);
                DBContextHolder.setDBType(source.value());
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }



}
