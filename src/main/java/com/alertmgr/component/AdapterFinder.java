package com.alertmgr.component;

import com.alertmgr.port.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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


    public List<String> findAlertServiceNames() {
        List<String> beanNamesList = new ArrayList<>();

        Map<String, Object> beansOfType = applicationContext.getBeansOfType(Object.class);
        for (Map.Entry<String, Object> entry : beansOfType.entrySet()) {
            String beanName = entry.getKey();
            Object bean = entry.getValue();
            if (bean instanceof AlertService) {
                beanNamesList.add(beanName);
            }
        }

        return beanNamesList;
    }
}
