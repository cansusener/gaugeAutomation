package PageModel;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class HomePage extends BaseMethods{

    public static By txtSearchBar = By.xpath("//input[@class='desktopOldAutosuggestTheme-input']");
    public static By searchButton = By.xpath("//div[@class='SearchBoxOld-buttonContainer']");

    public static By getRegister = By.xpath("//div[@id='myAccount']");
    public static By register = By.xpath("//a[@id='register']");

    public static By searchResultSummary = By.xpath("//h1[@class='searchResultSummaryBar-bold']");

    @Step("Hepsiburada sitesine gidilir.")
    public void gotoWebsite() {
        driver.get("https://www.hepsiburada.com/");
    }

    @Step("Arama kısmına <key> yazilir.")
    public void searchArea(String key) {
        sendKeys(txtSearchBar,key);
        clickElement(searchButton);
        String summary = getText(searchResultSummary);
        if (summary.contains(key)) {
            assertEquals(true, true);
        } else {
            assertEquals(true, false);
        }

    }
}
