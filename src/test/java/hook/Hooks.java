package hook;

import base.BaseTest;
import com.microsoft.playwright.Page;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utility.AllureUtil;
import utility.VideoUtil;

import java.nio.file.Path;

public class Hooks {

    @Before
    public void beforeScenario() {
        BaseTest.launchBrowser();
    }

    @After
    public void afterScenario(Scenario scenario) {

        // Keep page reference
        Page page = BaseTest.page;

        // Screenshot for failed test
        if (scenario.isFailed()) {

            byte[] screenshot = page.screenshot(
                    new Page.ScreenshotOptions()
                            .setFullPage(true)
            );

            AllureUtil.attachScreenshot(screenshot);
        }

        // Close browser (video is saved here)
        BaseTest.closeBrowser();

        // Attach video after browser closes
        if (scenario.isFailed()) {

            try {

                Path video = page.video().path();

                VideoUtil.attachVideo(video);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}