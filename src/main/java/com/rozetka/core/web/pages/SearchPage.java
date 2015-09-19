package com.rozetka.core.web.pages;

import com.rozetka.core.web.WebPage;
import com.rozetka.core.web.elements.Button;
import com.rozetka.core.web.elements.TextInput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends WebPage<SearchPage> {

    private static final String FIND_URL = "https://my.rozetka.com.ua/";

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SearchPage load() {
        driver.get(FIND_URL);
        return null;
    }

    @Override
    public boolean isAvailable() {
        return getSearch().isAvailable();
    }

    public SearchPage getSearch(String search){
        getSearch().inputText(search);
        getButtonSearch().click();
        return this;
    }

    public SearchPage getBuy(){
        getButtonBuy().click();
        return this;
    }

    public SearchPage getRefresh(){
        driver.navigate().refresh();
        return this;
    }

     private TextInput getSearch(){
        return new TextInput(driver, By.name("text"));
    }

    private Button getButtonSearch(){
        return new Button(driver,By.xpath("//*[@id='search']/form//span/button"));
    }

    private Button getButtonBuy(){
        return new Button(driver,
                By.xpath(".//*[@id='block_with_search']/div/div[1]/div[2]/div[4]/div/div/form/span/button"));
    }

}
