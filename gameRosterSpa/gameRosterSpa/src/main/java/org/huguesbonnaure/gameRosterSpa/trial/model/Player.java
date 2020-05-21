package org.huguesbonnaure.gameRosterSpa.trial.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Player {

    private @Id @GeneratedValue Long id;
    private String name;
    private String charName;
    private String guildName;
    private int pvpKillFame;
    private float pvpRatio;

    public Player() {}

    public Player(String name, String charName, String guildName, int pvpKillFame, float pvpRatio) {
        this.name = name;
        this.charName = charName;
        this.pvpKillFame = pvpKillFame;
        this.pvpRatio = pvpRatio;
        this.guildName = guildName;
    }
}