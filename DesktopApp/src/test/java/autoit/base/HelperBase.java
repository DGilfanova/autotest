package autoit.base;

import autoit.ApplicationManager;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * @author d.gilfanova
 */
public class HelperBase {

    protected RemoteWebDriver driver;
    public ApplicationManager applicationManager;

    public HelperBase(ApplicationManager applicationManager) {
        this.applicationManager = applicationManager;
        this.driver = applicationManager.getDriver();
    }
}
