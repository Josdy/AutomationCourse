package com.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitMethod {
    public WebDriverWait wait;
    public WebDriver driver;

    public WaitMethod(WebDriver driver) {
        this.driver = driver;
    }

    public void waitTo(int time){
        wait = new WebDriverWait(driver, time);
    }

    public void visibilityOf(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void textToBePresent(WebElement element, String txt){
        wait.until(ExpectedConditions.textToBePresentInElement(element, txt ));
    }


}
