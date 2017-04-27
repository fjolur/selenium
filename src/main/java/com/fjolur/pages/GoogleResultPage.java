package com.fjolur.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleResultPage extends AbstractPage{

    public GoogleResultPage(WebDriver driver) {
        super(driver);
    }

    public WebElement findLink(String locator){
        WebElement seleniumLink = driver.findElement(By.xpath(locator));
        return seleniumLink;
    }
}