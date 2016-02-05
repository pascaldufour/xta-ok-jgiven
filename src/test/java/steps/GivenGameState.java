package steps;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ScenarioState;
import helpers.GameHelper;

public class GivenGameState extends Stage<GivenGameState> {

    @ScenarioState
    GameHelper gameHelper;

   public GivenGameState the_players_token_is_at_the_start_position() {
        gameHelper = new GameHelper();
        gameHelper.setupGame();
        gameHelper.getPlayer().setCurrentPosition(1);
        return self();
    }
}

