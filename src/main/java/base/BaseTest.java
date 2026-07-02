package base;

import com.microsoft.playwright.*;
import utilities.ConfigReader;
import java.nio.file.Paths;
public class BaseTest {

    public static Playwright playwright;
    public static Browser browser;
    public static BrowserContext context;
    public static Page page;

    public static void launchBrowser() {
      String browserName=  ConfigReader.getProperty("browserName");
        boolean headless = Boolean.parseBoolean(
                ConfigReader.getProperty("headless"));

        playwright = Playwright.create();


        switch (browserName.toLowerCase()) {

            case "firefox":
                browser = playwright.firefox().launch(
                        new BrowserType.LaunchOptions().setHeadless(headless));
                break;

            case "webkit":
                browser = playwright.webkit().launch(
                        new BrowserType.LaunchOptions().setHeadless(headless));
                break;

            default:
                browser = playwright.chromium().launch(
                        new BrowserType.LaunchOptions().setHeadless(headless));
        }


        // Create browser context with video recording enabled
        context = browser.newContext(
                new Browser.NewContextOptions()
                        .setRecordVideoDir(Paths.get("videos"))
        );

        page = context.newPage();
    }


    public static void closeBrowser() {

        context.close();

        browser.close();

        playwright.close();
    }
}