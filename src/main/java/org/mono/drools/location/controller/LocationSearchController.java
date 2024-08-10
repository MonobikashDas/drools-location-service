package org.mono.drools.location.controller;

import org.mono.drools.location.dto.LocationDto;
import org.mono.drools.location.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationSearchController {

    @Autowired
    LocationService addressService;

    @PostMapping(value = "/latestAddress")
    public LocationDto latestAddress(@RequestBody LocationDto dto) {
        LocationDto addressDto = new LocationDto();
        try {
            addressDto = addressService.getLatestAddress(dto);
        } catch (Exception e) {
            // Handle exception as needed
        }
        return addressDto;
    }
}
