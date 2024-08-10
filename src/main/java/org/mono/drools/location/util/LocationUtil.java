package org.mono.drools.location.util;

import org.springframework.web.client.RestTemplate;

public class LocationUtil {
    public static String getJson(String configServerFileStorageURL, String uri) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(configServerFileStorageURL + uri, String.class);
    }
}