import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TransferFundsPage {
    private WebDriver driver;
    private By amountLocator = By.id("amount");
    private By sourceAccountLocator = By.id("fromAccountId");
    private By destinationAccountLocator = By.id("toAccountId");
    private By transferButtonLocator = By.cssSelector("input[value='Transfer']");
    private By amountResultLocator = By.id("amountResult");
    private By sourceAccountResultLocator = By.id("fromAccountIdResult");
    private By destinationAccountResultLocator = By.id("toAccountIdResult");

    public TransferFundsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterAmount(String amount) {
        driver.findElement(amountLocator).sendKeys(amount);
    }

    public void enterSourceAccount(String sourceAccount) {
        driver.findElement(sourceAccountLocator).sendKeys(sourceAccount);
    }

    public void enterDestinationAccount(String destinationAccount) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(destinationAccountLocator).sendKeys(destinationAccount);
    }

    public void clickTransferButton() {
        driver.findElement(transferButtonLocator).click();
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public String getResultAmount() {//Get the amount from the confirmation message
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(amountResultLocator));
        String amountWithoutFormat = driver.findElement(amountResultLocator).getText();
        return formatCurrency(amountWithoutFormat);
    }

    // Get the number of the source account from the confirmation message
    public String getSourceAccountResult() {
        return driver.findElement(sourceAccountResultLocator).getText();
    }

    //Get the number of the destination account from the confirmation message
    public String getDestinationAccountResult() {
        return driver.findElement(destinationAccountResultLocator).getText();
    }

    // Parse the currency
    private String formatCurrency(String currency) {
        // Remove the dollar sign
        String withoutSymbol = currency.replace("$", "");

        // Parse the value into a double
        double value = Double.parseDouble(withoutSymbol);

        // Convert to integer and return as string
        return String.valueOf((int) value);
    }

    // Extract accounts from select element (dropdown Menu)
    private List<String> getIntegersFromDropdownMenu(By AccountLocator) {
        WebElement accountNumbersSelect = driver.findElement(AccountLocator);
        List<WebElement> accountsOptions = accountNumbersSelect.findElements(By.tagName("option"));
        List<String> accountNumbersList = new ArrayList<>();
        for (WebElement accountNumber : accountsOptions) {
            accountNumbersList.add(accountNumber.getText());
        }
        return accountNumbersList;
    }

    public List<String> getAccountNumbersfromDestinationDropdownMenu() {
        return getIntegersFromDropdownMenu(destinationAccountLocator);
    }

    public List<String> getAccountNumbersfromSourceDropdownMenu() {
        return getIntegersFromDropdownMenu(sourceAccountLocator);
    }
}
