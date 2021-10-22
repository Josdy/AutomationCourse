
package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private final WebDriver driver;
    public final String url= "http://automationpractice.com";

    @FindBy(xpath = "//div//a[@class='login']")
    private WebElement btnLogin;



    public MainPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public String getUrl(){
        return url;
    }

    public void clickSignin(){
        btnLogin.click();
    }
}


