import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseTest {
    WebDriver driver;
    String registerUrl = "https://parabank.parasoft.com/parabank/register.htm";

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(registerUrl);
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.setUserNameLocator("test");
        registerPage.setPasswordLocator("test");
        OverviewPage overviewPage = registerPage.clickLoginButton(); // Try lo log in
        if (driver.getCurrentUrl().contains("login")) { // Redirection to login means  unsuccessful login
            driver.get(registerUrl);
            registerPage = new RegisterPage(driver); // Register new test user
            registerPage.setFirstNameFieldLocator("test");
            registerPage.setLastNameFieldLocator("test");
            registerPage.setAddressFieldLocator("test");
            registerPage.setCityFieldLocator("test");
            registerPage.setStateFieldLocator("test");
            registerPage.setZipFieldLocator("test");
            registerPage.setPhoneFieldLocator("11111");
            registerPage.setSsnFieldLocator("1111");
            registerPage.setUsernameFieldLocator("test");
            registerPage.setPasswordFieldLocator("test");
            registerPage.setConfirmPasswordFieldLocator("test");
            overviewPage = registerPage.clickRegisterButtonLocator();
            overviewPage = overviewPage.showOverviewPage();
        }
        this.driver = overviewPage.getDriver(); // Save the web instance
    }

    @AfterEach
    // End the web instance
    public void tearDown() {
        driver.quit();
    }
}
