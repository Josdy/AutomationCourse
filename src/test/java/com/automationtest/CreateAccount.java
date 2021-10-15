package com.automationtest;
import com.Base;


import com.dataprovider.CreateAccountDataProvider;
import com.dataprovider.LoginDataProvider;
import com.pageobjects.*;
import com.utilities.ActionsMethod;
import com.utilities.WaitMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class CreateAccount extends Base{
    private MainPage mainPage;
    private MyAccountPage myAccountPage;
    private CreateAccountPage createAccountPage;
    private WaitMethod waitMethod;
    private ActionsMethod actionsMethod;

    @BeforeTest
    public void initialize(){
        driver=initializeDriver();
        mainPage= new MainPage(driver);
        myAccountPage = new MyAccountPage(driver);
        createAccountPage = new CreateAccountPage(driver);
        waitMethod= new WaitMethod(driver);
        actionsMethod = new ActionsMethod(driver);
        driver.get(mainPage.getUrl());

    }


    //@Test(dataProvider = "just email data",dataProviderClass = CreateAccountDataProvider.class)
    @Test(dataProvider = "form data", dataProviderClass = CreateAccountDataProvider.class)
    //public void testFirstStepToCreateAccount(String emailToCreate) throws  InterruptedException{
    public void testFirstStepToCreateAccount(String emailToCreate,String fname, String lname,
                                             String psdw, String company,
                                             String address, String city,
                                             String pcode, String homeph,
                                             String mobileph, String alias){
        mainPage.clickSignin();
        actionsMethod.avPpag();
        myAccountPage.enterEmailToCreate(emailToCreate);
        myAccountPage.btnCreateAccount();

        waitMethod.waitTo(5);
        waitMethod.visibilityOf(createAccountPage.radioBtnFemale);
        createAccountPage.radioBtnFemale();
        actionsMethod.avPpag();
        createAccountPage.setcFirstName(fname);
        createAccountPage.setcLastName(lname);
        createAccountPage.setpswd(psdw);
        createAccountPage.selectDate();
        actionsMethod.avPpag();
        createAccountPage.setCompany(company);
        createAccountPage.setAddress(address);
        createAccountPage.setCity(city);
        createAccountPage.selectState();
        createAccountPage.setPoscode(pcode);
        createAccountPage.selectCountry();
        actionsMethod.avPpag();
        createAccountPage.setPhone(homeph);
        createAccountPage.setPhoneMobile(mobileph);
        createAccountPage.setAlias(alias);
        createAccountPage.setBtnSubmitAccount();






    }

    @AfterTest
    public void closePage(){
        driver.quit();
    }

}
