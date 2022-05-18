package cn.microboat.Spring50Errors.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

/**
 * @author zhouwei
 *
 * proxyMode = ScopedProxyMode.TARGET_CLASS
 * 基于 类 代理
 */
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ServiceImpl {

    @Bean
    public String serviceName() {
        return "MyServiceName";
    }

}
