package base;
import org.testng.annotations.AfterSuite;
import static base.Page.driver;

public class BaseTest {

    @AfterSuite
    public void tearDown() {

        if (null != driver) {
            driver.close();
            driver.quit();
        }
    }
}
