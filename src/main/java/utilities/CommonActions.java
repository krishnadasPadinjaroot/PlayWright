package utilities;

import com.microsoft.playwright.Frame;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.MouseButton;
import com.microsoft.playwright.options.SelectOption;
import factory.BrowserFactory;

import java.nio.file.Paths;

public class CommonActions {

    protected final Page page = BrowserFactory.page();

    /* ==========================================================
                        CLICK OPERATIONS
       ========================================================== */

    public void click(Locator locator) { locator.click(); }

    public void doubleClick(Locator locator) { locator.dblclick(); }

    public void rightClick(Locator locator) {
        locator.click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));
    }

    public void middleClick(Locator locator) {
        locator.click(new Locator.ClickOptions().setButton(MouseButton.MIDDLE));
    }

    /* ==========================================================
                        TEXT OPERATIONS
       ========================================================== */

    public void fillText(Locator locator, String text) {
        locator.fill(text);
    }

    public void typeText(Locator locator, String text) {
        locator.pressSequentially(text);
    }

    public void clearText(Locator locator) {
        locator.clear();
    }

    public String getText(Locator locator) {
        return locator.innerText();
    }

    public String getTextContent(Locator locator) {
        return locator.textContent();
    }

    public String getInputValue(Locator locator) {
        return locator.inputValue();
    }

    /* ==========================================================
                        STATE OPERATIONS
       ========================================================== */

    public boolean isVisible(Locator locator) {
        return locator.isVisible();
    }

    public boolean isHidden(Locator locator) {
        return locator.isHidden();
    }

    public boolean isEnabled(Locator locator) {
        return locator.isEnabled();
    }

    public boolean isDisabled(Locator locator) {
        return locator.isDisabled();
    }

    public boolean isChecked(Locator locator) {
        return locator.isChecked();
    }

    public boolean isEditable(Locator locator) {
        return locator.isEditable();
    }

    /* ==========================================================
                        ATTRIBUTE OPERATIONS
       ========================================================== */

    public String getAttribute(Locator locator, String attribute) {
        return locator.getAttribute(attribute);
    }

    public String getInnerHTML(Locator locator) {
        return locator.innerHTML();
    }

    /* ==========================================================
                        MOUSE OPERATIONS
       ========================================================== */

    public void hover(Locator locator) {
        locator.hover();
    }

    public void dragAndDrop(Locator source, Locator target) {
        source.dragTo(target);
    }

    public void scrollIntoView(Locator locator) {
        locator.scrollIntoViewIfNeeded();
    }

    /* ==========================================================
                        KEYBOARD OPERATIONS
       ========================================================== */

    public void pressKey(Locator locator, String key) {
        locator.press(key);
    }

    /* ==========================================================
                        CHECKBOX / RADIO OPERATIONS
       ========================================================== */

    public void check(Locator locator) {
        locator.check();
    }

    public void uncheck(Locator locator) {
        locator.uncheck();
    }

    /* ==========================================================
                        DROPDOWN OPERATIONS
       ========================================================== */

    public void selectByValue(Locator locator, String value) {
        locator.selectOption(value);
    }

    public void selectByLabel(Locator locator, String label) {
        locator.selectOption(new SelectOption().setLabel(label));
    }

    public void selectByIndex(Locator locator, int index) {
        locator.selectOption(new SelectOption().setIndex(index));
    }

    /* ==========================================================
                        FILE OPERATIONS
       ========================================================== */

    public void uploadFile(Locator locator, String path) {
        locator.setInputFiles(Paths.get(path));
    }

    /* ==========================================================
                        SCREENSHOT OPERATIONS
       ========================================================== */

    public byte[] takeScreenshot() {
        return page.screenshot();
    }

    public byte[] takeElementScreenshot(Locator locator) {
        return locator.screenshot();
    }

    /* ==========================================================
                        FRAME OPERATIONS
       ========================================================== */

    public Frame getFrameByName(String name) {
        return page.frame(name);
    }

    public FrameLocator frameLocator(String selector) {
        return page.frameLocator(selector);
    }

    /* ==========================================================
                        WINDOW OPERATIONS
       ========================================================== */

    public Page waitForPopup(Runnable action) {
        return page.waitForPopup(action);
    }
}