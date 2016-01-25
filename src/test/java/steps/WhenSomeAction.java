package steps;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ScenarioState;
import helpers.GameHelper;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WhenSomeAction extends Stage<WhenSomeAction> {
    @ScenarioState
    GameHelper gameHelper;

    public WhenSomeAction player_throws_die_$_and_die_$(int die1, int die2) {
        gameHelper.setDice(die1, die2);
        return self();
    }

}
