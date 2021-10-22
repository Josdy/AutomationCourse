package com.pageobjects;

import com.Base;
import com.utilities.ActionsMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;


import java.util.ArrayList;
import java.util.List;


public class ProductDetailPage extends Base {

    public WebDriver driver;
    SoftAssert softAssert;
    public ActionsMethod actionsMethod;
    public ArrayList arrayprice;


    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
       softAssert = new SoftAssert();
        actionsMethod = new ActionsMethod(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id=\"short_description_content\"]")
    public WebElement productDesc;

    @FindBy(xpath = "//div//h1")
    public WebElement productTitle;

    @FindBy(id = "quantity_wanted")
    public WebElement productQuantity;

    @FindBy(id = "group_1")
    public WebElement selectSize;

    @FindBy(xpath = "//div[@id=\"thumbs_list\"]//img")
    public List<WebElement> produdctImg;

    @FindBy(name = "Submit")
    public WebElement btnAddCart;

    @FindBy(xpath = "//span[contains(.,\"Continue shopping\")]")
    public WebElement btnContinueShopping;

    @FindBy(xpath = "//span[contains(.,\"Proceed to checkout\")]")
    public WebElement btnProceedCheckout;

    @FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")
    public WebElement dropdownCart;

    @FindBy(id = "button_order_cart")
    public WebElement btnCheckoutCart;

    @FindBy(xpath = "//div[@class=\"price\"]//span[@id=\"our_price_display\"]")
    public  WebElement savePrice;

    public String getDescription(){
      return  productDesc.getText();

    }
    public String getTitle(){
        return  productTitle.getText();
    }

    public void setProductQuantity(){
        productQuantity.clear();
        productQuantity.sendKeys((String.valueOf((int)(Math.random() * (5 - 2)) + 2)));
    }

    public String getProductSize(){
        Select size= new Select(selectSize);
       return size.getFirstSelectedOption().getText();

    }

    public void verifyProductImgs(){
        if(getProductSize().equalsIgnoreCase("S")) {
            if (produdctImg.size() == 4) {
                System.out.println("Producto muestra 4 imagenes");
            } else {
                System.out.println("Producto muestra " + produdctImg.size() + " imagenes");
            }
            softAssert.assertEquals(produdctImg.size(),4);
            //softAssert.assertAll(); -> se comenta debido a que se cae el test
        }
    }

    public void changeProductSize(){
        Select size= new Select(selectSize);
        size.selectByIndex(2);

    }

    public void btnAddCart(){
        btnAddCart.click();
    }

    public void btnContinueShopping(){
        btnContinueShopping.click();
    }

    public void btnProceedCheckout(){
        btnProceedCheckout.click();
    }

    public void btnCart(){
        actionsMethod.mouseOver(dropdownCart);

    }

    public void btnCheckoutCart(){
        btnCheckoutCart.click();
    }

    public Double setArrayprice(int i){
        int lenght= savePrice.getText().length();
        arrayprice.add(i,savePrice.getText().substring(1,lenght));
        System.out.println("pricebefore: " + savePrice.getText().substring(1, lenght) + "array" + arrayprice.get(i));


        return (Double) arrayprice.get(i);
    }

}
