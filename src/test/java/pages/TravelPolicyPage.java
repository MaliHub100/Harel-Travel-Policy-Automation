package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.LocalDate;

public class TravelPolicyPage extends BasePage {

    @FindBy(css = "button[data-hrl-bo='purchase-for-new-customer']")
    private WebElement firstTimePurchaseBtn;

    @FindBy(xpath = "//div[contains(text(), 'אירופה')]")
    private WebElement europeContinent;

    @FindBy(css = "button[data-hrl-bo='wizard-next-button']")
    private WebElement nextStepBtn;

    @FindBy(css = "h1, .page-title") // אלמנט לווידוא שהדף הבא נפתח
    private WebElement passengersPageHeader;

    public TravelPolicyPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void startPurchaseFlow() {
        click(firstTimePurchaseBtn);
    }
    public void chooseEuropeDestination() {
        click(europeContinent);
    }
    public void proceedToDates() {
        click(nextStepBtn);
    }

}