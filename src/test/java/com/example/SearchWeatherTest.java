package com.example;

import com.example.utils.BaseTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class SearchWeatherTest extends BaseTest{

private static final Logger LOGGER = LogManager.getLogger();

    @Test
    public void testSearchWeather() throws InterruptedException{
        searchPage.searchWeatherByCity("Ha Noi");
        searchPage.clickLinkResult();
        Thread.sleep(5000);
        searchResultPage.checkCurrentDate();
        searchResultPage.checkCity("Ha Noi");
        searchResultPage.checkTemperature();
        LOGGER.info("Test Search Weather feature");
    }
}
