package websteps;

import org.junit.Assert;
import com.tngtech.jgiven.annotation.BeforeScenario;
import com.tngtech.jgiven.annotation.ScenarioRule;

import websteps.pageobjects.AddUserPage;
import websteps.pageobjects.PlayGamePage;

import static org.hamcrest.core.Is.is;

public class WebDriverStage {

    @ScenarioRule
    protected WebDriverRule webDriverRule = new WebDriverRule();

    AddUserPage addUserPage;
    PlayGamePage gamePage;

    @BeforeScenario
    public void startGame() {
        addUserPage =  new AddUserPage(webDriverRule.webDriver);
        addUserPage.get();
    }

    public void I_start_a_game_with_$_players(int playerAmount) {
        for (int i = 0; i < playerAmount; i++) {
            addUserPage.addUser("User" + i);
        }
        gamePage = addUserPage.clickStart();
    }

    public void the_game_can_or_cannot_$_be_started(boolean gameCanStart) {
        if (!gameCanStart) {
            addUserPage.validateModal("Need more players");
        }
        Assert.assertThat("The game started state", gamePage.isGameStarted(), is(gameCanStart));


    }
}
