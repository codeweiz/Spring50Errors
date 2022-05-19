package cn.microboat.Spring50Errors.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

//@WebFilter
@Slf4j
@Component
@Order(1)
public class TimeCostFilter implements Filter {

    public TimeCostFilter() {
        System.out.println("construct");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("开始计算接口耗时");
        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        long end = System.currentTimeMillis();
        System.out.println("TimeCostFilter 执行时间：" + (end - start) + " ms");
    }
}
