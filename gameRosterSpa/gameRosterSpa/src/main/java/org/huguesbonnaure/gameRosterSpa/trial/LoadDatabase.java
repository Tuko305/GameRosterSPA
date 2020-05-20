package org.huguesbonnaure.gameRosterSpa.trial;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(PlayerRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Player("Bruno Fernandes", "Omened", 0, 0)));
            log.info("Preloading " + repository.save(new Player("Hugues Bonnaure", "Mortiscia", 10, 2)));
        };
    }
}