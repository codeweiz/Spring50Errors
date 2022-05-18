package cn.microboat.Spring50Errors.config;

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
@Service
@Slf4j
@Aspect
public class AopConfig {

    /**
     * AOP 执行顺序：
     * 注解：@Around -> @Before -> proceed() -> @After -> @AfterRetuning -> @AfterThrowing
     * 相同级别下：如都是 Before 时，按方法名首字母排序（a->z）
     */

    @Around("execution(* cn.microboat.Spring50Errors.service.ElectricService.pay())")
    public void recordPayPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("Pay meth time cost (ms) : " + (end - start));
    }

    @Before("execution(* cn.microboat.Spring50Errors.service.ElectricService.charge())")
    public void logBeforeMethod(JoinPoint joinPoint) {
        System.out.println("step into ->" + joinPoint.getSignature());
    }

    /**
     * logBeforeMethod 首字母 l
     * checkAuthority 首字母 c
     * validateAuthority 首字母 v
     * c 在 l 的前面，所以 checkAuthority 先执行，抛出异常后，logBeforeMethod 就不会执行了
     */

//    @Before("execution(* cn.microboat.Spring50Errors.service.ElectricService.charge())")
//    public void validateAuthority(JoinPoint joinPoint) {
//        throw new RuntimeException("authority check failed");
//    }
    @Before("execution(* cn.microboat.Spring50Errors.service.ElectricService.charge())")
    public void checkAuthority(JoinPoint joinPoint) {
        throw new RuntimeException("authority check failed");
    }


}
