package steps;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.annotation.ScenarioState;

import helpers.GameHelper;

public class GivenGameState extends Stage<GivenGameState> {

    @ScenarioState
    GameHelper gameHelper;

    @As("the player is at the \"$\" square")
    public GivenGameState the_players_token_is_at_position(String spaceName) {
        gameHelper = new GameHelper();
        gameHelper.setupGame();
        int pos = gameHelper.board().findLocation(spaceName).getPosition();
        gameHelper.getPlayer().setCurrentPosition(pos);

        return self();
    }
}

