package Yelp.steps;

import Yelp.pageobject.PaginaPrincipal;
import net.serenitybdd.core.steps.ScenarioActor;
import net.thucydides.core.annotations.Steps;

public class UsuarioYelp extends ScenarioActor {
    String actor;

    @Steps(shared=true)
    PaginaPrincipal paginaPrincipal;

    public void navigatesTo(){
        paginaPrincipal.setDefaultBaseUrl("https://www.yelp.com/");
        paginaPrincipal.open();
    }

    public void searchFor(){
        paginaPrincipal.restaurantOption();
    }

    public void searchRestaurant(String restaurant){
        paginaPrincipal.searchTypeRestaurant(restaurant);
    }

    public void filterByTypeOfDistance(String distance){
        paginaPrincipal.selectTypeOfDistanceFilter(distance);

    }

    public void enterFirstResult(){
        paginaPrincipal.selectFirstResult();
    }

    public void viewDetails() throws InterruptedException {
        paginaPrincipal.getDetails();
    }
}
