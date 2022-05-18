package cn.microboat.Spring50Errors.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author zhouwei
 */
@Service
public class LightService {

    public void start() {
        System.out.println("turn on all lights");
    }

    public void shutdown() {
        System.out.println("turn off all lights");
    }

    public void check() {
        System.out.println("check all lights");
    }
}
