package autoit.test;

import autoit.base.TestBase;
import org.junit.Assert;
import org.junit.Test;

import static autoit.utils.Constant.TEST_TEXT;

/**
 * @author d.gilfanova
 */

public class CloseTest extends TestBase {

    @Test
    public void calculatorTest() throws InterruptedException {
        applicationManager.getOperationHelper().putText(TEST_TEXT);
        String text = applicationManager.getOperationHelper().getText();
        Assert.assertEquals(TEST_TEXT, text);
        applicationManager.getOperationHelper().exitAppWithoutSave();
    }
}
