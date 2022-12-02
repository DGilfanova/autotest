package autoit;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import autoit.helper.BaseOperationHelper;
import autoit.utils.Destructor;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;

import static autoit.utils.Constant.APP_PATH;
import static autoit.utils.Constant.WINIUM_DRIVER_PATH;

/**
 * @author d.gilfanova
 */
public class ApplicationManager {

    private static WiniumDriver driver;

    private final BaseOperationHelper operationHelper;

    private static final ThreadLocal<ApplicationManager> app = new ThreadLocal<>();

    private ApplicationManager() {
        DesktopOptions options = new DesktopOptions();
        options.setApplicationPath(APP_PATH);
        File driverPath = new File(WINIUM_DRIVER_PATH);
        WiniumDriverService service = new WiniumDriverService.Builder()
            .usingDriverExecutable(driverPath)
            .usingPort(9999)
            .withVerbose(true)
            .withSilent(false)
            .buildDesktopService();

        try {
            service.start();
        } catch (IOException e) {
            throw new IllegalStateException(e.getMessage());
        }

        driver = new WiniumDriver(service, options);

        this.operationHelper = new BaseOperationHelper(this);

        Destructor.addManagerDestructor(this);
    }

    public static ApplicationManager getAppInstance() {
        if (Objects.isNull(app.get())) {
            ApplicationManager newInstance = new ApplicationManager();
            app.set(newInstance);
        }
        return app.get();
    }

    public WiniumDriver getDriver() {
        return driver;
    }

    public BaseOperationHelper getOperationHelper() {
        return operationHelper;
    }
}
