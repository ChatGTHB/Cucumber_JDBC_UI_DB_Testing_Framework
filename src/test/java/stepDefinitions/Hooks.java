package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.GWD;

public class Hooks {

    @Before
    public void before() {
        System.out.println("The scenario has begun.");
    }

    @After
    public void after() {
        System.out.println("The scenario is finished.");
        GWD.quitDriver();
    }
}
