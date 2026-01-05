package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TravelersPage extends BasePage{

    @FindBy(css="h2[data-hrl-bo='screen_title']")
    private WebElement travelersPageHeader;

    public TravelersPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }


    public boolean isTravelersPageOpen() {
        return wait.until(ExpectedConditions.visibilityOf(travelersPageHeader)).isDisplayed();
    }
}
