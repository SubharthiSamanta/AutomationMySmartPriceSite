package Interview.PageClasses;

import Interview.BasePage.BasePage;
import Interview.DriverInitializer.DriverInitializerClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class LandingPage extends BasePage
{
    SoftAssert softAssert;

    public LandingPage()
    {
        softAssert = new SoftAssert();
        driver = DriverInitializerClass.getDriver();

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@aria-label='mysmartprice']/img")
    private WebElement mySmartPricePageLogo;

    @FindBy(xpath = "//*[@data-label='Mobiles']")
    private WebElement mobilesHeader;

    @FindBy(xpath = "//*[text()='Compare Mobiles']")
    private WebElement compareMobilesText;

    public void launchWebSite(String url)
    {
        driver.get(url);
    }


    public void verifyMySmartPriceLandingPage()
    {
        waitForElementToBeVisible(mySmartPricePageLogo);
        softAssert.assertTrue(mobilesHeader.isDisplayed(), "Mobiles section is not displayed");

        softAssert.assertAll();
    }

    public void checkCompareMobilesPresentOrNotInsideMobiles()
    {
        Actions act = new Actions(driver);

        act.moveToElement(mobilesHeader).perform();
        softAssert.assertTrue(compareMobilesText.isDisplayed(), "Compare mobiles text is not displayed");

        softAssert.assertAll();
    }

}
