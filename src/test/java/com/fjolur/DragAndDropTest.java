package com.fjolur;

import com.fjolur.core.WebDriverTestBase;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


@Listeners({com.fjolur.core.TestListener.class})

public class DragAndDropTest extends WebDriverTestBase {

    @Test
    public void dragAndDropTest() throws InterruptedException {
        driver.get("http://www.dhtmlx.com/docs/products/dhtmlxTree/index.shtml");
        driver.wait(300);
        WebElement From = driver.findElement(By.xpath(".//*[@id='treebox1']/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[4]/span"));
        WebElement To = driver.findElement(By.xpath(".//*[@id='treebox2']/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[4]/span"));
        Actions builder = new Actions(driver);
        Action dragAndDrop = builder.clickAndHold(From).moveToElement(To).release(To).build();
        dragAndDrop.perform();
    }
}
