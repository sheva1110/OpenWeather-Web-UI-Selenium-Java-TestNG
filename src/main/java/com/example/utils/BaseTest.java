package com.example.utils;

import java.io.IOException;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import com.example.driver.DriverFactory;
import com.example.page.SearchPage;
import com.example.page.SearchResultPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import ru.stqa.selenium.factory.WebDriverPool;
import com.example.report.ReportListener;
import java.net.URL;
import org.openqa.selenium.Capabilities;
import com.example.config.SuiteConfiguration;
import static com.example.utils.PropertyLoader.returnConfigValue;

import java.util.concurrent.TimeUnit;


@Listeners({ExtentITestListenerClassAdapter.class, ReportListener.class})
public abstract class BaseTest {

    protected static WebDriver driver;
    protected static URL gridHubUrl = null;
    protected static String baseUrl;
    protected static Capabilities capabilities;
    protected SearchPage searchPage;
    protected SearchResultPage searchResultPage;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeSuite
    public void initTestSuite() throws IOException {
        SuiteConfiguration config = new SuiteConfiguration();
      baseUrl = config.getProperty("site.url");
      if (config.hasProperty("grid.url") && !"".equals(config.getProperty("grid.url"))) {
        gridHubUrl = new URL(config.getProperty("grid.url"));
      }
      capabilities = config.getCapabilities();
    }

    // @BeforeMethod
    // public void preCondition() {
    //     driver = new DriverFactory().createInstance();
    //     driver.manage().window().maximize();
    //     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    //     driver.get(returnConfigValue("url"));       
    //     searchPage = new SearchPage(driver);
    //     searchResultPage = new SearchResultPage(driver);
    // }

    @AfterMethod
    public void postCondition(){
        driver.quit();
    }

    @BeforeMethod
    public void initWebDriver() {
      driver = WebDriverPool.DEFAULT.getDriver(gridHubUrl, capabilities);
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.get(baseUrl);       
      searchPage = new SearchPage(driver);
      searchResultPage = new SearchResultPage(driver);
    }
  
    @AfterSuite(alwaysRun = true)
    public void tearDown() {
      WebDriverPool.DEFAULT.dismissAll();
    }
}
