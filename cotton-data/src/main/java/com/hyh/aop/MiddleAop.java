package com.hyh.aop;

import com.common.entity.BaseEntity;
import com.common.support.IdWorkerUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * @author hyh
 * @date 2022/10/3 19:22
 */
@Aspect
@Component
public class MiddleAop {

    @Pointcut(value = "@annotation(com.hyh.annotation.IdGenerated)")
    public void save() {
    }

    @Before("save()")
    public void before(JoinPoint joinPoint) throws NoSuchFieldException, IllegalAccessException {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof BaseEntity) {
                BaseEntity entity = (BaseEntity) arg;
                Field field = entity.getClass().getSuperclass().getDeclaredField("id");
                field.setAccessible(true);
                field.set(entity, IdWorkerUtil.getNextStrId());
                System.out.println(entity);
            }
        }
    }

    @AfterThrowing("save()")
    public void afterThrowing(JoinPoint joinPoint) throws NoSuchFieldException, IllegalAccessException {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof BaseEntity) {
                BaseEntity entity = (BaseEntity) arg;
                Field field = entity.getClass().getSuperclass().getDeclaredField("id");
                field.setAccessible(true);
                field.set(entity, null);
            }
        }
    }
}
