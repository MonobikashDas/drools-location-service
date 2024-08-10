package org.mono.drools.location.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class LocationDto {
    private LocalDateTime effectiveDate;
    private Map<String, Object> address;
}
