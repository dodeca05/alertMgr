package com.alertmgr.service.adapter;

import com.alertmgr.service.port.AlertService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Log4j2
@Service
public class WebHookSendService implements AlertService {

    private String discordPath="https://example.com";
    @Override
    public boolean sendInfo(String msg) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String requestBody = "{ \"username\":\"Alert Manager\",\"embeds\": [{\"title\": \"[INFO]\",\"description\":\""+msg+"\", \"color\": \"1127128\"}]}";
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(discordPath, requestEntity, String.class);

        log.info(response.getBody());
        return false;
    }

    @Override
    public boolean sendInfoSpecific(String targetID, String msg) {
        return false;
    }

    @Override
    public boolean sendError(String msg) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String requestBody = "{ \"username\":\"Alert Manager\",\"embeds\": [{\"title\": \"[ERROR]\",\"description\":\""+msg+"\", \"color\": \"16711680\"}]}";
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(discordPath, requestEntity, String.class);

        log.info(response.getBody());
        return false;
    }

    @Override
    public boolean sendError(Exception exception) {
        return false;
    }

    @Override
    public boolean sendErrorSpecific(String targetID, String msg) {
        return false;
    }

    @Override
    public boolean sendErrorSpecific(String targetID, Exception exception) {
        return false;
    }
}
