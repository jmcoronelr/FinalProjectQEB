import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;
    private By userNameLocator = By.name("username");
    private By passwordLocator = By.name("password");
    private By loginButtonLocator = By.cssSelector("div.login > input[type='submit']");
    private By firstNameFieldLocator = By.name("customer.firstName");
    private By lastNameFieldLocator = By.name("customer.lastName");
    private By addressFieldLocator = By.name("customer.address.street");
    private By cityFieldLocator = By.name("customer.address.city");
    private By stateFieldLocator = By.name("customer.address.state");
    private By zipFieldLocator = By.name("customer.address.zipCode");
    private By phoneFieldLocator = By.name("customer.phoneNumber");
    private By ssnFieldLocator = By.name("customer.ssn");
    private By userNameFieldLocator = By.name("customer.username");
    private By passwordFieldLocator = By.name("customer.password");
    private By confirmPasswordFieldLocator = By.name("repeatedPassword");
    private By registerButtonLocator = By.cssSelector("input[value='Register']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserNameLocator(String username) {
        driver.findElement(userNameLocator).sendKeys(username);
    }
    public void setPasswordLocator(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
    }
    public OverviewPage clickLoginButton() {
        driver.findElement(loginButtonLocator).click();
        return new OverviewPage(driver);
    }
    public void setFirstNameFieldLocator(String firstName) {
        driver.findElement(firstNameFieldLocator).sendKeys(firstName);
    }
    public void setLastNameFieldLocator(String lastName) {
        driver.findElement(lastNameFieldLocator).sendKeys(lastName);
    }
    public void setAddressFieldLocator(String address) {
        driver.findElement(addressFieldLocator).sendKeys(address);
    }
    public void setCityFieldLocator(String city) {
        driver.findElement(cityFieldLocator).sendKeys(city);
    }
    public void setStateFieldLocator(String state) {
        driver.findElement(stateFieldLocator).sendKeys(state);
    }
    public void setZipFieldLocator(String zip) {
        driver.findElement(zipFieldLocator).sendKeys(zip);
    }
    public void setPhoneFieldLocator(String phone) {
        driver.findElement(phoneFieldLocator).sendKeys(phone);
    }
    public void setSsnFieldLocator(String ssn) {
        driver.findElement(ssnFieldLocator).sendKeys(ssn);
    }
    public void setUsernameFieldLocator(String username) {
        driver.findElement(userNameFieldLocator).sendKeys(username);
    }
    public void setPasswordFieldLocator(String password) {
        driver.findElement(passwordFieldLocator).sendKeys(password);
    }
    public void setConfirmPasswordFieldLocator(String password) {
        driver.findElement(confirmPasswordFieldLocator).sendKeys(password);
    }
    public OverviewPage clickRegisterButtonLocator() {
        driver.findElement(registerButtonLocator).click();
        return new OverviewPage(driver);
    }
}
