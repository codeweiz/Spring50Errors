package cn.microboat.Spring50Errors.config;

import cn.microboat.Spring50Errors.service.LightService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhouwei
 */
@Configuration
public class BeanConfiguration {

    /**
     * 注解 @Bean(destroyMethod = "")，
     * 避免 Java 类中定义了一些带有特殊意义动词的方法来解决
     * */
    @Bean(destroyMethod = "")
    public LightService getTransmission() {
        return new LightService();
    }
}
