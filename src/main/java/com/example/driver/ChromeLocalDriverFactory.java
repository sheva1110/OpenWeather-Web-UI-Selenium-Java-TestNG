package com.example.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeLocalDriverFactory{

    private ChromeOptions chromeOptions;

    public ChromeLocalDriverFactory(ChromeOptions chromeOptions) {
        this.chromeOptions = chromeOptions;
    }

    public WebDriver driver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(chromeOptions);
    }

    
}
