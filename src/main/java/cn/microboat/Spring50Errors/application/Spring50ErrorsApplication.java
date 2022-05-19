package cn.microboat.Spring50Errors.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
        @ComponentScan("cn.microboat.Spring50Errors.listener"),
        @ComponentScan("cn.microboat.Spring50Errors.annotation")
})
@EnableAspectJAutoProxy(exposeProxy = true)
public class Spring50ErrorsApplication {

    public static void main(String[] args) {
//        MyApplicationEnvironmentPreparedEventListener listener = new MyApplicationEnvironmentPreparedEventListener();
//        SpringApplication springApplication = new SpringApplicationBuilder(Spring50ErrorsApplication.class).listeners(listener).build();
//        springApplication.run(args);

//        ConfigurableApplicationContext context = SpringApplication.run(Spring50ErrorsApplication.class, args);
//        context.close();

        SpringApplication.run(Spring50ErrorsApplication.class, args);
    }

}
