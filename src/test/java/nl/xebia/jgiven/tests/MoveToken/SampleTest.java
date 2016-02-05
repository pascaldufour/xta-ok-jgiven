package nl.xebia.jgiven.tests.MoveToken;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;
import steps.GivenGameState;
import steps.ThenGameOutcome;
import steps.WhenGameAction;

public class SampleTest extends
        ScenarioTest<GivenGameState, WhenGameAction, ThenGameOutcome> {

    @Test
    public void move_token() {
        given().the_players_token_is_at_the_start_position();
        when().the_player_throws_both_dice();
        then().the_player_moves_to_a_new_position();
    }

}
