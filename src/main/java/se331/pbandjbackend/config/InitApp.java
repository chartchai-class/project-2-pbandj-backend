package se331.pbandjbackend.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

public class InitApp implements ApplicationListener<ApplicationReadyEvent>{
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {

    }

    @Override
    public boolean supportsAsyncExecution() {
        return ApplicationListener.super.supportsAsyncExecution();
    }
}
