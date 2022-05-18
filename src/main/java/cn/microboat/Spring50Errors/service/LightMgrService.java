package cn.microboat.Spring50Errors.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhouwei
 */
@Component
public class LightMgrService implements InitializingBean {

    @Autowired
    private LightService lightService;

    /**
     * 1、添加 init 方法，并且使用 @PostConstruct 注解
     * 2、实现 InitializingBean 接口，在其 afterPropertiesSet() 方法中执行初始化代码
     */

//    @PostConstruct
//    public void init() {
//        lightService.check();
//    }


    @Override
    public void afterPropertiesSet() {
        lightService.check();
    }
}
