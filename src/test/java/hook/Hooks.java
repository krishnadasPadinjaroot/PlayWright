package hook;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void beforeScenario() {

        BaseTest.launchBrowser();

    }

    @After
    public void afterScenario() {

            BaseTest.closeBrowser();

        }
}