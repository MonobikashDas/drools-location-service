package org.mono.drools.location.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.mono.drools.location.dto.LocationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Service
public class LocationService {

    @Autowired
    KieSession kieSession;

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationService.class);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");


    @Autowired
    private KieContainer kieContainer;

    public LocationDto getLatestAddress(LocationDto dto) {

        try {
            Instant start = Instant.now();
//            String jsonInput = new ObjectMapper().writeValueAsString(dto.getAddress());
//            byte[] utf8Bytes = jsonInput.getBytes(StandardCharsets.UTF_8);
//            String utf8EncodedJson = new String(utf8Bytes, StandardCharsets.UTF_8);
//            Map<String, Object> jsonMap = new ObjectMapper().readValue(utf8EncodedJson, new TypeReference<Map<String, Object>>() {});
//            LOGGER.info("-------------------------> " +  jsonMap);
            Map<String, Object> addressJson = dto.getAddress();
            kieSession.insert(addressJson);
            kieSession.insert(dto.getEffectiveDate());
            kieSession.fireAllRules();
            Instant end = Instant.now();
            Duration timeElapsed = Duration.between(start, end);
            LOGGER.debug("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
            // kieSession.dispose();
            dto.setAddress(addressJson);
        } catch (Exception e) {
            LOGGER.error("Exception occured - ", e);
            throw new RuntimeException(e.getMessage());
        }
        return dto;
    }
}
