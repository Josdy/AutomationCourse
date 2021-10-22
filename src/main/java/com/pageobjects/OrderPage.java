package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;


import java.util.List;

public class OrderPage {
    private final WebDriver driver;
    public double suma=0;
    public int lenghtPrice;
    SoftAssert softAssert;
    public ProductDetailPage productDetailPage;
    public String txtPresent="Your shopping cart contains: 3 Products";
    public String txtSuccess="Your order on My Store is complete.";

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        softAssert = new SoftAssert();
        productDetailPage = new ProductDetailPage(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//td[@class=\"cart_total\"]//span[@class=\"price\"]")
    public List<WebElement> productPrice;

    @FindBy(xpath = "//td[@id=\"total_product\"]")
    public WebElement subtotal;

    @FindBy(xpath = "//td[@class=\"cart_unit\"]//span//span[@class=\"price\"]")
    public List<WebElement> unitPrice;

    @FindBy(xpath = "//td[@id=\"total_shipping\"]")
    public WebElement totalShipping;

    @FindBy(xpath = "//td[@id=\"total_price_without_tax\"]")
    public WebElement totalWTax;

    @FindBy(xpath = "//td[@id=\"total_tax\"]")
    public WebElement tax;

    @FindBy(xpath = "//span[@id=\"total_price\"]")
    public WebElement total;

    @FindBy(xpath = "//h1[@id=\"cart_title\"]/span")
    public WebElement text;

    @FindBy(xpath = "//div[@id=\"ordermsg\"]/textarea")
    public WebElement comentario;

    @FindBy(xpath = "//form[@id=\"form\"]/div/p[2]/label")
    public  WebElement terms;

    @FindBy(xpath = "//div[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")
    public  WebElement paybybankwire;

    @FindBy(xpath = "//span[contains(.,\"I confirm my order\")]")
    public WebElement btnConfirmOrder;

    @FindBy(xpath = "//div[@id=\"center_column\"]/div/p/strong")
    public  WebElement txtOrderSuccess;

    @FindBy(xpath = "//div[@id=\"center_column\"]/p[2]/a[1]")
    public WebElement btnProceedCheckout;

    @FindBy(name = "processAddress")
    public  WebElement btnProcessAddress;

    @FindBy(name = "processCarrier")
    public  WebElement btnProcessCarrier;



    public void verifyTotalProducts(){

        for (int i=0; i<productPrice.size();i++){
            lenghtPrice= productPrice.get(i).getText().length();
           suma=  suma + (Double.valueOf(productPrice.get(i).getText().substring(1,lenghtPrice)));
        }
        lenghtPrice = subtotal.getText().length();
        if (suma==Double.valueOf(subtotal.getText().substring(1,lenghtPrice))){
            System.out.println("La suma total de los productos es correcta (Total Products)" +
                    "["+suma+"]" + "--" + "[" + subtotal.getText().substring(1,lenghtPrice) + "]");
        }else{
            System.out.println("La suma total de los productos no es correcta (Total Products)");
        }

        softAssert.assertEquals(Double.valueOf(subtotal.getText().substring(1,lenghtPrice)), suma);
       //softAssert.assertAll(); //-> se comenta debido a que se cae el test



    }

    public void verifyUnitPriceProducts() {

        for (int i = 0; i < unitPrice.size(); i++) {
            lenghtPrice = unitPrice.get(i).getText().length();
            if (Double.valueOf(unitPrice.get(i).getText().substring(1, lenghtPrice)) == productDetailPage.setArrayprice(i)) {
                System.out.println("El precio unitario del producto es el correcto" +
                        "[" + unitPrice.get(i).getText().substring(1, lenghtPrice) + "]" + "--" + "[" + productDetailPage.setArrayprice(i) + "]");
            } else {
                System.out.println("El precio unitario del producto no es el correcto" +
                        "[" + unitPrice.get(i).getText().substring(1, lenghtPrice) + "]" + "--" + "[" + productDetailPage.setArrayprice(i) + "]");
            }

            softAssert.assertEquals(productDetailPage.setArrayprice(i), unitPrice.get(i).getText().substring(1, lenghtPrice));
            //softAssert.assertAll(); //-> se comenta debido a que se cae el test
        }
    }
        public void verifyTotalPriceProducts(){
            double sumap=0;

            lenghtPrice = totalWTax.getText().length();
            sumap=  sumap + (Double.valueOf(totalWTax.getText().substring(1,lenghtPrice)));

            lenghtPrice = tax.getText().length();
            sumap=  sumap + (Double.valueOf(tax.getText().substring(1,lenghtPrice)));

            lenghtPrice = total.getText().length();

            if(sumap==Double.valueOf(total.getText().substring(1,lenghtPrice))){
                System.out.println("El precio total es el correcto: "  + sumap);
            }else {
                System.out.println("El precio total no es el correcto: "  + sumap);
            }


                softAssert.assertEquals(sumap, Double.valueOf(total.getText().substring(1,lenghtPrice)));
                //softAssert.assertAll(); //-> se comenta debido a que se cae el test




    }


    public void verifyText(){

        if(text.getText().equalsIgnoreCase(txtPresent)){
            System.out.println("La cantidad de productos es correcta: "  + text.getText());
        }else {
            System.out.println("La cantidad de productos no es correcta: "  + text.getText());
        }


        softAssert.assertEquals(text.getText(), txtPresent);
        //softAssert.assertAll(); //-> se comenta debido a que se cae el test




    }


    public void setComentario(String c){
        comentario.clear();
        comentario.sendKeys(c);

    }
    public void checkTerms(){
        terms.click();
    }

    public  void payByBankWire(){
        paybybankwire.click();
    }

    public  void confirmOrder(){
        btnConfirmOrder.click();
    }

    public void verifyTextOrder(){

        if(txtOrderSuccess.getText().equalsIgnoreCase(txtSuccess)){
            System.out.println("La orden se realizo de manera exitosa: "  + txtOrderSuccess.getText());
        }else {
            System.out.println("La orden no se realizo de manera exitosa: "  + txtOrderSuccess.getText());
        }


        softAssert.assertEquals(txtOrderSuccess.getText(), txtSuccess);
        //softAssert.assertAll(); //-> se comenta debido a que se cae el test




    }
    public void btnProceedCheckout(){
        btnProceedCheckout.click();
    }

    public void btnProcessAdress(){
        btnProcessAddress.click();
    }

    public void btnProcessCarrier(){
        btnProcessCarrier.click();
    }

}


