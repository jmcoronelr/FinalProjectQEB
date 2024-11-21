import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class OverviewPage {
    private WebDriver driver;

    // Locators
    private By accountsOverviewLocator = By.cssSelector("tbody > tr");
    private By openAccountLinkLocator = By.linkText("Open New Account");
    private By transferFundsLinkLocator = By.linkText("Transfer Funds");
    // Constructor
    public OverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    // Get count of rows in the accounts overview table
    public int getAccountsOverviewCount() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver.findElements(accountsOverviewLocator).size();
    }

    // Navigate to the Open Account page
    public OpenAccountPage openNewAccount() {
        driver.findElement(openAccountLinkLocator).click();
        return new OpenAccountPage(driver);
    }
    public TransferFundsPage transferFunds() {
        driver.findElement(transferFundsLinkLocator).click();
        return new TransferFundsPage(driver);
    }
    // Get the WebDriver instance
    public WebDriver getDriver() {
        return this.driver;
    }

    // Get the first two account numbers where the amount in the 3rd <td> is greater than 0
    public List<Integer> getAccountNumbersWithPositiveBalance() {
        List<WebElement> accounts = driver.findElements(accountsOverviewLocator); // Locate all rows
        List<Integer> accountNumbers = new ArrayList<>();

        for (WebElement account : accounts) {
            try {
                // Locate the anchor tag within the first <td> of the row
                WebElement accountNumberElement = account.findElement(By.cssSelector("td > a"));
                String accountNumberText = accountNumberElement.getText();

                // Locate the 3rd <td> which corresponds to the amount
                WebElement amountElement = account.findElement(By.cssSelector("td:nth-child(3)"));
                String amountText = amountElement.getText().replace("$", "").replace(",", "").trim();

                // Parse the amount and check if it is greater than 0
                double amount = Double.parseDouble(amountText);

                if (amount > 0) {
                    // Add the account number to the list
                    accountNumbers.add(Integer.parseInt(accountNumberText));
                }
            } catch (Exception e) {
                System.out.println("Error processing row: " + e.getMessage());
            }
        }

        return accountNumbers;
    }
}
