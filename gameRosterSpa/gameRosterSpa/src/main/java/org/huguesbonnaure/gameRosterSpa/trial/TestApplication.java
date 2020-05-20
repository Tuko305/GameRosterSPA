package org.huguesbonnaure.gameRosterSpa.trial;
import com.google.gson.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@SpringBootApplication
public class TestApplication {
    public static void main(String... args) {
        SpringApplication.run(TestApplication.class, args);
        /*
        try {
            String name = "Mortiscia";
            String sURL = "https://gameinfo.albiononline.com/api/gameinfo/search?q=Mortiscia";
            String resultURL = sURL;
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
            JsonElement charName = playerObject.get("Name");
            JsonElement pvpKillFame = playerObject.get("KillFame");
            JsonElement pvpRatio = playerObject.get("FameRatio");

            Player me = new Player("Hugues Bonnaure", charName.getAsString(), guildName.getAsString(), pvpKillFame.getAsInt(), pvpRatio.getAsFloat());


        }catch (Exception ex){
            System.out.println("something went wrong");
        }

         */
    }
}

