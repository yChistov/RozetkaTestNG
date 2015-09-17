package com.rozetka.core.web.pages;

import com.rozetka.core.web.WebPage;
import com.rozetka.core.web.elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BuyPage extends WebPage<BuyPage> {

    private static final String BUY_URL = "http://rozetka.com.ua/search/";

    public BuyPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BuyPage load() {
        driver.get(BUY_URL);
        return null;
    }

    @Override
    public boolean isAvailable() {
        return getButtonBuy().isAvailable();
    }

    public BuyPage getBuySearch(){
        getButtonBuy().click();
        return this;
    }

     private Button getButtonBuy(){
        return new Button(driver, By.xpath("//*[@id='block_with_search']//div[1]/div[2]/div[4]//div/form/span/button"));
    }

}
