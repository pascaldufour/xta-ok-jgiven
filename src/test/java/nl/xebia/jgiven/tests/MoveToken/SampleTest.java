package nl.xebia.jgiven.tests.MoveToken;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;
import steps.GivenSomeState;
import steps.ThenSomeOutcome;
import steps.WhenSomeAction;

public class SampleTest extends
        ScenarioTest<GivenSomeState, WhenSomeAction, ThenSomeOutcome> {


    @Test
    public void move_token() {
        given().players_token_is_at_start_position(1);
        when().player_throws_die_$_and_die_$(1, 2);
        then().player_token_moves_to_a_new_$(4);
    }

//    @Given("^players token is at starting position (.+)$")
//    public void
//    playersTokenIsAtStartingPosition(int position){
//        gameHelper.getPlayer().setCurrentPosition(position);
//    }
//
//    @When("^playersTokenIsAtStartingPosition$")
//    public void playerThrowsDie1AndDie2(int die1, int die2) throws Throwable {
//        gameHelper.setDice(die1, die2);
//    }
//
//    @Then("^players token moves to a new position (.+)$")
//    public void playersTokenMovesToANewPosition(int newPosition) throws Throwable {
//        gameHelper.doPlayAction();
//        assertThat(gameHelper.getNewPosition(), is(newPosition));
//    }
//
//
//
//    @Then("^player gets another turn (.+)$")
//    public void playerGetsAnotherTurn(String anotherTurn) throws Throwable {
//        gameHelper.doPlayAction();
//        assertEquals("Another roll allowed", anotherTurn, convertBooleanToYesOrNo(gameHelper.getPlayer().isRollAllowed()));
//    }
//
//    @When("^player throw doubles three times in succession$")
//    public void playerThrowDoublesThreeTimesInSuccession() throws Throwable {
//        for (int i = 1; i <= 3; i++) {
//            gameHelper.setDice(1, 1);
//            gameHelper.doPlayAction();
//            if (i != 3) {
//                assertEquals("Another roll allowed", true, gameHelper.getPlayer().isRollAllowed());
//            }
//        }
//    }
//
//    @Then("^player goes to jail$")
//    public void playerGoesToJail() throws Throwable {
//        assertEquals("Another roll allowed", false, gameHelper.getPlayer().isRollAllowed());
//    }


}
