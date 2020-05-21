package org.huguesbonnaure.gameRosterSpa.trial.controller;

public class PlayerNotFoundException extends RuntimeException {
    PlayerNotFoundException(String id) {
        super("Could not find player " + id);
    }
}