package nl.xebia.jgiven.tests.MoveToken;

import org.junit.Test;
import org.junit.runner.RunWith;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.jgiven.junit.ScenarioTest;

import steps.GivenGameState;
import steps.ThenGameOutcome;
import steps.WhenGameAction;

@RunWith(DataProviderRunner.class)
public class DataDrivenTest extends
        ScenarioTest<GivenGameState, WhenGameAction, ThenGameOutcome> {

    @Test
    @DataProvider({
      "GO,              1, 2, Baltic Avenue",
      "Community Chest, 3, 4, Conneticut Avenue",
      "Boardwalk,       2, 2, Baltic Avenue"
    })
    public void move_token(String startPosition, int die1, int die2, String newPosition) {
        given().the_players_token_is_at_position(startPosition);
        when().the_player_throws_both_dice(die1, die2);
        then().the_player_moves_to_the_$_square(newPosition);
    }

}
