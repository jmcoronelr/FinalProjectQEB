import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OpenAccountPage {
    private WebDriver driver;
    private By openAccountButtonLocator = By.cssSelector("input[value='Open New Account']");
    private By accountsOverviewLinkLocator = By.linkText("Accounts Overview");

    public OpenAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOpenAccountButton() throws InterruptedException {
        Thread.sleep(1000); // Stop the execution for 1 second
        driver.findElement(openAccountButtonLocator).click();
    }

    public OverviewPage getOverviewPage() { //Direct to OverviewPage
        driver.findElement(accountsOverviewLinkLocator).click();
        return new OverviewPage(driver);
    }
}
