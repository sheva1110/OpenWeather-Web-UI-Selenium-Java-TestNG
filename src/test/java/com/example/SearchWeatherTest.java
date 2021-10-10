package com.example;

import java.io.IOException;

import com.example.utils.BaseTest;
import com.example.utils.ExcelReader;
import static com.example.utils.PropertyLoader.returnConfigValue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchWeatherTest extends BaseTest{

private static final Logger LOGGER = LogManager.getLogger();


    @DataProvider(name ="Search-Weather-City")
    public Object[][] excelDP() throws IOException{
          //We are creating an object from the excel sheet data by calling a method that reads data from the excel stored locally in our system
          Object[][] arrObj = ExcelReader.getExcelData(returnConfigValue("data_file"), "City");
          return arrObj;
    }

    @Test(dataProvider ="Search-Weather-City")
    public void testSearchWeather(String city) throws InterruptedException{
        searchPage.searchWeatherByCity(city);
        searchPage.clickLinkResult();
        Thread.sleep(5000);
        searchResultPage.checkCurrentDate();
        searchResultPage.checkCity(city);
        searchResultPage.checkTemperature();
        LOGGER.info("Test Search Weather feature");
    }
}
