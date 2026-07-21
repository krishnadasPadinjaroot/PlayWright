package factory;

import com.microsoft.playwright.*;
import utilities.ConfigReader;

import java.nio.file.Paths;

public class BrowserFactory {

    private static final ThreadLocal<Playwright> playwright = new ThreadLocal<>();
    private static final ThreadLocal<Browser> browser = new ThreadLocal<>();
    private static final ThreadLocal<BrowserContext> context = new ThreadLocal<>();
    private static final ThreadLocal<Page> page = new ThreadLocal<>();

    private BrowserFactory() {}

    public static void initBrowser() {

        playwright.set(Playwright.create());

        BrowserType browserType;

        switch (ConfigReader.getBrowser().toLowerCase()) {

            case "firefox":
                browserType = playwright.get().firefox();
                break;

            case "webkit":
                browserType = playwright.get().webkit();
                break;

            default:
                browserType = playwright.get().chromium();
        }

        browser.set(browserType.launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(ConfigReader.isHeadless())
        ));

        context.set(browser.get().newContext(
                new Browser.NewContextOptions()
                        .setRecordVideoDir(Paths.get("videos"))
        ));

        page.set(context.get().newPage());

        page.get().setDefaultTimeout(ConfigReader.getTimeout());

        page.get().setDefaultNavigationTimeout(
                ConfigReader.getNavigationTimeout());

    }

    public static Page page() {
        return page.get();
    }

    public static BrowserContext context() {
        return context.get();
    }

    public static Browser browser() {
        return browser.get();
    }

    public static Playwright playwright() {
        return playwright.get();
    }

    public static void closeBrowser() {

        if (context.get() != null)
            context.get().close();

        if (browser.get() != null)
            browser.get().close();

        if (playwright.get() != null)
            playwright.get().close();

        context.remove();
        browser.remove();
        playwright.remove();
        page.remove();

    }

}