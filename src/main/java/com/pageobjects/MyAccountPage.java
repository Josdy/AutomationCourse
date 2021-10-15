package com.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage {
    private final WebDriver driver;



    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);


    }

    @FindBy(name = "email_create")
    private WebElement emailToCreate;

    @FindBy(id = "SubmitCreate")
    private WebElement btnCreateAccount;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "passwd")
    public WebElement passwd;

    @FindBy(id = "SubmitLogin")
    private WebElement btnLogin;

    public void setEmail(String emailRegistered) {
        email.clear();
        email.sendKeys(emailRegistered);

    }
    public void setpaswd(String pswdRegistered) {
        passwd.clear();
        passwd.sendKeys(pswdRegistered);

    }
    public void enterEmailToCreate(String email){
        emailToCreate.clear();
        emailToCreate.sendKeys(email);
    }

    public void btnCreateAccount(){
        btnCreateAccount.click();
    }

    public void btnLogin(){
        btnLogin.click();
    }




}
