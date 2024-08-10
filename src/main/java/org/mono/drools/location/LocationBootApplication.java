package org.mono.drools.location;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class of Address Application
 *
 * @author Monobikash Das
 * @since 1.2.1 release
 */
@SpringBootApplication(scanBasePackages = { "org.mono.drools.location.*"})
@EnableAutoConfiguration
public class LocationBootApplication {

//    @Autowired
//    LocationService addressService;

    public static void main(String[] args) {
        SpringApplication.run(LocationBootApplication.class, args);
    }


//    @PostConstruct
//    public void run() {
//        try {
//            Map<String, Object> addressJson = new HashMap<>();
//            addressJson.put("city", "Oldtown");
//            addressJson.put("postalCode", "54321");
//            //addressService.getLatestAddress(addressJson);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}