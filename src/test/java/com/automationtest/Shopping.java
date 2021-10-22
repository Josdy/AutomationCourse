package com.automationtest;

import com.Base;
import com.dataprovider.LoginDataProvider;
import com.pageobjects.*;

import com.utilities.ActionsMethod;
import com.utilities.WaitMethod;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Shopping extends Base {
    public LoginAccount loginAccount;
    private MainPage mainPage;
    private MyAccountPage myAccountPage;
    private ShoppingPage shoppingPage;
    private WaitMethod waitMethod;
    private ActionsMethod actionsMethod;
    private ProductDetailPage productDetailPage;
    private OrderPage orderPage;

    @BeforeTest
    public void initialize(){
        driver=initializeDriver();
        mainPage= new MainPage(driver);
        myAccountPage = new MyAccountPage(driver);
        shoppingPage = new ShoppingPage(driver);
        waitMethod= new WaitMethod(driver);
        actionsMethod = new ActionsMethod(driver);
        productDetailPage = new ProductDetailPage(driver);
        orderPage = new OrderPage(driver);
        driver.get(mainPage.getUrl());
    }

    @BeforeMethod
    public void login(){
        mainPage.clickSignin();
        actionsMethod.avPpag();
        waitMethod.waitTo(5);
        waitMethod.visibilityOf(myAccountPage.email);
        myAccountPage.setEmail(LoginDataProvider.USER_NAME);
        myAccountPage.setpaswd(LoginDataProvider.USER_PWD);
        myAccountPage.btnLogin();
    }

    @Test
    public void womanShop(){
        waitMethod.waitTo(5);
        waitMethod.visibilityOf(shoppingPage.menuWoman);
        AddCart(0);
        continueBtn();

        AddCart(1);
        continueBtn();
        AddCart(2);
        continueBtn();
        actionsMethod.initPage();
        waitMethod.waitTo(3);
        waitMethod.visibilityOf(productDetailPage.dropdownCart);
        productDetailPage.btnCart();
        checkoutCartBtn();
        waitMethod.waitTo(5);
        waitMethod.visibilityOf(orderPage.text);
        orderPage.verifyText();
        actionsMethod.avPpag();
        orderPage.verifyTotalProducts();
        orderPage.verifyTotalPriceProducts();
        actionsMethod.avPpag();
        checkoutBtn();
        actionsMethod.avPpag();
        doComment("Este es un comentario");
        actionsMethod.avPpag();
        btnProcessAddress();
        actionsMethod.avPpag();
        checkTermsC();
        btnProcessCarrier();
        actionsMethod.avPpag();
        payBy();
        actionsMethod.avPpag();
        confirmOrderP();
        waitMethod.waitTo(5);
        waitMethod.visibilityOf(orderPage.txtOrderSuccess);
        orderPage.verifyTextOrder();




    }

    public void AddCart(int Product){
        shoppingPage.womanMenu();
        actionsMethod.avPpag();
        actionsMethod.avPpag();
        shoppingPage.selectProduct(Product);
        shoppingPage.seeMore(Product);
        System.out.println("Producto:  " + productDetailPage.getTitle());
        System.out.println("Descripcion:\n  " + productDetailPage.getDescription());
        productDetailPage.setProductQuantity();
        actionsMethod.avPpag();
        productDetailPage.verifyProductImgs();
        productDetailPage.changeProductSize();
        productDetailPage.btnAddCart();


    }

    public void continueBtn(){
        waitMethod.waitTo(5);
        waitMethod.visibilityOf(productDetailPage.btnContinueShopping);
        productDetailPage.btnContinueShopping();
    }

    public void checkoutBtn(){
        waitMethod.waitTo(5);
        waitMethod.visibilityOf(orderPage.btnProceedCheckout);
        orderPage.btnProceedCheckout();
    }

    public void btnProcessAddress(){
        waitMethod.waitTo(5);
        waitMethod.visibilityOf(orderPage.btnProcessAddress);
        orderPage.btnProcessAdress();
    }
    public void btnProcessCarrier(){
        waitMethod.waitTo(5);
        waitMethod.visibilityOf(orderPage.btnProcessCarrier);
        orderPage.btnProcessCarrier();
    }

    public void checkoutCartBtn(){
        waitMethod.waitTo(5);
        waitMethod.visibilityOf(productDetailPage.btnCheckoutCart);
        productDetailPage.btnCheckoutCart();
    }
    public void doComment(String c){
        waitMethod.waitTo(5);
        waitMethod.visibilityOf(orderPage.comentario);
        orderPage.setComentario(c);
    }

    public void checkTermsC(){
        waitMethod.waitTo(5);
        waitMethod.visibilityOf(orderPage.terms);
        orderPage.checkTerms();
    }

    public void payBy(){
        waitMethod.waitTo(5);
        waitMethod.visibilityOf(orderPage.paybybankwire);
        orderPage.payByBankWire();
    }

    public void confirmOrderP(){
        waitMethod.waitTo(5);
        waitMethod.visibilityOf(orderPage.btnConfirmOrder);
        orderPage.confirmOrder();
    }

    @AfterTest
    public  void close(){
        driver.close();
    }

}


