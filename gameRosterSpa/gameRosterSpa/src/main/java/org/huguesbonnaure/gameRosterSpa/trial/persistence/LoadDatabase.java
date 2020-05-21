package org.huguesbonnaure.gameRosterSpa.trial.persistence;
import lombok.extern.slf4j.Slf4j;

import org.huguesbonnaure.gameRosterSpa.trial.model.Player;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(PlayerRepository repository) {
        return args -> {
        };
    }
}