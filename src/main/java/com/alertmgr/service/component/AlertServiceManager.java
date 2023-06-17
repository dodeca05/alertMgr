package com.alertmgr.service.component;

import com.alertmgr.service.port.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class AlertServiceManager {
    private Map<String, AlertService> alertServiceMap;

    @Autowired
    public AlertServiceManager(ApplicationContext applicationContext) {
        alertServiceMap=new HashMap<>();
        Map<String, Object> beansOfType = applicationContext.getBeansOfType(Object.class);
        for (Map.Entry<String, Object> entry : beansOfType.entrySet()) {
            String beanName = entry.getKey();
            Object bean = entry.getValue();
            if (bean instanceof AlertService)
                alertServiceMap.put(beanName, (AlertService)bean);
        }
    }

    public AlertService findAlertServiceByClassName(String serviceName) {
        return alertServiceMap.get(serviceName);
    }
    public Set<String> getAlertServiceNames() {
        return alertServiceMap.keySet();
    }
}
