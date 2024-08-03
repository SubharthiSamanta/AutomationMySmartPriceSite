package Interview.BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage
{
    protected WebDriver driver;

    public void waitForElementToBeVisible(WebElement element)
    {
        WebDriverWait myWait = new WebDriverWait(driver, Duration.ofMillis(15000));
        myWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void wait(int miliis)
    {
        try
        {
            Thread.sleep(miliis);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
