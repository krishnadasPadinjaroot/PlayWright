
package utilities;

import base.BaseTest;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.MouseButton;
import com.microsoft.playwright.options.SelectOption;
import com.microsoft.playwright.options.WaitForSelectorState;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CommonActions extends BaseTest {

    protected Page page;

    public CommonActions() {
        page = BaseTest.page;
    }

    /* =========================
       ELEMENT ACTIONS
       ========================= */

    public void click(Locator locator) {
        locator.click();
    }

    public void fillText(String locator, String text) {
        page.locator(locator).fill(text);
    }

    public void clearText(String locator) {
        page.locator(locator).clear();
    }

    public String getText(Locator locator) {
        return locator.textContent();
    }

    public String getAttribute(String locator, String attribute) {
        return page.locator(locator).getAttribute(attribute);
    }

    public boolean isVisible(String locator) {
        return page.locator(locator).isVisible();
    }

    public boolean isEnabled(String locator) {
        return page.locator(locator).isEnabled();
    }

    public boolean isChecked(String locator) {
        return page.locator(locator).isChecked();
    }

    /* =========================
       WAIT METHODS
       ========================= */

    public void waitForVisible(Locator locator) {
        locator.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE));
    }

    public void waitForHidden(Locator locator) {
        locator.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.HIDDEN));
    }

    public void waitForPageLoad() {
        page.waitForLoadState(LoadState.LOAD);
    }

    public void waitForURL(String url) {
        page.waitForURL(url);
    }

    public void waitForTimeout(int milliseconds) {
        page.waitForTimeout(milliseconds);
    }

    /* =========================
       MOUSE ACTIONS
       ========================= */

    public void hover(Locator locator) {
        locator.hover();
    }

    public void doubleClick(Locator locator) {
        locator.dblclick();
    }

    public void rightClick(Locator locator) {
        locator.click(
                new Locator.ClickOptions().setButton(MouseButton.RIGHT));
    }

    public void dragAndDrop(Locator source, Locator target) {
      source.dragTo(target);
    }

    /* =========================
       KEYBOARD ACTIONS
       ========================= */

    public void pressEnter() { page.keyboard().press("Enter"); }

    public void pressTab() { page.keyboard().press("Tab"); }

    public void pressEscape() { page.keyboard().press("Escape"); }

    public void pressKey(String key) { page.keyboard().press(key); }

    public void typeText(String text) { page.keyboard().type(text); }

    /* =========================
       JAVASCRIPT ACTIONS
       ========================= */

    public void jsClick(Locator locator) {
        locator.evaluate("element => element.click()");
    }

    public void scrollIntoView(Locator locator) {
        locator.scrollIntoViewIfNeeded();
    }

    public void scrollToTop() {
        page.evaluate("window.scrollTo(0,0)");
    }

    public void scrollToBottom() {
        page.evaluate("window.scrollTo(0,document.body.scrollHeight)");
    }

    public void scrollBy(int x, int y) {
        page.evaluate("([x,y]) => window.scrollBy(x,y)", new int[]{x,y});
    }

    public void highlightElement(Locator locator) {
        locator
                .evaluate("e => e.style.border='3px solid red'");
    }

    /* =========================
       DROPDOWN METHODS
       ========================= */

    public void selectByText(Locator locator, String text) {
        (locator).selectOption(new SelectOption().setLabel(text));
    }

    public void selectByValue(Locator locator, String value) {
       (locator).selectOption(value);
    }

    public void selectByIndex(Locator locator, int index) {
        (locator).selectOption(new SelectOption().setIndex(index));
    }

    public String getSelectedOption(Locator locator) {
        return (locator).inputValue();
    }

    public List<String> getAllOptions(Locator locator) {
        return locator.locator("option").allTextContents();
    }

    /* =========================
       FRAME METHODS
       ========================= */

    public Frame switchToFrame(String frameName) {
        return page.frame(frameName);
    }

    public Frame switchToFrameByUrl(String url) {
        return page.frameByUrl(url);
    }

    /* =========================
       WINDOW / TAB METHODS
       ========================= */

    public Page switchToNewTab() {
        return page.context().waitForPage(() -> {});
    }

    public List<Page> getAllPages() {
        return new ArrayList<>(page.context().pages());
    }

    public int getPageCount() {
        return page.context().pages().size();
    }

    /* =========================
       NAVIGATION
       ========================= */

    public void navigateTo(String url) {
        page.navigate(url);
    }

    public void goBack() {
        page.goBack();
    }

    public void goForward() {
        page.goForward();
    }

    public void refreshPage() {
        page.reload();
    }

    /* =========================
       BROWSER INFORMATION
       ========================= */

    public String getCurrentURL() {
        return page.url();
    }

    public String getPageTitle() {
        return page.title();
    }

    /* =========================
       SCREENSHOTS
       ========================= */

    public void takeScreenshot(String fileName) {
        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get("screenshots/" + fileName + ".png"))
                .setFullPage(true));
    }

    public void takeElementScreenshot(String locator, String fileName) {
        page.locator(locator).screenshot(
                new Locator.ScreenshotOptions()
                        .setPath(Paths.get("screenshots/" + fileName + ".png")));
    }
}
