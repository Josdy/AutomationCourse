package Yelp.pageobject;

import com.utilities.ActionsMethod;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PaginaPrincipal extends PageObject {
    @FindBy(xpath="//a[@class='homepage-hero_link' and contains (text(), 'Restaurants')]")
    WebElementFacade restOption;

    @FindBy(xpath = "//input[@id='search_description']")
    WebElementFacade searchBox;

    @FindBy(xpath="//form[@id='header_find_form']//button[@value='submit']")
    WebElementFacade searchButton;

    @FindBy(xpath = "//div//h1[@class=\"css-m7s7xv\"]")
    WebElementFacade restaurantName;
    @FindBy(xpath="//*[contains(text(),'Phone number')]//following-sibling::p")
    WebElementFacade restaurantPhone;

    @FindBy(xpath="//*[contains(text(),'Get Directions')]//parent::p//following-sibling::p")
    WebElementFacade restaurantAddress;

    @FindBy(xpath = "//div[@role=\"img\"]")
    WebElementFacade restaurantRating;

    @FindBy(xpath="//span[contains(text(),'Yelp Sort')]/parent::button")
    WebElementFacade reviewSortByButton;

    @FindBy(xpath="//*[contains(text(),'Newest First')]//ancestor::button")
    WebElementFacade newestFirstBtn;



    static String xpathNombreRestaurante="//*[contains(@class,'ResultsContainer')]//descendant::h4";
    static Integer count;
    static List<WebElementFacade> myListOfRestaurants;
    static List<WebElementFacade> myReviewsOfRestaurant;
    public ActionsMethod actions;



    public void restaurantOption(){
        restOption.click();

    }

    public void searchTypeRestaurant(String restaurant){
        searchBox.clear();
        searchBox.sendKeys(restaurant);
        searchButton.click();
        myListOfRestaurants=withTimeoutOf(30, TimeUnit.SECONDS).findAll(By.xpath(xpathNombreRestaurante));
        numSearchPerPage(myListOfRestaurants);
        Serenity.recordReportData().withTitle("Total de Resultados").andContents("Numero de restaurantes de la pagina actual: "+count);
    }

    public void selectTypeOfDistanceFilter(String distance){

        String filterxpath="//span[contains(text(),'"+distance+"')]";
        WebElement filterNeighboorH=withTimeoutOf(10,TimeUnit.SECONDS).find((By.xpath(filterxpath)));
        filterNeighboorH.click();
    }

    public void selectFirstResult(){
        myListOfRestaurants=withTimeoutOf(20,TimeUnit.SECONDS).findAll(By.xpath(xpathNombreRestaurante));
        for(WebElementFacade inputElement : myListOfRestaurants){
            if(inputElement.getText().contains(".")){
                Serenity.recordReportData().withTitle("Nombre del Primer Restaurante de Sushi: ").andContents(inputElement.getText());
                inputElement.click();
                break;
            }
        }
    }

    public void getDetails() throws InterruptedException {
        String nomRest=" El nombre del restaurante de sushi es : " + restaurantName.getText();
        String phone="El telefono del restaurante es: " +restaurantPhone.getText();
        String address="La direccion del restaurante es: " +restaurantAddress.getText();

        String rating = "El puntaje de rating del restaurante es: " + restaurantRating.getAttribute("aria-label");
        System.out.println(rating);
        reviewSortByButton.click();
        newestFirstBtn.click();
        Thread.sleep(4000);
        String xpathReviews="//p[@class='comment__373c0__Nsutg css-n6i4z7']";
        myReviewsOfRestaurant=withTimeoutOf(20,TimeUnit.SECONDS).findAll(By.xpath(xpathReviews));
        String firstReview="El primer review mas reciente es: " +myReviewsOfRestaurant.get(0).getText();
        String secondReview="El segundo review mas reciente es: " +myReviewsOfRestaurant.get(1).getText();
        String thirdReview="El tercer review mas reciente es: " +myReviewsOfRestaurant.get(2).getText();
        String details = nomRest + "\n" + phone + "\n" + address + "\n" + rating + "\n" + firstReview + "\n" + secondReview + "\n" +
                thirdReview;
        Serenity.recordReportData().withTitle("Details y Reviews").andContents(details);

    }

    public void numSearchPerPage(List<WebElementFacade> lista){
        count=0;
        for(WebElementFacade inputElement : lista){
            if(inputElement.getText().contains(".")){
                count=count+1;
            }
        }

    }
}
