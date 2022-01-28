package driver;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {

    private String homePageUrl = "https://www.hepsiburada.com/";
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeScenario
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(homePageUrl);
        wait = new WebDriverWait(driver, 20);
    }

    @AfterScenario
    public void closeDriver() {
        driver.quit();
    }
}
