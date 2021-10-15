package com.dataprovider;

import org.testng.annotations.DataProvider;

public class CreateAccountDataProvider {


    @DataProvider(name = "form data")
    public Object[][] formData() {
        return new Object[][]{
                {"anaelisabet0@gmail.com","Ana", "Cruz", "12345",
                        "Oktana", "Lima", "Lince", "07605",
                        "041885726", "956887745" , "home"}

        };
    }
}
