package com.rozetka.core.web.pages;

import com.rozetka.core.web.WebPage;
import com.rozetka.core.web.elements.Button;
import com.rozetka.core.web.elements.Link;
import com.rozetka.core.web.elements.TextInput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeoutException;

public class BasePage extends WebPage<BasePage> {

    private static final String BASE_URL = "http://rozetka.com.ua/";

    public BasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage load() {
        driver.get(BASE_URL);
        return null;
    }

    @Override
    public boolean isAvailable() {
        return getUsernameInput().isAvailable() &&
                getPasswordInput().isAvailable() &&
                getLoginButton().isAvailable() &&
                getMyLinkLogin().isAvailable();
    }

    public MyHomePage loginAs(String login, String password) throws TimeoutException {
        getUsernameInput().inputText(login);
        getPasswordInput().inputText(password);
        getLoginButton().click();
        return new MyHomePage(driver).waitUntilAvailable();
    }

    private TextInput getUsernameInput(){
        return new TextInput(driver, By.name("login"));
    }

    private TextInput getPasswordInput(){
        return new TextInput(driver, By.name("password"));
    }

    private Button getLoginButton(){
        return new Button(driver, By.cssSelector(".btn-link.btn-link-blue.btn-link-sign"));
    }

    private Link getMyLinkLogin() {
        return  new Link(driver, By.name("signin"));
    }
}
