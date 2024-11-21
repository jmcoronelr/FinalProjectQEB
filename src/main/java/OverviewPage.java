import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class OverviewPage {
    private WebDriver driver;

    private By accountsOverviewLocator = By.cssSelector("tbody > tr:not(:last-child)");
    private By openAccountLinkLocator = By.linkText("Open New Account");
    private By transferFundsLinkLocator = By.linkText("Transfer Funds");
    private By accountsOverviewLinkLocator = By.linkText("Accounts Overview");

    public OverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getAccountsOverviewCount() { //Get the number of accounts available
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        return driver.findElements(accountsOverviewLocator).size();
    }

    public OverviewPage showOverviewPage() { // Redirect to OverviewPage
        driver.findElement(accountsOverviewLinkLocator).click();
        return new OverviewPage(driver);
    }


    public OpenAccountPage openNewAccount() { // Redirect to OpenAccountPage
        driver.findElement(openAccountLinkLocator).click();
        return new OpenAccountPage(driver);
    }

    public TransferFundsPage transferFunds() { // Redirect to TransferFundsPage
        driver.findElement(transferFundsLinkLocator).click();
        return new TransferFundsPage(driver);
    }


    public WebDriver getDriver() {
        return this.driver;
    }


    public List<String> getAccountNumbersWithPositiveBalance() { // Get Accounts with positive balance
        List<WebElement> accounts = driver.findElements(accountsOverviewLocator);
        List<String> accountNumbers = new ArrayList<>();

        for (WebElement account : accounts) {

            WebElement accountNumberElement = account.findElement(By.cssSelector("td > a"));
            String accountNumberText = accountNumberElement.getText();


            WebElement amountElement = account.findElement(By.cssSelector("td:nth-child(3)"));// Get the available amount
            //Format the amount
            String amountText = amountElement.getText().replace("$", "").replace(",", "").trim();


            double amount = Double.parseDouble(amountText);

            if (amount > 0) {//If the amount is more than zero, the account is added
                accountNumbers.add(accountNumberText);
            }
        }

        return accountNumbers;
    }
}
