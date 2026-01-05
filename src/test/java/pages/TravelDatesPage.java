package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDate;

public class TravelDatesPage extends BasePage{

    @FindBy(css = "span[data-hrl-bo='total-days']")
    private WebElement totalDaysLabel;

    @FindBy(css = "button[data-hrl-bo='wizard-next-button']")
    private WebElement nextStepBtn;

    @FindBy(xpath = "//button[@data-hrl-bo='arrow-forward' and .//*[local-name()='svg']]")
    private WebElement nextMonthBtn;
    public TravelDatesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getTotalDaysText() {
        moveToElement(totalDaysLabel);
        return getText(totalDaysLabel);
    }

    public void fillTravelDates(int startInDays, int duration) {
        LocalDate startDate = LocalDate.now().plusDays(startInDays);
        LocalDate endDate = startDate.plusDays(duration);

        selectSpecificDate(startDate);
        selectSpecificDate(endDate);
    }

    private void selectSpecificDate(LocalDate targetDate) {
        String dateValue = targetDate.toString();
        // attribute of date btn @data-hrl-bo contains the date format : 2026-01-05
        String dateXpath = String.format("//button[@data-hrl-bo='%s']", dateValue);

        try {
            WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dateXpath)));
            dateElement.click();
        } catch (TimeoutException | NoSuchElementException e) {
            // if the date not found, move to the next month and try again
            clickNextMonth();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dateXpath))).click();
        }
    }

    private void clickNextMonth() {
        click(nextMonthBtn);
    }
    public void proceedToTravelersDetails() {
        click(nextStepBtn);
    }
}
