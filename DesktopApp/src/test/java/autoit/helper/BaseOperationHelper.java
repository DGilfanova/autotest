package autoit.helper;

import autoit.ApplicationManager;
import autoit.base.HelperBase;

/**
 * @author d.gilfanova
 */
public class BaseOperationHelper extends HelperBase {

    private final static String EDIT_FIELD_ID = "15";
    private static final String CLOSE_BUTTON_NAME = "Button";

    public BaseOperationHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void putText(String text) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElementById(EDIT_FIELD_ID).sendKeys(text);
        Thread.sleep(4000);
    }

    public String getText() {
        return driver.findElementById(EDIT_FIELD_ID).getText();
    }

    public void exitAppWithoutSave() {
        driver.findElementByClassName(CLOSE_BUTTON_NAME).click();
    }
}
