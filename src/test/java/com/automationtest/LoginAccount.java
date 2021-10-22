package com.automationtest;

import com.Base;
import com.dataprovider.CreateAccountDataProvider;
import com.dataprovider.LoginDataProvider;
import com.pageobjects.CreateAccountPage;
import com.pageobjects.MainPage;
import com.pageobjects.MyAccountPage;
import com.utilities.ActionsMethod;
import com.utilities.WaitMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginAccount extends Base {
    private MainPage mainPage;
    private MyAccountPage myAccountPage;
    private WaitMethod waitMethod;
    private ActionsMethod actionsMethod;

    @BeforeTest
    public void initialize(){
        driver=initializeDriver();
        mainPage= new MainPage(driver);
        myAccountPage = new MyAccountPage(driver);
        waitMethod= new WaitMethod(driver);
        actionsMethod = new ActionsMethod(driver);
        driver.get(mainPage.getUrl());

    }

    @Test()
    public void testLoginPage(){
        mainPage.clickSignin();
        actionsMethod.avPpag();

        waitMethod.waitTo(5);
        waitMethod.visibilityOf(myAccountPage.email);
        myAccountPage.setEmail(LoginDataProvider.USER_NAME);
        myAccountPage.setpaswd(LoginDataProvider.USER_PWD);
        myAccountPage.btnLogin();
    }

    @AfterTest
    public void close(){
        driver.quit();
    }
}


