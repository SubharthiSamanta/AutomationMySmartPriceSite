package Interview.TestBase;

import Interview.DriverInitializer.DriverInitializerClass;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.time.Duration;

public class TestBase
{
    protected WebDriver driver;

    //public static ExtentTest logger;

    @BeforeClass
    public void LaunchDriver()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20000));

        DriverInitializerClass.setDriver(driver);
    }

    @BeforeMethod
    public void initializeLogger(Method methodName)
    {

    }

    @AfterClass
    public void closeDriver()
    {
        if (driver != null)
        {
            driver.quit();
        }
    }


}
