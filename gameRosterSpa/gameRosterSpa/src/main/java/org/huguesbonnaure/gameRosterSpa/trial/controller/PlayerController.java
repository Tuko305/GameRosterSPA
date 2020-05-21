package org.huguesbonnaure.gameRosterSpa.trial.controller;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import com.google.gson.*;
import org.huguesbonnaure.gameRosterSpa.trial.model.Player;
import org.huguesbonnaure.gameRosterSpa.trial.persistence.PlayerRepository;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
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
        String charName = newPlayer.getCharName();
        String playerName = newPlayer.getName();
        String sURL = "https://gameinfo.albiononline.com/api/gameinfo/search?q=";
        String resultURL = sURL + charName;

        try {
            // Connect to the URL using java's native library
            URL url = new URL(resultURL);
            URLConnection request = url.openConnection();
            request.connect();

            // Convert to a JSON object to print data
            JsonObject jsonObject = JsonParser.parseReader(new InputStreamReader((InputStream) request.getContent())).getAsJsonObject(); //May be an array, may be an object.
            JsonArray players = jsonObject.getAsJsonArray("players");
            String player = players.toString();
            String p = player.substring(1, player.length()-1);
            String p2 = p.split(",\"gvgWon")[0]+ "}";

            JsonObject playerObject = new Gson().fromJson(p2, JsonObject.class);
            System.out.println(playerObject);

            JsonElement guildName = playerObject.get("GuildName");
            JsonElement pvpKillFame = playerObject.get("KillFame");
            JsonElement pvpRatio = playerObject.get("FameRatio");


            newPlayer.setGuildName(guildName.getAsString());
            newPlayer.setPvpKillFame(pvpKillFame.getAsInt());
            newPlayer.setPvpRatio(pvpRatio.getAsFloat());

        }catch (Exception ex){
            System.out.println("something went wrong");
        }
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