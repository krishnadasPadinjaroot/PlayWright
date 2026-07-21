package base;

import com.microsoft.playwright.Page;
import factory.BrowserFactory;

public class BaseTest {

    public static void launchBrowser() {
        BrowserFactory.initBrowser();
    }

    public static Page getPage() {
        return BrowserFactory.page();
    }

    public static void closeBrowser() {
        BrowserFactory.closeBrowser();
    }
}