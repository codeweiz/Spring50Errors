package cn.microboat.Spring50Errors.service;

import cn.microboat.Spring50Errors.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @author zhouwei
 */
@Service
public class AdminUserService {

    public final User adminUser = new User("202101166");

    public User getUser() {
        return adminUser;
    }

    public void login() {
        System.out.println("admin user login...");
    }
}
