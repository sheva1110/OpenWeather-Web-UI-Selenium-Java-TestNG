package com.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.FindBy;


public class SearchPage extends BasePage{

    public SearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//input[@placeholder='Search city']")
    private WebElement searchTextBox;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//ul[@class='search-dropdown-menu']//li")
    private WebElement linkResult;

    private By loadingCircle = By.xpath("//*[name()='circle' and contains(@cx,'105')]");

    //------Page methods------

    public void searchWeatherByCity(String city){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingCircle));
        searchTextBox.sendKeys(city);
        searchButton.click();
    }

    public void clickLinkResult(){
        linkResult.click();
    }  
}
