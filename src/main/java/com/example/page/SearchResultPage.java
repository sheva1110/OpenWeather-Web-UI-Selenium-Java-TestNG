package com.example.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;

public class SearchResultPage extends BasePage {

    public SearchResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    //------Locator------

    @FindBy(xpath = "//*[@id='weather-widget']//span[@class='orange-text']")
    private WebElement dateTimeLabel;

    @FindBy(xpath = "//*[@id='weather-widget']//h2")
    private WebElement cityField;

    @FindBy(xpath = "//span[@class='heading']")
    private WebElement temperatureField;

    //------Page methods------

    public void checkCurrentDate(){
        DateFormat dateFormat = new SimpleDateFormat("MMM dd");
        Date expectedCurrentDate = new Date();
        String strDate = dateFormat.format(expectedCurrentDate);
        String currentDate = dateTimeLabel.getText();
        Assert.assertTrue(currentDate.contains(strDate), "Current Date is not displayed on Search Result page");
    }

    public void checkCity(String city){
        String currentCity = cityField.getText();
        Assert.assertTrue(currentCity.contains(city), "City is not displayed on Search Result page");
    }

    public void checkTemperature(){
        String currentTemp = temperatureField.getText();
        Assert.assertTrue(currentTemp.contains("°C"), "Temperature is not displayed on Search Result page");
    }
}
