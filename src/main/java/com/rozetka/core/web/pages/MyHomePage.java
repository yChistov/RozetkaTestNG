package com.rozetka.core.web.pages;

import com.rozetka.core.web.WebPage;
import com.rozetka.core.web.elements.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeoutException;

public class MyHomePage extends WebPage<MyHomePage> {

    private static final String HOME_URL = "https://my.rozetka.com.ua/signin/";

    public MyHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MyHomePage load() {
        driver.get(HOME_URL);
        return null;
    }

    @Override
    public boolean isAvailable() {
        return getLogout().isAvailable();
    }

    public BasePage loadAsAnonymousUser() throws TimeoutException {
        load();
        return new BasePage(driver).waitUntilAvailable();
    }

    public SearchPage goToFindPage() throws TimeoutException {
        return new SearchPage(driver).waitUntilAvailable();
    }

    private Link getLogout(){
        return new Link(driver,
                By.cssSelector(".profile-m-edit-signout"));
    }
}
