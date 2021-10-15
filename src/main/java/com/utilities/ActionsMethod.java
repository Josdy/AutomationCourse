package com.utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class ActionsMethod {
    public Actions act;

    public ActionsMethod(WebDriver driver) {
        act= new Actions(driver);
    }

    public void avPpag(){
        act.sendKeys(Keys.PAGE_DOWN).perform();
    }

    public void initPage(){
        act.sendKeys(Keys.HOME).perform();
    }

    public void mouseOver(WebElement element){
        act.moveToElement(element).build().perform();
    }
}
