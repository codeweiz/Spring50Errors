package cn.microboat.Spring50Errors.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouwei
 */
@RestController
@Slf4j
public class ValueController {

    /**
     * 注解 @Value 在解析嵌入值做替换占位符工作时，查找的源不局限于配置文件，还有系统的环境变量等
     * 最好和系统环境变量区分开，避免冲突
     * */
    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    /**
     * 事实上这么写也不一定就完全解决了，
     * 恰巧在 macbook 中，user.name 在系统中正好作为环境变量
     * */
    @Value("${user.name}")
    private String username2;

    @Value("${user.password}")
    private String password2;

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public String getUser() {
        return username + password;
    }

    @RequestMapping(value = "user2", method = RequestMethod.GET)
    public String getUser2() {
        return username2 + password2;
    }

}
