package com.yeoul.waterapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class VersionController {

    @Value("${app.version}")
    private String appVersion;

    @GetMapping("/version")
    public Map<String, String> version() {
        return Map.of(
                "appName", "Yeoul Water App",
                "version", appVersion
        );
    }
}