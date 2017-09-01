package aop;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Author: li_zhilei
 * @Date: create in 10:59 17/7/18.
 * @description:
 */
public class TargetAdvice implements MethodBeforeAdvice,AfterReturningAdvice {
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println(" after target Method execute ");
    }

    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(" before target Method execute ");
    }
}
