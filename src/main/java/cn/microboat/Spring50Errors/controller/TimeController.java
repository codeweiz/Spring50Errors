package cn.microboat.Spring50Errors.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeController {

    /**
     * 启动类上增加 @ServletComponentScan(basePackages = "cn.microboat.Spring50Errors.filter")
     * 自定义 filter 类实现 Filter 接口，重写 doFilter 方法，类上加上 @WebFilter 注解
     * 这样，每次请求接口，都会走一次自定义 filter，在 doFilter 方法中可加入自定义逻辑，处理日志、耗时等
     */
    @PostMapping("/regStudent/{name}")
    public String saveUser(@PathVariable("name") String name) {
        System.out.println(name + "用户注册成功！");
        return "success";
    }
}
