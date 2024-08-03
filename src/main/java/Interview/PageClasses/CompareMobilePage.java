package Interview.PageClasses;

import Interview.BasePage.BasePage;
import Interview.DriverInitializer.DriverInitializerClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class CompareMobilePage extends BasePage
{

    SoftAssert softAssert;

    public CompareMobilePage()
    {
        softAssert = new SoftAssert();
        driver = DriverInitializerClass.getDriver();

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[text()='Compare Mobiles']")
    private WebElement compareMobilesText;

    @FindBy(xpath = "//h1[contains(text(), 'Compare Mobile')]")
    private WebElement compareMobilePageHeading;

    @FindBy(xpath = "//*[@class='hdr-logo']/img")
    private WebElement mySmartPricePageLogoInComparePage;

    @FindBy(xpath = "//*[@id ='searchField_0_top']")
    private WebElement mobileNameSearchbar1;

    @FindBy(xpath = "//*[@id ='searchField_1_top']")
    private WebElement mobileNameSearchbar2;

    @FindBy(xpath = "//*[@id ='searchField_2_top']")
    private WebElement mobileNameSearchbar3;

    @FindBy(xpath = "//*[@id ='searchField_3_top']")
    private WebElement mobileNameSearchbar4;

    @FindBy(xpath = "//li[@class='ui-menu-item']")
    private List <WebElement> listOfMobilesSearched;

    @FindBy(xpath = "//*[text()='Add to Compare']")
    private List <WebElement> addToCompareButtons;

    @FindBy(xpath = "//*[@class=\"block device_block mobile-box selected \"]//span")
    private List <WebElement> mobileSpecsTab;

    @FindBy(xpath = "//span[contains(text(), 'RAM')]/parent::*")
    private List <WebElement> performanceTab;

    public void clickOnCompareMobile()
    {
        compareMobilesText.click();
    }

    public void verifyCompareMobilePage()
    {
        waitForElementToBeVisible(compareMobilePageHeading);

        softAssert.assertTrue(mySmartPricePageLogoInComparePage.isDisplayed(), "My Smart price logo is not displayed");
    }

    public void addMobiles(ArrayList<String> mobileName)
    {
        mobileNameSearchbar1.sendKeys(mobileName.get(0));
        listOfMobilesSearched.get(0).click();
        wait(3000);

        mobileNameSearchbar1.sendKeys(mobileName.get(1));
        listOfMobilesSearched.get(0).click();
        wait(3000);

        mobileNameSearchbar1.sendKeys(mobileName.get(2));
        listOfMobilesSearched.get(0).click();
        wait(3000);

        mobileNameSearchbar1.sendKeys(mobileName.get(3));
        listOfMobilesSearched.get(0).click();
        wait(3000);
    }

    public ArrayList<Integer> getMobileDetails(int columnNo)
    {
        waitForElementToBeVisible(mobileSpecsTab.get(0));
        ArrayList<Integer> mobileInfo = new ArrayList<>();

        int mspValue = 0;

        String priceOfMobileText = ((mobileSpecsTab.get(columnNo).findElement(By.xpath("//span")).getText().split(" "))[1]).replaceAll(",", "");
        int priceOfMobile = Integer.parseInt(priceOfMobileText);

        mobileInfo.add(priceOfMobile);

        try
        {
            if (performanceTab.get(columnNo).findElement(By.xpath("//div[@class='prdct__rtng-scr-val']")).isDisplayed())
            {
                String performanceMSP = performanceTab.get(columnNo).findElement(By.xpath("//div[@class='prdct__rtng-scr-val']")).getText();
                mspValue = Integer.parseInt(performanceMSP);
            }
        }
        catch (Exception e)
        {
            System.out.println("Performance msp is not found");
            mspValue = 0;
        }

        mobileInfo.add(mspValue);

        return mobileInfo;

    }
}
