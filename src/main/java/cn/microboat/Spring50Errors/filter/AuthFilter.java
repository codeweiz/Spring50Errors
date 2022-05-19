package cn.microboat.Spring50Errors.filter;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter
@Slf4j
@Component
@Order(2)
public class AuthFilter implements Filter {
    @SneakyThrows
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (isPassAuth()) {
            System.out.println("通过授权！");
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            System.out.println("未通过授权！");
            ((HttpServletResponse) servletResponse).sendError(401);
        }
    }

    private boolean isPassAuth() throws InterruptedException {
        System.out.println("执行检查权限");
        Thread.sleep(1000);
        return true;
    }
}
