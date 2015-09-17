package com.rozetka.core.web.pages;

import com.rozetka.core.web.WebPage;
import com.rozetka.core.web.elements.Button;
import com.rozetka.core.web.elements.TextInput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeoutException;

public class FindPage extends WebPage<FindPage> {

    private static final String FIND_URL = "https://my.rozetka.com.ua/";

    public FindPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public FindPage load() {
        driver.get(FIND_URL);
        return null;
    }

    @Override
    public boolean isAvailable() {
        return getFind().isAvailable();
    }

    public FindPage getSearch(String search){
        getFind().inputText(search);
        getButtonSearch().click();
        return this;
    }

     private TextInput getFind(){
        return new TextInput(driver, By.name("text"));
    }

    private Button getButtonSearch(){
        return new Button(driver,By.xpath("//*[@id='search']/form//span/button"));
    }

    public BuyPage goToBuyPage() throws TimeoutException {
        return new BuyPage(driver).waitUntilAvailable();
    }

}
