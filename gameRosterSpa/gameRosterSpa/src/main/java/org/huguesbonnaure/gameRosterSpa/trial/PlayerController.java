package org.huguesbonnaure.gameRosterSpa.trial;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PlayerController {
    private final PlayerRepository repository;

    PlayerController(PlayerRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/players")
    List<Player> all() {
        return repository.findAll();
    }

    @PostMapping("/players")
    Player newTestEntity(@RequestBody Player newPlayer) {
        String name = newPlayer.getName();
        return repository.save(newPlayer);
    }

    // Single item

    @GetMapping("/players/{id}")
    Player one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException(id));
    }

    @PutMapping("/players/{id}")
    Player replacePlayer(@RequestBody Player newPlayer, @PathVariable Long id) {

        return repository.findById(id)
                .map(player -> {
                    player.setName(newPlayer.getName());
                    player.setCharName(newPlayer.getCharName());
                    player.setPvpKillFame(newPlayer.getPvpKillFame());
                    player.setPvpRatio(newPlayer.getPvpRatio());
                    return repository.save(player);
                })
                .orElseGet(() -> {
                    newPlayer.setId(id);
                    return repository.save(newPlayer);
                });
    }

    @DeleteMapping("/players/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}