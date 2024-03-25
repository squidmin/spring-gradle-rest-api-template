package org.squidmin.spring.gradle.controller;

import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PubController {

    @Autowired
    private PubSubTemplate pubSubTemplate;

    @PostMapping("/publish")
    public String publishMessage(@RequestBody String message) {
        log.info("Publishing message: {}", message);
        pubSubTemplate.publish("test-topic", message);
        return "Message published";
    }

}
