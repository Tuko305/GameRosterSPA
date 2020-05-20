package org.huguesbonnaure.gameRosterSpa.trial;

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
    private int pvpKillFame;
    private int pvpRatio;

    public Player() {}

    public Player(String name, String charName, int pvpKillFame, int pvpRatio) {
        this.name = name;
        this.charName = charName;
        this.pvpKillFame = pvpKillFame;
        this.pvpRatio = pvpRatio;
    }
}