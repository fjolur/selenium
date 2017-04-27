package com.fjolur.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AbstractPage {

    protected WebDriver driver;


    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }
    private JavascriptExecutor executor;

    public WebElement findForElement(String locator){
        WebElement findElement = driver.findElement(By.name(locator));
        return findElement;
    }


    public void sendSearchData(String name, String search) {
        WebElement searchField = driver.findElement(By.name(name));
        searchField.clear();
        searchField.sendKeys(search);
        searchField.submit();
    }

    public void click(By byLocator){driver.findElement(byLocator).click();}

    public void openURL(String url){
        driver.get(url);
    }

    public void jsClick(WebElement element){
        executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
    public void clickButton(){

    }
}