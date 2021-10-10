package com.example.utils;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import com.example.driver.DriverFactory;
import com.example.page.SearchPage;
import com.example.page.SearchResultPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import com.example.report.ReportListener;

import static com.example.utils.PropertyLoader.returnConfigValue;

import java.util.concurrent.TimeUnit;


@Listeners({ExtentITestListenerClassAdapter.class, ReportListener.class})
public abstract class BaseTest {

    protected static WebDriver driver;
    protected SearchPage searchPage;
    protected SearchResultPage searchResultPage;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void preCondition() {
        driver = new DriverFactory().createInstance();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(returnConfigValue("url"));       
        searchPage = new SearchPage(driver);
        searchResultPage = new SearchResultPage(driver);
    }

    @AfterMethod
    public void postCondition(){
        driver.quit();
    }
}
