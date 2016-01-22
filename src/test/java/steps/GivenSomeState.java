package steps;

import com.tngtech.jgiven.Stage;

public class GivenSomeState extends Stage<GivenSomeState> {
    public GivenSomeState some_new_state() {
        return self();
    }
}

