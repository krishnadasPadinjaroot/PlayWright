package utilities;

import base.BaseTest;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.MouseButton;
import com.microsoft.playwright.options.SelectOption;
import factory.BrowserFactory;
import org.slf4j.Logger;

import java.nio.file.Paths;


public class CommonActions {

    protected final Page page = BrowserFactory.page();
    private static final Logger log =
            LoggerUtils.getLogger(BaseTest.class);
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
            log.error("Failed to right click on element: {}", locator, e);
            throw e;
        }
    }


    public void middleClick(Locator locator) {
        try {
            log.info("Middle clicking on element: {}", locator);
            locator.click(new Locator.ClickOptions().setButton(MouseButton.MIDDLE));
            log.info("Successfully middle clicked.");
        } catch (Exception e) {
            log.error("Failed to middle click on element: {}", locator, e);
            throw e;
        }
    }

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
        boolean result = locator.isVisible();
        log.info("Element visibility : {}", result);
        return result;
    }

    public boolean isHidden(Locator locator) {
        return locator.isHidden();
    }

    public boolean isEnabled(Locator locator) {
        boolean result = locator.isEnabled();
        log.info("Element enabled : {}", result);
        return result;
    }

    public boolean isDisabled(Locator locator) {
        return locator.isDisabled();
    }

    public boolean isChecked(Locator locator) {
        boolean result = locator.isChecked();
        log.info("Element checked : {}", result);
        return result;
    }

    public boolean isEditable(Locator locator) {
        return locator.isEditable();
    }

    /* ==========================================================
                        ATTRIBUTE OPERATIONS
       ========================================================== */

    public String getAttribute(Locator locator, String attribute) {
        try {
            log.info("Getting attribute '{}' from {}", attribute, locator);
            String value = locator.getAttribute(attribute);
            log.info("Attribute value : {}", value);
            return value;
        } catch (Exception e) {
            log.error("Failed to get attribute.", e);
            throw e;
        }
    }

    public String getInnerHTML(Locator locator) {
        return locator.innerHTML();
    }

    /* ==========================================================
                        MOUSE OPERATIONS
       ========================================================== */

    public void hover(Locator locator) {
        try {
            log.info("Hovering over {}", locator);
            locator.hover();
            log.info("Hover successful.");
        } catch (Exception e) {
            log.error("Hover failed.", e);
            throw e;
        }
    }


    public void dragAndDrop(Locator source, Locator target) {
        try {
            log.info("Dragging element from {} to {}", source, target);
            source.dragTo(target);
            log.info("Drag and Drop successful.");
        } catch (Exception e) {
            log.error("Drag and Drop failed.", e);
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
                        CHECKBOX / RADIO OPERATIONS
       ========================================================== */

    public void check(Locator locator) {
        try {
            log.info("Checking {}", locator);
            locator.check();
            log.info("Checkbox checked.");
        } catch (Exception e) {
            log.error("Failed to check checkbox.", e);
            throw e;
        }
    }

    public void uncheck(Locator locator) {
        try {
            log.info("Unchecking {}", locator);
            locator.uncheck();
            log.info("Checkbox unchecked.");
        } catch (Exception e) {
            log.error("Failed to uncheck checkbox.", e);
            throw e;
        }
    }

    /* ==========================================================
                        DROPDOWN OPERATIONS
       ========================================================== */

    public void selectByValue(Locator locator, String value) {
        try {
            log.info("Selecting value '{}' from dropdown.", value);
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

    /* ==========================================================
                        FILE OPERATIONS
       ========================================================== */

    public void uploadFile(Locator locator, String path) {
        try {
            log.info("Uploading file {}", path);
            locator.setInputFiles(Paths.get(path));
            log.info("File uploaded successfully.");
        } catch (Exception e) {
            log.error("File upload failed.", e);
            throw e;
        }
    }

    /* ==========================================================
                        SCREENSHOT OPERATIONS
       ========================================================== */

    public byte[] takeScreenshot() {
        log.info("Capturing page screenshot.");
        return page.screenshot();
    }

    public byte[] takeElementScreenshot(Locator locator) {
        log.info("Capturing element screenshot.");
        return locator.screenshot();
    }

    /* ==========================================================
                        FRAME OPERATIONS
       ========================================================== */

    public Frame getFrameByName(String name) {
        log.info("Switching to frame '{}'", name);
        return page.frame(name);
    }

    public FrameLocator frameLocator(String selector) {
        log.info("Locating frame '{}'", selector);
        return page.frameLocator(selector);
    }

    /* ==========================================================
                        WINDOW OPERATIONS
       ========================================================== */

    public Page waitForPopup(Runnable action) {
        log.info("Waiting for popup window.");
        return page.waitForPopup(action);
    }
}