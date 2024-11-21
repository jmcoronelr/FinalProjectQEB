import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TransactionsTests extends BaseTest{
    private Integer firstAccountNumber, secondAccountNumber;
    private Integer inputAmount = 1;
    @BeforeEach
    public void PreConditions() throws InterruptedException {
        OverviewPage overviewPage = new OverviewPage(driver);
        if(overviewPage.getAccountsOverviewCount() == 2){
            OpenAccountPage openAccountPage = overviewPage.openNewAccount();
            openAccountPage.clickOpenAccountButton();
            overviewPage = openAccountPage.getOverviewPage();
        }
        List<Integer> accounts = overviewPage.getAccountNumbersWithPositiveBalance();
        firstAccountNumber = accounts.get(0);
        secondAccountNumber = accounts.get(1);
        TransferFundsPage transferFundsPage = overviewPage.transferFunds();
        this.driver = transferFundsPage.getDriver();
    }
    @Test
    public void successfulTransactionShowsConfirmationMessageWithinFiveSecondsWithValidAmountField() throws InterruptedException {
        TransferFundsPage transferFundsPage = new TransferFundsPage(driver);
        transferFundsPage.enterAmount(inputAmount.toString());
        transferFundsPage.enterSourceAccount(firstAccountNumber.toString());
        transferFundsPage.enterDestinationAccount(secondAccountNumber.toString());
        long time1 = System.currentTimeMillis();
        transferFundsPage.clickTransferButton();
        assertEquals(inputAmount.toString(), transferFundsPage.getResultAmount());
        assertEquals(firstAccountNumber.toString(), transferFundsPage.getSourceAccountResult());
        assertEquals(secondAccountNumber.toString(), transferFundsPage.getDestinationAccountResult());
        long time2 = System.currentTimeMillis();
        assertTrue((time2 - time1) < 5000);
    }
}
