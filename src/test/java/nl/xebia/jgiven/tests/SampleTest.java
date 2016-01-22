package nl.xebia.jgiven.tests;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;
import steps.GivenSomeState;
import steps.ThenSomeOutcome;
import steps.WhenSomeAction;

public class SampleTest extends
        ScenarioTest<GivenSomeState, WhenSomeAction, ThenSomeOutcome> {

    @Test
    public void bla() {
        given().some_new_state();
        when().some_action();
        then().some_outcome();
    }

}
