package Interview.TestClasses;

import Interview.PageClasses.CompareMobilePage;
import Interview.PageClasses.LandingPage;
import Interview.PropertiesClass;
import Interview.TestBase.TestBase;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CompareMobilesTest extends TestBase
{

    ArrayList<String> mobileNames = new ArrayList<>();
    LandingPage myLandingPage;
    CompareMobilePage myComparePage;
    @Test
    public void addFourMobilesAndCompare()
    {
        myLandingPage = new LandingPage();
        myComparePage = new CompareMobilePage();

        myLandingPage.launchWebSite(PropertiesClass.url);
        myLandingPage.verifyMySmartPriceLandingPage();
        myLandingPage.checkCompareMobilesPresentOrNotInsideMobiles();

        myComparePage.clickOnCompareMobile();
        myComparePage.verifyCompareMobilePage();
        mobileNames.add(PropertiesClass.mobile1);
        mobileNames.add(PropertiesClass.mobile2);
        mobileNames.add(PropertiesClass.mobile4);
        mobileNames.add(PropertiesClass.mobile3);

        myComparePage.addMobiles(mobileNames);

    }
}
