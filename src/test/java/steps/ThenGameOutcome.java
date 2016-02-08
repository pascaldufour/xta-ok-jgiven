package steps;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.annotation.ScenarioState;
import com.xebia.monopoly.domain.Board;
import com.xebia.monopoly.domain.Space;

import helpers.GameHelper;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ThenGameOutcome extends Stage<ThenGameOutcome> {

    @ScenarioState
    GameHelper gameHelper;

    @As("he player moves to the \"$\" square")
    public ThenGameOutcome the_player_moves_to_position(String spaceName) {
        gameHelper.doPlayAction();

        final Space square = gameHelper.board().getSpaces().get(gameHelper.getNewPosition());
        assertThat(square.getName(), is(spaceName));
        return self();
    }

}