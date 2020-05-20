package org.huguesbonnaure.gameRosterSpa.trial;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import com.google.gson.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class PlayerController {
    private final PlayerRepository repository;

    PlayerController(PlayerRepository repository) {
        this.repository = repository;
    }

    // Aggregate root
    @CrossOrigin(origins = "*")
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
            JsonObject playerObject = new Gson().fromJson(p, JsonObject.class);
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