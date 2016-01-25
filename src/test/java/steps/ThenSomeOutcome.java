package steps;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ScenarioState;
import helpers.GameHelper;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ThenSomeOutcome extends Stage<ThenSomeOutcome> {
    @ScenarioState
    GameHelper gameHelper;

    public ThenSomeOutcome player_token_moves_to_a_new_$(int newPosition) {
        gameHelper.doPlayAction();
        assertThat(gameHelper.getNewPosition(), is(newPosition));
        return self();
    }

}