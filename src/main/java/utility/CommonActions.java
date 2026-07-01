package utility;

import base.BaseTest;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CommonActions {

    protected Page page;

    public CommonActions() {
        this.page = BaseTest.page;
    }


    public void click(Locator locator) {
        locator.click();
    }

    public String getText(Locator locator) {
        return locator.textContent();

    }
}