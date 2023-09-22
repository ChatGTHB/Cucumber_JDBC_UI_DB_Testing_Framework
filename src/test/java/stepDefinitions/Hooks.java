package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.GWD;

public class Hooks {

    @Before
    public void before() {

    }

    @After
    public void after() {
        GWD.quitDriver();
    }
}
