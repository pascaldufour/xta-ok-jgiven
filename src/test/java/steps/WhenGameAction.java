package steps;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ScenarioState;
import helpers.GameHelper;

public class WhenGameAction extends Stage<WhenGameAction> {
    @ScenarioState
    GameHelper gameHelper;

    public WhenGameAction the_player_throws_both_dice() {
        gameHelper.setDice(1, 2);
        return self();
    }

}
