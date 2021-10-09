package com.example.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected static final Logger LOGGER = LogManager.getLogger();

    public BasePage (WebDriver webDriver){
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 15);
    }
}
