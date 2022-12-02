package autoit.utils;

import autoit.ApplicationManager;

/**
 * @author d.gilfanova
 */
public final class Destructor {

    public static void addDestructor(Runnable runnable) {
        Thread hook = new Thread(runnable);
        Runtime.getRuntime().addShutdownHook(hook);
    }

    public static void addManagerDestructor(ApplicationManager applicationManager) {
        addDestructor(() -> {
            try {
                applicationManager.getDriver().quit();
            }
            catch (Exception ignored) {
            }
        });
    }
}
