package com.pageobjects;

import com.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountPage extends Base {
    private final WebDriver driver;
    private WebDriverWait wait;


    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(id = "id_gender2")
    public WebElement radioBtnFemale;

    @FindBy(id = "customer_firstname")
    public WebElement cFirstName;

    @FindBy(id = "customer_lastname")
    private WebElement cLastName;

    @FindBy(id = "passwd")
    private WebElement passwd;

    @FindBy(id = "company")
    private  WebElement companyC;

    @FindBy(id = "address1")
    private  WebElement address;

    @FindBy(id = "city")
    private  WebElement city;

    @FindBy(id = "postcode")
    private  WebElement postcode;

    @FindBy(id = "phone")
    private  WebElement phone;

    @FindBy(id = "phone_mobile")
    private  WebElement phoneMobile;

    @FindBy(id = "alias")
    private  WebElement alias;

    @FindBy(id = "submitAccount")
    private  WebElement btnSubmitAccount;

    @FindBy(id = "days")
    private  WebElement selectDay;

    @FindBy(id = "months")
    private  WebElement selectMonths;

    @FindBy(id = "years")
    private  WebElement selectYears;

    @FindBy(id = "id_state")
    private  WebElement selectState;

    @FindBy(id = "id_country")
    private  WebElement selectCountry;


    public void radioBtnFemale(){
        radioBtnFemale.click();
    }
    public void setcFirstName(String firstName) {
        cFirstName.clear();
        cFirstName.sendKeys(firstName);
    }

    public void setcLastName(String lastName) {
        cLastName.clear();
        cLastName.sendKeys(lastName);
    }

    public void setpswd(String pswd){
        passwd.clear();
        passwd.sendKeys(pswd);
    }

    public void selectDate(){
        Select day = new Select(selectDay);
        day.selectByIndex(18);
        Select months = new Select(selectMonths);
        months.selectByIndex(6);
        Select years = new Select(selectYears);
        years.selectByValue("1996");
    }

    public void setCompany(String company){
        companyC.clear();
        companyC.sendKeys(company);
    }

    public void setAddress(String address1){
        address.clear();
        address.sendKeys(address1);
    }

    public void setCity(String cityC){
        city.clear();
        city.sendKeys(cityC);
    }

    public void selectState(){
        Select state = new Select(selectState);
        state.selectByIndex(2);

    }

    public void setPoscode(String poscodeC){
        postcode.clear();
        postcode.sendKeys(poscodeC);
    }

    public void selectCountry(){
        Select country = new Select(selectCountry);
        country.selectByIndex(1);

    }

    public void setPhone(String phoneH){
        phone.clear();
        phone.sendKeys(phoneH);
    }

    public void setPhoneMobile(String phoneM){
        phoneMobile.clear();
        phoneMobile.sendKeys(phoneM);
    }

    public void setAlias(String aliasA){
        alias.clear();
        alias.sendKeys(aliasA);
    }

    public void setBtnSubmitAccount(){
        btnSubmitAccount.click();
    }



}
