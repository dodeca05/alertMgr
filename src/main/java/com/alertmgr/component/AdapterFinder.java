package com.alertmgr.component;

import com.alertmgr.port.AlertService;
import org.springframework.beans.NullValueInNestedPathException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class AdapterFinder {
    private final ApplicationContext applicationContext;

    private Map<String, AlertService> alertServiceMap;

    @Autowired
    public AdapterFinder(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
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


    public Set<String> GetAlertServiceNames() {
        return alertServiceMap.keySet();
    }
}
