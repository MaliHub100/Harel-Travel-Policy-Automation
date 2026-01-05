package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        ChromeOptions options = new ChromeOptions();

        String isCI = System.getenv("CI");

        if ("true".equalsIgnoreCase(isCI)) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");
        }

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://digital.harel-group.co.il/travel-policy");
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);

            try {
                String folderPath = System.getProperty("user.dir") + "/target/screenshots/";
                File folder = new File(folderPath);
                if (!folder.exists()) {
                    folder.mkdirs();
                }
                String fileName = result.getName() + "_" + System.currentTimeMillis() + ".png";
                FileUtils.copyFile(source, new File(folderPath + fileName));

                System.out.println("Screenshot saved to: " + folderPath + fileName);
            } catch (IOException e) {
                System.err.println("Failed to save screenshot: " + e.getMessage());
            }
        }
        driver.quit();
    }
}