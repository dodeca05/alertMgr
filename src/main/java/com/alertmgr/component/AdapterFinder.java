package com.alertmgr.component;

import com.alertmgr.port.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class AdapterFinder {
    private final ApplicationContext applicationContext;

    @Autowired
    public AdapterFinder(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public AlertService findAlertServiceByClassName(String serviceName) {
        return applicationContext.getBeansOfType(AlertService.class).values().stream()
                .filter(bean -> bean.getClass().getName().equals(serviceName))
                .findFirst()
                .orElse(null);
    }
}
