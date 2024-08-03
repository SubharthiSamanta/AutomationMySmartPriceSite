package Interview.DriverInitializer;

import org.openqa.selenium.WebDriver;

public class DriverInitializerClass
{
    public static WebDriver driver;

    public static void setDriver(WebDriver driver)
    {
        DriverInitializerClass.driver = driver;
    }

    public static WebDriver getDriver()
    {
        return driver;
    }
}
