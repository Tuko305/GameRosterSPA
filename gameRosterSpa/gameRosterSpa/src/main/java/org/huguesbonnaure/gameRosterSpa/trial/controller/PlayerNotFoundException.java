package org.huguesbonnaure.gameRosterSpa.trial.controller;

public class PlayerNotFoundException extends RuntimeException {
    PlayerNotFoundException(Long id) {
        super("Could not find player " + id);
    }
}