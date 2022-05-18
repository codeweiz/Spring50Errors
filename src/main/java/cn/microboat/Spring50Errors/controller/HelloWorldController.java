package cn.microboat.Spring50Errors.controller;

import cn.microboat.Spring50Errors.service.ElectricService;
import cn.microboat.Spring50Errors.service.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouwei
 */
@RestController
@Slf4j
public class HelloWorldController {

    @Autowired
    private ServiceImpl service;

    /**
     * @ Autowired 注解会固定 ServiceImpl 属性值
     * 加上 @Scope 是无效的
     */
//    @Autowired
//    private ApplicationContext applicationContext;
    @RequestMapping(path = "/hi", method = RequestMethod.GET)
    public String hi() {
        return "hello world, service is : " + service;
    }

    /**
     * 加 @Lookup 注解，
     * 配合 @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
     * 每次调接口都会创建新的 Bean
     * <p>
     * 因为 @Lookup 注解的标记走入了 cglib 代理类
     * <p>
     * 方法调用并没有走入 return null 语句，
     * 而是通过 BeanFactory 来获取 Bean
     * 所以在 getServiceImpl 方法实现中，随便怎么写都行，不重要
     */
//    @Lookup
    public ServiceImpl getServiceImpl() {
        // 方法体都不会执行
        log.info("executing this method");
        return null;
    }

    @Autowired
    ElectricService electricService;

    @RequestMapping(value = "charge", method = RequestMethod.GET)
    public void charge() throws InterruptedException {
        electricService.charge();
    }

    @Autowired
    private AbstractApplicationContext applicationContext;

    @RequestMapping(value = "/publishEvent", method = RequestMethod.GET)
    public String notifyEvent() {
        applicationContext.start();
        return "ok";
    }
}
