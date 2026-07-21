package utilities;

import base.BaseTest;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.MouseButton;
import com.microsoft.playwright.options.SelectOption;
import factory.BrowserFactory;
import org.slf4j.Logger;

import java.nio.file.Paths;
import java.util.List;


public class CommonActions {

    protected final Page page = BrowserFactory.page();
    private static final Logger log =
            LoggerUtils.getLogger(BaseTest.class);
   /* ==========================================================
                        TEXT OPERATIONS
       ========================================================== */

    public void fillText(Locator locator, String text) {
        try {
            log.info("Entering text '{}' into {}", text, locator);
            locator.fill(text);
            log.info("Text entered successfully.");
        } catch (Exception e) {
            log.error("Failed to enter text.", e);
            throw e;
        }
    }

    public void typeText(Locator locator, String text) {
        try {
            log.info("Typing text '{}' into {}", text, locator);
            locator.pressSequentially(text);
            log.info("Typing completed.");
        } catch (Exception e) {
            log.error("Failed to type text.", e);
            throw e;
        }
    }

    public void clearText(Locator locator) {
        try {
            log.info("Clearing text from {}", locator);
            locator.clear();
            log.info("Text cleared.");
        } catch (Exception e) {
            log.error("Failed to clear text.", e);
            throw e;
        }
    }

    public String getText(Locator locator) {
        try {
            log.info("Getting text from {}", locator);
            String value = locator.innerText();
            log.info("Retrieved text: {}", value);
            return value;
        } catch (Exception e) {
            log.error("Failed to get text.", e);
            throw e;
        }
    }



    public void scrollIntoView(Locator locator) {
        try {
            log.info("Scrolling to {}", locator);
            locator.scrollIntoViewIfNeeded();
            log.info("Scroll successful.");
        } catch (Exception e) {
            log.error("Scroll failed.", e);
            throw e;
        }
    }

    /* ==========================================================
                        KEYBOARD OPERATIONS
       ========================================================== */

    public void pressKey(Locator locator, String key) {
        try {
            log.info("Pressing key '{}' on {}", key, locator);
            locator.press(key);
            log.info("Key pressed.");
        } catch (Exception e) {
            log.error("Failed to press key.", e);
            throw e;
        }
    }

    /* ==========================================================
                    CLICK OPERATIONS
   ========================================================== */

    public void click(Locator locator) {
        try {
            log.info("Clicking on element: {}", locator);
            locator.click();
            log.info("Successfully clicked on element.");
        } catch (Exception e) {
            log.error("Failed to click on element: {}", locator, e);
            throw e;
        }
    }

    public void doubleClick(Locator locator) {
        try {
            log.info("Double clicking on element: {}", locator);
            locator.dblclick();
            log.info("Successfully double clicked.");
        } catch (Exception e) {
            log.error("Failed to double click on element: {}", locator, e);
            throw e;
        }
    }

    public void rightClick(Locator locator) {
        try {
            log.info("Right clicking on element: {}", locator);
            locator.click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));
            log.info("Successfully right clicked.");
        } catch (Exception e) {
            log.error("Failed to right click.", e);
            throw e;
        }
    }

    public void middleClick(Locator locator) {
        try {
            log.info("Middle clicking on element: {}", locator);
            locator.click(new Locator.ClickOptions().setButton(MouseButton.MIDDLE));
            log.info("Successfully middle clicked.");
        } catch (Exception e) {
            log.error("Failed to middle click.", e);
            throw e;
        }
    }

    public void forceClick(Locator locator) {
        try {
            log.info("Force clicking on element.");
            locator.click(new Locator.ClickOptions().setForce(true));
            log.info("Force click successful.");
        } catch (Exception e) {
            log.error("Force click failed.", e);
            throw e;
        }
    }

    public void clickWithTimeout(Locator locator, double timeout) {
        try {
            log.info("Clicking with timeout {} ms", timeout);
            locator.click(new Locator.ClickOptions().setTimeout(timeout));
            log.info("Click successful.");
        } catch (Exception e) {
            log.error("Click with timeout failed.", e);
            throw e;
        }
    }

    public void clickUsingJS(Locator locator) {
        try {
            log.info("Clicking using JavaScript.");
            locator.evaluate("element => element.click()");
            log.info("JavaScript click successful.");
        } catch (Exception e) {
            log.error("JavaScript click failed.", e);
            throw e;
        }
    }

    /* ==========================================================
                    MOUSE OPERATIONS
   ========================================================== */

    public void hover(Locator locator) {
        try {
            log.info("Hovering over element: {}", locator);
            locator.hover();
            log.info("Hover operation completed.");
        } catch (Exception e) {
            log.error("Failed to hover over element.", e);
            throw e;
        }
    }

    public void dragAndDrop(Locator source, Locator target) {
        try {
            log.info("Dragging element from {} to {}", source, target);
            source.dragTo(target);
            log.info("Drag and Drop completed.");
        } catch (Exception e) {
            log.error("Drag and Drop failed.", e);
            throw e;
        }
    }

    public void mouseMove(int x, int y) {
        try {
            log.info("Moving mouse to X={}, Y={}", x, y);
            page.mouse().move(x, y);
            log.info("Mouse moved successfully.");
        } catch (Exception e) {
            log.error("Mouse move failed.", e);
            throw e;
        }
    }

    public void mouseDown() {
        try {
            log.info("Mouse button down.");
            page.mouse().down();
            log.info("Mouse down successful.");
        } catch (Exception e) {
            log.error("Mouse down failed.", e);
            throw e;
        }
    }

    public void mouseUp() {
        try {
            log.info("Mouse button up.");
            page.mouse().up();
            log.info("Mouse up successful.");
        } catch (Exception e) {
            log.error("Mouse up failed.", e);
            throw e;
        }
    }

    public void mouseWheel(int deltaX, int deltaY) {
        try {
            log.info("Scrolling mouse wheel X={} Y={}", deltaX, deltaY);
            page.mouse().wheel(deltaX, deltaY);
            log.info("Mouse wheel completed.");
        } catch (Exception e) {
            log.error("Mouse wheel failed.", e);
            throw e;
        }
    }

    public void clickAtPosition(int x, int y) {
        try {
            log.info("Clicking at X={}, Y={}", x, y);
            page.mouse().click(x, y);
            log.info("Mouse click successful.");
        } catch (Exception e) {
            log.error("Mouse click failed.", e);
            throw e;
        }
    }

    /* ==========================================================
                    STATE OPERATIONS
   ========================================================== */

    public boolean isVisible(Locator locator) {
        boolean status = locator.isVisible();
        log.info("Element visible : {}", status);
        return status;
    }

    public boolean isHidden(Locator locator) {
        boolean status = locator.isHidden();
        log.info("Element hidden : {}", status);
        return status;
    }

    public boolean isEnabled(Locator locator) {
        boolean status = locator.isEnabled();
        log.info("Element enabled : {}", status);
        return status;
    }

    public boolean isDisabled(Locator locator) {
        boolean status = locator.isDisabled();
        log.info("Element disabled : {}", status);
        return status;
    }

    public boolean isChecked(Locator locator) {
        boolean status = locator.isChecked();
        log.info("Element checked : {}", status);
        return status;
    }

    public boolean isEditable(Locator locator) {
        boolean status = locator.isEditable();
        log.info("Element editable : {}", status);
        return status;
    }

    public boolean isEmpty(Locator locator) {
        try {
            boolean status = locator.inputValue().trim().isEmpty();
            log.info("Input empty : {}", status);
            return status;
        } catch (Exception e) {
            log.error("Failed to verify empty field.", e);
            throw e;
        }
    }

    /* ==========================================================
                    ATTRIBUTE OPERATIONS
   ========================================================== */

    public String getAttribute(Locator locator, String attribute) {
        try {
            log.info("Getting attribute '{}' from element.", attribute);
            String value = locator.getAttribute(attribute);
            log.info("Attribute value : {}", value);
            return value;
        } catch (Exception e) {
            log.error("Failed to get attribute.", e);
            throw e;
        }
    }

    public String getInnerHTML(Locator locator) {
        try {
            log.info("Getting inner HTML.");
            String html = locator.innerHTML();
            log.info("Inner HTML retrieved.");
            return html;
        } catch (Exception e) {
            log.error("Failed to get inner HTML.", e);
            throw e;
        }
    }

    public String getInnerText(Locator locator) {
        try {
            log.info("Getting inner text.");
            String text = locator.innerText();
            log.info("Inner text : {}", text);
            return text;
        } catch (Exception e) {
            log.error("Failed to get inner text.", e);
            throw e;
        }
    }

    public String getTextContent(Locator locator) {
        try {
            log.info("Getting text content.");
            String text = locator.textContent();
            log.info("Text content : {}", text);
            return text;
        } catch (Exception e) {
            log.error("Failed to get text content.", e);
            throw e;
        }
    }

    public String getInputValue(Locator locator) {
        try {
            log.info("Getting input value.");
            String value = locator.inputValue();
            log.info("Input value : {}", value);
            return value;
        } catch (Exception e) {
            log.error("Failed to get input value.", e);
            throw e;
        }
    }

    public String getClassName(Locator locator) {
        return getAttribute(locator, "class");
    }

    public String getId(Locator locator) {
        return getAttribute(locator, "id");
    }

    public String getName(Locator locator) {
        return getAttribute(locator, "name");
    }

    public String getPlaceholder(Locator locator) {
        return getAttribute(locator, "placeholder");
    }

    public String getValue(Locator locator) {
        return getAttribute(locator, "value");
    }

    public String getTagName(Locator locator) {
        try {
            log.info("Getting tag name.");
            String tag = locator.evaluate("e => e.tagName").toString();
            log.info("Tag Name : {}", tag);
            return tag;
        } catch (Exception e) {
            log.error("Failed to get tag name.", e);
            throw e;
        }
    }

    /* ==========================================================
                    VALIDATION OPERATIONS
   ========================================================== */

    public boolean verifyText(Locator locator, String expectedText) {
        try {
            log.info("Verifying text. Expected: {}", expectedText);
            String actualText = locator.innerText().trim();
            boolean status = actualText.equals(expectedText);
            log.info("Actual: {}, Status: {}", actualText, status);
            return status;
        } catch (Exception e) {
            log.error("Text verification failed.", e);
            throw e;
        }
    }

    public boolean verifyContainsText(Locator locator, String expectedText) {
        try {
            log.info("Verifying partial text: {}", expectedText);
            String actualText = locator.innerText();
            boolean status = actualText.contains(expectedText);
            log.info("Actual: {}, Status: {}", actualText, status);
            return status;
        } catch (Exception e) {
            log.error("Contains text verification failed.", e);
            throw e;
        }
    }

    public boolean verifyAttribute(Locator locator, String attribute, String expectedValue) {
        try {
            log.info("Verifying attribute '{}'", attribute);
            String actualValue = locator.getAttribute(attribute);
            boolean status = expectedValue.equals(actualValue);
            log.info("Expected: {}, Actual: {}, Status: {}", expectedValue, actualValue, status);
            return status;
        } catch (Exception e) {
            log.error("Attribute verification failed.", e);
            throw e;
        }
    }

    public boolean verifyTitle(String expectedTitle) {
        try {
            log.info("Verifying page title.");
            String actualTitle = page.title();
            boolean status = expectedTitle.equals(actualTitle);
            log.info("Expected: {}, Actual: {}", expectedTitle, actualTitle);
            return status;
        } catch (Exception e) {
            log.error("Title verification failed.", e);
            throw e;
        }
    }

    public boolean verifyURL(String expectedUrl) {
        try {
            log.info("Verifying URL.");
            String actualUrl = page.url();
            boolean status = actualUrl.equals(expectedUrl);
            log.info("Expected: {}, Actual: {}", expectedUrl, actualUrl);
            return status;
        } catch (Exception e) {
            log.error("URL verification failed.", e);
            throw e;
        }
    }

    public boolean verifyElementCount(String selector, int expectedCount) {
        try {
            log.info("Verifying element count.");
            int actualCount = page.locator(selector).count();
            boolean status = actualCount == expectedCount;
            log.info("Expected: {}, Actual: {}", expectedCount, actualCount);
            return status;
        } catch (Exception e) {
            log.error("Element count verification failed.", e);
            throw e;
        }
    }

    /* ==========================================================
                CHECKBOX / RADIO OPERATIONS
   ========================================================== */

    public void check(Locator locator) {
        try {
            log.info("Checking checkbox.");
            locator.check();
            log.info("Checkbox checked.");
        } catch (Exception e) {
            log.error("Check failed.", e);
            throw e;
        }
    }

    public void uncheck(Locator locator) {
        try {
            log.info("Unchecking checkbox.");
            locator.uncheck();
            log.info("Checkbox unchecked.");
        } catch (Exception e) {
            log.error("Uncheck failed.", e);
            throw e;
        }
    }

    public void selectRadioButton(Locator locator) {
        try {
            log.info("Selecting radio button.");
            locator.check();
            log.info("Radio button selected.");
        } catch (Exception e) {
            log.error("Radio button selection failed.", e);
            throw e;
        }
    }

    /* ==========================================================
                    DROPDOWN OPERATIONS
   ========================================================== */

    public void selectByValue(Locator locator, String value) {
        try {
            log.info("Selecting value '{}'", value);
            locator.selectOption(value);
            log.info("Value selected.");
        } catch (Exception e) {
            log.error("Dropdown selection failed.", e);
            throw e;
        }
    }

    public void selectByLabel(Locator locator, String label) {
        try {
            log.info("Selecting label '{}'", label);
            locator.selectOption(new SelectOption().setLabel(label));
            log.info("Label selected.");
        } catch (Exception e) {
            log.error("Dropdown selection failed.", e);
            throw e;
        }
    }

    public void selectByIndex(Locator locator, int index) {
        try {
            log.info("Selecting index {}", index);
            locator.selectOption(new SelectOption().setIndex(index));
            log.info("Index selected.");
        } catch (Exception e) {
            log.error("Dropdown selection failed.", e);
            throw e;
        }
    }

        public String getSelectedText(Locator locator) {
        try {
            log.info("Getting selected text.");
            String text = locator.locator("option:checked").textContent();
            log.info("Selected text: {}", text);
            return text;
        } catch (Exception e) {
            log.error("Failed to get selected text.", e);
            throw e;
        }
    }

    /* ==========================================================
                    FILE OPERATIONS
   ========================================================== */

    public void uploadFile(Locator locator, String filePath) {
        try {
            log.info("Uploading file : {}", filePath);
            locator.setInputFiles(Paths.get(filePath));
            log.info("File uploaded successfully.");
        } catch (Exception e) {
            log.error("File upload failed.", e);
            throw e;
        }
    }

    public Download downloadFile(Runnable action) {
        try {
            log.info("Waiting for file download.");
            Download download = page.waitForDownload(action);
            log.info("Downloaded file : {}", download.suggestedFilename());
            return download;
        } catch (Exception e) {
            log.error("File download failed.", e);
            throw e;
        }
    }

    public String getDownloadedFileName(Download download) {
        try {
            String fileName = download.suggestedFilename();
            log.info("Downloaded File Name : {}", fileName);
            return fileName;
        } catch (Exception e) {
            log.error("Unable to fetch downloaded file name.", e);
            throw e;
        }
    }

    /* ==========================================================
                    SCREENSHOT OPERATIONS
   ========================================================== */

    public byte[] takeScreenshot() {
        try {
            log.info("Capturing page screenshot.");
            return page.screenshot();
        } catch (Exception e) {
            log.error("Screenshot failed.", e);
            throw e;
        }
    }

    public byte[] takeElementScreenshot(Locator locator) {
        try {
            log.info("Capturing element screenshot.");
            return locator.screenshot();
        } catch (Exception e) {
            log.error("Element screenshot failed.", e);
            throw e;
        }
    }

    public void saveScreenshot(String fileName) {
        try {
            log.info("Saving screenshot : {}", fileName);

            page.screenshot(new Page.ScreenshotOptions()
                    .setPath(Paths.get(fileName)));

            log.info("Screenshot saved.");
        } catch (Exception e) {
            log.error("Saving screenshot failed.", e);
            throw e;
        }
    }

    public void saveFullPageScreenshot(String fileName) {
        try {
            log.info("Saving full page screenshot.");

            page.screenshot(new Page.ScreenshotOptions()
                    .setFullPage(true)
                    .setPath(Paths.get(fileName)));

            log.info("Full page screenshot saved.");
        } catch (Exception e) {
            log.error("Full page screenshot failed.", e);
            throw e;
        }
    }

    public void saveElementScreenshot(Locator locator, String fileName) {
        try {
            log.info("Saving element screenshot.");

            locator.screenshot(new Locator.ScreenshotOptions()
                    .setPath(Paths.get(fileName)));

            log.info("Element screenshot saved.");
        } catch (Exception e) {
            log.error("Element screenshot failed.", e);
            throw e;
        }
    }

    /* ==========================================================
                    FRAME OPERATIONS
   ========================================================== */

    public Frame getFrameByName(String name) {
        try {
            log.info("Getting frame by name : {}", name);
            Frame frame = page.frame(name);
            log.info("Frame located successfully.");
            return frame;
        } catch (Exception e) {
            log.error("Unable to locate frame by name.", e);
            throw e;
        }
    }

    public Frame getFrameByUrl(String url) {
        try {
            log.info("Getting frame by URL : {}", url);

            Frame frame = page.frames()
                    .stream()
                    .filter(f -> f.url().contains(url))
                    .findFirst()
                    .orElse(null);

            log.info("Frame located.");
            return frame;

        } catch (Exception e) {
            log.error("Unable to locate frame by URL.", e);
            throw e;
        }
    }

    public Frame getFrameByIndex(int index) {
        try {
            log.info("Getting frame at index {}", index);

            Frame frame = page.frames().get(index);

            log.info("Frame located.");
            return frame;

        } catch (Exception e) {
            log.error("Unable to locate frame.", e);
            throw e;
        }
    }

    public FrameLocator frameLocator(String selector) {
        try {
            log.info("Creating FrameLocator : {}", selector);
            return page.frameLocator(selector);
        } catch (Exception e) {
            log.error("Unable to create FrameLocator.", e);
            throw e;
        }
    }

    /* ==========================================================
                    WINDOW OPERATIONS
   ========================================================== */

    public Page waitForPopup(Runnable action) {

        try {

            log.info("Waiting for popup.");

            Page popup = page.waitForPopup(action);

            log.info("Popup opened successfully.");

            return popup;

        } catch (Exception e) {

            log.error("Popup wait failed.", e);
            throw e;
        }
    }

    public Page switchToNewTab(Runnable action) {

        try {

            log.info("Opening new tab.");

            Page newTab = page.waitForPopup(action);

            log.info("Switched to new tab.");

            return newTab;

        } catch (Exception e) {

            log.error("Unable to switch to new tab.", e);
            throw e;
        }
    }

    public void closeCurrentTab() {

        try {

            log.info("Closing current tab.");

            page.close();

            log.info("Current tab closed.");

        } catch (Exception e) {

            log.error("Unable to close tab.", e);
            throw e;
        }
    }

    public List<Page> getAllTabs() {

        try {

            log.info("Getting all opened tabs.");

            return page.context().pages();

        } catch (Exception e) {

            log.error("Unable to retrieve tabs.", e);
            throw e;
        }
    }
    /* ==========================================================
                    DIALOG OPERATIONS
   ========================================================== */

    public void acceptAlert() {

        page.onceDialog(Dialog::accept);

        log.info("Alert accepted.");
    }

    public void dismissAlert() {

        page.onceDialog(Dialog::dismiss);

        log.info("Alert dismissed.");
    }

    public void acceptPrompt(String text) {

        page.onceDialog(dialog -> dialog.accept(text));

        log.info("Prompt accepted with text : {}", text);
    }

    public String getDialogMessage() {

        final String[] message = new String[1];

        page.onceDialog(dialog -> {

            message[0] = dialog.message();
            dialog.accept();

        });

        return message[0];
    }

    /* ==========================================================
                JAVASCRIPT OPERATIONS
   ========================================================== */

    public Object executeJavaScript(String script) {

        try {

            log.info("Executing JavaScript.");

            return page.evaluate(script);

        } catch (Exception e) {

            log.error("JavaScript execution failed.", e);
            throw e;
        }
    }

    public Object executeJavaScript(String script, Locator locator) {

        try {

            log.info("Executing JavaScript on Locator.");

            return locator.evaluate(script);

        } catch (Exception e) {

            log.error("JavaScript execution failed.", e);
            throw e;
        }
    }

    public void highlightElement(Locator locator) {

        try {

            log.info("Highlighting element.");

            locator.evaluate(
                    "e => e.style.border='3px solid red'");

        } catch (Exception e) {

            log.error("Highlight failed.", e);
            throw e;
        }
    }

    public void scrollByJS(int x, int y) {

        try {

            log.info("Scrolling using JavaScript.");

            page.evaluate("window.scrollBy(arguments[0],arguments[1])");

        } catch (Exception e) {

            log.error("JavaScript scroll failed.", e);
            throw e;
        }
    }

    /* ==========================================================
                    LOCATOR OPERATIONS
   ========================================================== */

    public int getElementCount(String selector) {

        try {

            int count = page.locator(selector).count();

            log.info("Element Count : {}", count);

            return count;

        } catch (Exception e) {

            log.error("Unable to count elements.", e);
            throw e;
        }
    }

    public Locator getFirstElement(String selector) {

        return page.locator(selector).first();
    }

    public Locator getLastElement(String selector) {

        return page.locator(selector).last();
    }

    public Locator getNthElement(String selector, int index) {

        return page.locator(selector).nth(index);
    }

    public Locator findElement(String selector) {

        return page.locator(selector);
    }

    /* ==========================================================
                    UTILITY OPERATIONS
   ========================================================== */

    public void pause(int milliseconds) {

        try {

            log.info("Pausing execution for {} ms.", milliseconds);

            page.waitForTimeout(milliseconds);

        } catch (Exception e) {

            log.error("Pause failed.", e);
            throw e;
        }
    }

    public String getCurrentUrl() {

        return page.url();
    }

    public String getCurrentTitle() {

        return page.title();
    }

    public void maximizeWindow() {

        log.info("Playwright launches browser maximized using BrowserFactory configuration.");
    }

    public void setDefaultTimeout(double timeout) {

        page.setDefaultTimeout(timeout);

        log.info("Default timeout set to {}", timeout);
    }

    public void setDefaultNavigationTimeout(double timeout) {

        page.setDefaultNavigationTimeout(timeout);

        log.info("Navigation timeout set to {}", timeout);
    }

}