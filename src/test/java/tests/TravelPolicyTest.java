package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TravelDatesPage;
import pages.TravelPolicyPage;
import pages.TravelersPage;

public class TravelPolicyTest extends BaseTest {

    @Test(description = "Purchase insurance, select dates, view the summary of the days, and check that the travelers page has opened.")
    public void testVerifyTotalDaysDisplayedCorrectly() {
        TravelPolicyPage travelPolicyPage = new TravelPolicyPage(driver);
        TravelDatesPage travelDatesPage = new TravelDatesPage(driver);
        TravelersPage travelersPage = new TravelersPage(driver);

        travelPolicyPage.startPurchaseFlow();
        travelPolicyPage.chooseEuropeDestination();
        travelPolicyPage.proceedToDates();
        travelDatesPage.fillTravelDates(7, 30);
        String actualDays = travelDatesPage.getTotalDaysText();
        Assert.assertTrue(actualDays.contains("31"),
                "error : the total days is not 31 as expected" + actualDays);
        travelDatesPage.proceedToTravelersDetails();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("travelers"),
                "error :  the travelers page not open as expected");
        Assert.assertTrue(travelersPage.isTravelersPageOpen(),
                "error : the travelers page not open correctly");
    }
}