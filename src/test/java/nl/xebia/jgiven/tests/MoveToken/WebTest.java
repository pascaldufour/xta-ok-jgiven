package nl.xebia.jgiven.tests.MoveToken;

import org.junit.Test;
import com.tngtech.jgiven.junit.ScenarioTest;

import websteps.WebDriverStage;

public class WebTest  extends
        ScenarioTest<WebDriverStage, WebDriverStage, WebDriverStage> {

    @Test
    public void need_2_users_to_start() {
        when().I_start_a_game_with_$_players(2);
        then().the_game_can_or_cannot_$_be_started(true);
    }

    @Test
    public void cannot_start_with_one_user() {
        when().I_start_a_game_with_$_players(1);
        then().the_game_can_or_cannot_$_be_started(false);
    }
}
