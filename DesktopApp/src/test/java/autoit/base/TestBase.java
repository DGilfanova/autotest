package autoit.base;

import autoit.ApplicationManager;
import org.junit.Before;

public class TestBase {

    public ApplicationManager applicationManager;

    @Before
    public void setUp() {
        applicationManager = ApplicationManager.getAppInstance();
    }
}
