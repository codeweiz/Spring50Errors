package cn.microboat.Spring50Errors.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Component;

/**
 * @author zhouwei
 */
@Component
@Slf4j
public class MyLifeCycle implements Lifecycle {

    /**
     * LifeCycle 生命周期
     * start 和 stop 只会在应用 启动 和 结束 时执行
     */
    private volatile boolean running = false;

    @Override
    public void start() {
        log.info("lifecycle start");
        running = true;
    }

    @Override
    public void stop() {
        log.info("lifecycle stop");
        running = false;
    }

    @Override
    public boolean isRunning() {
        return running;
    }
}
