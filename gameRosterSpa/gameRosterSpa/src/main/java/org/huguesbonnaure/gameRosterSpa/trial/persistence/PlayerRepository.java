package org.huguesbonnaure.gameRosterSpa.trial.persistence;
import org.huguesbonnaure.gameRosterSpa.trial.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long>{

}


