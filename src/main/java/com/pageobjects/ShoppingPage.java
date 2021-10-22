package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShoppingPage {
    private final WebDriver driver;



    public ShoppingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='sf-with-ul']")
    public WebElement menuWoman;

    @FindBy(xpath = "//div[@class=\"product-container\"]")
    public List<WebElement> products;

    @FindBy(xpath = "//span[contains(.,'More')]")
    public List<WebElement> productDetailBtn;


    public void womanMenu(){
        menuWoman.click();
    }

    public void selectProduct(int i){
        products.get(i).click();
    }

    public void seeMore(int i){
        productDetailBtn.get(i).click();
    }

}


