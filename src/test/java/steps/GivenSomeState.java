package steps;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ScenarioState;
import helpers.GameHelper;

public class GivenSomeState extends Stage<GivenSomeState> {

    @ScenarioState
    GameHelper gameHelper;

    public GivenSomeState some_new_state() {
        return self();
    }

    public GivenSomeState players_token_is_at_start_position(int position) {

        gameHelper = new GameHelper();
§
        gameHelper.setupGame();
        gameHelper.getPlayer().setCurrentPosition(position);
        return self();
    }
}

