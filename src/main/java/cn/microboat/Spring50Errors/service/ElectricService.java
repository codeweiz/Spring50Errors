package cn.microboat.Spring50Errors.service;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhouwei
 */
@Service
public class ElectricService {

    @Autowired
    private AdminUserService adminUserService;

    @Autowired
    private ElectricService electricService;

    public void charge() throws InterruptedException {

        System.out.println("Electric charging ...");
//        electricService.doCharge();
//        ElectricService electricService = (ElectricService) AopContext.currentProxy();
//        electricService.pay();
    }

    public void doCharge() {
        System.out.println("Electric charging ...");
    }

    public void pay() throws InterruptedException {
        adminUserService.login();
        String payNum = adminUserService.getUser().getPayNum();
        System.out.println("User pay num : " + payNum);
        System.out.println("Pay with alipay ...");
        Thread.sleep(1000);
    }
}
