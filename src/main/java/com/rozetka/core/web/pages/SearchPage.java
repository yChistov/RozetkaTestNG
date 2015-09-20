package com.rozetka.core.web.pages;

import com.rozetka.core.web.WebPage;
import com.rozetka.core.web.elements.Button;
import com.rozetka.core.web.elements.TextInput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends WebPage<SearchPage> {

    WebDriverWait wait = new WebDriverWait(driver, 10);

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

    public SearchPage getDelete(){
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(".//*[@id='cart-popup']/div/div[1]/div[2]/div[1]/a/img")));
        getDeleteFirstButton().click();
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(".//*[@id='cart-popup']/div/div[1]/div[2]/div[1]/div")));
        getDeleteSecondButton().click();
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

    private Button getDeleteFirstButton(){
        return new Button(driver, By.xpath(".//*[@id='cart-popup']/div/div[1]/div[2]/div[1]/a/img"));
    }

    private Button getDeleteSecondButton(){
        return new Button(driver, By.name("delete"));
    }

}
