import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TransactionsTests extends BaseTest {
    private String firstAccountNumber, secondAccountNumber;
    private Integer inputAmount = (Integer) 1;
    private List<String> availableAccountNumbers;

    @BeforeEach
    public void PreConditions() throws InterruptedException {
        OverviewPage overviewPage = new OverviewPage(driver);
        if (overviewPage.getAccountsOverviewCount() == 1) {
            OpenAccountPage openAccountPage = overviewPage.openNewAccount();
            openAccountPage.clickOpenAccountButton();
            overviewPage = openAccountPage.getOverviewPage();
        }
        availableAccountNumbers = overviewPage.getAccountNumbersWithPositiveBalance();
        firstAccountNumber = availableAccountNumbers.get(0);
        secondAccountNumber = availableAccountNumbers.get(1);
        TransferFundsPage transferFundsPage = overviewPage.transferFunds();
        this.driver = transferFundsPage.getDriver();
    }

    @Test
    public void successfulTransactionShowsConfirmationMessageWithinFiveSecondsWithValidAmountField() throws InterruptedException {
        TransferFundsPage transferFundsPage = new TransferFundsPage(driver);
        transferFundsPage.enterAmount(inputAmount.toString());
        transferFundsPage.enterSourceAccount(firstAccountNumber);
        transferFundsPage.enterDestinationAccount(secondAccountNumber);
        long time1 = System.currentTimeMillis();
        transferFundsPage.clickTransferButton();
        assertEquals(inputAmount.toString(), transferFundsPage.getResultAmount());
        assertEquals(firstAccountNumber, transferFundsPage.getSourceAccountResult());
        assertEquals(secondAccountNumber, transferFundsPage.getDestinationAccountResult());
        long time2 = System.currentTimeMillis();
        assertTrue((time2 - time1) < 5000);
    }

    @Test
    public void allAccountsAvailableInSourceAndDestinationDropdownMenus() {
        TransferFundsPage transferFundsPage = new TransferFundsPage(driver);
        List<String> sourceDropdownMenuAccounts = transferFundsPage.getAccountNumbersfromSourceDropdownMenu();
        List<String> destinationDropdownMenuAccounts = transferFundsPage.getAccountNumbersfromDestinationDropdownMenu();
        assertEquals(availableAccountNumbers, sourceDropdownMenuAccounts);
        assertEquals(availableAccountNumbers, destinationDropdownMenuAccounts);
    }
}
