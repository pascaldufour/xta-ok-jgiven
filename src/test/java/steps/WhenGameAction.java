package steps;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.annotation.ScenarioState;
import helpers.GameHelper;

public class WhenGameAction extends Stage<WhenGameAction> {
    @ScenarioState
    GameHelper gameHelper;

    @As("the player throws \"$\" and \"$\"")
    public WhenGameAction the_player_throws_both_dice(int die1, int die2) {
        gameHelper.setDice(die1, die2);
        return self();
    }

}
