package nl.xebia.jgiven.tests.MoveToken;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;
import steps.GivenGameState;
import steps.ThenGameOutcome;
import steps.WhenGameAction;

import static org.junit.Assert.fail;

public class SampleTest extends
        ScenarioTest<GivenGameState, WhenGameAction, ThenGameOutcome> {

    @Test
    public void move_token() {
        given();
        fail("Implement me!");
    }

}
