package com.fjolur;

import com.fjolur.core.WebDriverTestBase;
import com.fjolur.pages.GoogleResultPage;
import com.fjolur.pages.GoogleSearchPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class GoogleSearchTest extends WebDriverTestBase {


    @Test
    public void searchTest() {
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.openURL("https://www.google.com.ua/");
        googleSearchPage.sendSearchData("q","Selenium");
        GoogleResultPage googleResultPage = new GoogleResultPage(driver);
        assertEquals(googleResultPage.findLink(".//*[@id='rso']/div/div/div[1]/div/h3/a").getText().contains("Selenium"), true);
    }

    @Test
    public void currencyConvert(){
        GoogleSearchPage currencyConvert = new GoogleSearchPage(driver);
        currencyConvert.openURL("http://finance.liga.net/rates/converter/");
        currencyConvert.sendSearchData("selectSum", "200");
        //GoogleResultPage googleResultPage = new GoogleResultPage(driver);
        assertEquals(currencyConvert.findForElement("result").getText().contains("7,37"),true);
    }
}