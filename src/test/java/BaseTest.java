import org.junit.AfterClass;
import org.junit.BeforeClass;
import steps.BaseSteps;

public class BaseTest {

    @BeforeClass
    public static void beforeTest() {
        BaseSteps.beforeSteps();
    }

    @AfterClass
    public static void afterTest() {
        BaseSteps.afterSteps();
    }
}
