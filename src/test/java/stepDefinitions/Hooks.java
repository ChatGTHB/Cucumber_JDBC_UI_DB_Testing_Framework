package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.GWD;

public class Hooks {

    @Before
    public void before() {
        System.out.println("The scenario started.");
    }

    @After
    public void after() {
        System.out.println("The scenario finished.");
        GWD.quitDriver();
    }
}
