package steps;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ScenarioState;
import helpers.GameHelper;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ThenGameOutcome extends Stage<ThenGameOutcome> {
    @ScenarioState
    GameHelper gameHelper;

    public ThenGameOutcome the_player_moves_to_a_new_position() {
        gameHelper.doPlayAction();
        assertThat(gameHelper.getNewPosition(), is(4));
        return self();
    }

}