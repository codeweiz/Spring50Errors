package cn.microboat.Spring50Errors.application;

import cn.microboat.Spring50Errors.listener.MyApplicationEnvironmentPreparedEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author zhouwei
 */
@SpringBootApplication
@ComponentScans(value = {
        @ComponentScan("cn.microboat.Spring50Errors.controller"),
        @ComponentScan("cn.microboat.Spring50Errors.dao"),
        @ComponentScan("cn.microboat.Spring50Errors.service"),
        @ComponentScan("cn.microboat.Spring50Errors.pojo"),
        @ComponentScan("cn.microboat.Spring50Errors.config"),
        @ComponentScan("cn.microboat.Spring50Errors.listener")
})
@EnableAspectJAutoProxy(exposeProxy = true)
public class Spring50ErrorsApplication {

    public static void main(String[] args) {
        MyApplicationEnvironmentPreparedEventListener listener = new MyApplicationEnvironmentPreparedEventListener();
        SpringApplication springApplication = new SpringApplicationBuilder(Spring50ErrorsApplication.class).listeners(listener).build();
        springApplication.run(args);

//        ConfigurableApplicationContext context = SpringApplication.run(Spring50ErrorsApplication.class, args);
//        context.close();
    }

}
