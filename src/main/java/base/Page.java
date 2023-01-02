package base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Page {

    public static WebDriver driver;
    public static Properties config = new Properties();
    public static FileInputStream fis;
    public static WebDriverWait wait;

    public Page() {
        if (driver == null)
            try {
                fis = new FileInputStream(System.getProperty("user.dir")
                        + "\\Config.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        try {
            config.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        WebDriverManager.chromedriver().setup();
       ChromeOptions options = new ChromeOptions();
        options.addArguments("--headed");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
                TimeUnit.SECONDS);

    }
    public void open_page(String path) {

        driver.get(config.getProperty("base_url")+path);
    }
 }


