package cn.microboat.Spring50Errors.service;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

/**
 * @author zhouwei
 */
@Aspect
@Service
@Slf4j
public class AspectService {

    /**
     * 鉴权
     * */
    @Before("execution(* cn.microboat.Spring50Errors.service.ElectricService.charge())")
    public void checkAuthority(JoinPoint joinPoint) throws InterruptedException {
        System.out.println("validating user authority");
        Thread.sleep(1000);
    }

    /**
     * 记录性能时间
     * */
    @Around("execution(* cn.microboat.Spring50Errors.service.ElectricService.doCharge())")
    public void recordPerformance(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("charge method time cost: " + (end - start) + "ms");
    }
}
