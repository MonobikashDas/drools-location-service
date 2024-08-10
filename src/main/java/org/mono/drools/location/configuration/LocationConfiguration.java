package org.mono.drools.location.configuration;

import org.kie.api.KieServices;
import org.kie.api.builder.*;
import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class LocationConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationConfiguration.class);
    private static final String[] DRL_FILE_PATHS = {
            "src/main/resources/LOCATION_RULE_eng.drl",
            "src/main/resources/LOCATION_RULE_kan.drl"
    };

    private KieServices kieServices = KieServices.Factory.get();

    @Bean
    public KieSession kieSession() throws IOException {
        LOGGER.info("Session created...");
        KieSession kieSession = getKieContainer().newKieSession();
        kieSession.addEventListener(new RuleRuntimeEventListener() {
            @Override
            public void objectInserted(ObjectInsertedEvent event) {
                LOGGER.info("Object inserted \n " + event.getObject().toString());
            }

            @Override
            public void objectUpdated(ObjectUpdatedEvent event) {
                LOGGER.info("Object was updated \n" + "New Content \n" + event.getObject().toString());
            }

            @Override
            public void objectDeleted(ObjectDeletedEvent event) {
                LOGGER.info("Object retracted \n" + event.getOldObject().toString());
            }
        });
        return kieSession;
    }

    @Bean
    public KieContainer getKieContainer() throws IOException {
        LOGGER.info("Container created...");
        getKieRepository();
        KieBuilder kb = kieServices.newKieBuilder(getKieFileSystem());
        kb.buildAll();
        KieModule kieModule = kb.getKieModule();
        return kieServices.newKieContainer(kieModule.getReleaseId());
    }

    private void getKieRepository() {
        final KieRepository kieRepository = kieServices.getRepository();
        kieRepository.addKieModule(new KieModule() {
            @Override
            public ReleaseId getReleaseId() {
                return kieRepository.getDefaultReleaseId();
            }
        });
    }

    private KieFileSystem getKieFileSystem() throws IOException {
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        for (String drlFilePath : DRL_FILE_PATHS) {
            LOGGER.info("Loading Drools configuration file - " + drlFilePath);
            kieFileSystem.write("src/main/resources/" + drlFilePath,
                    kieServices.getResources().newFileSystemResource(drlFilePath));
        }
        return kieFileSystem;
    }
}