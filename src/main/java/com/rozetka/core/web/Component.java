package com.rozetka.core.web;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeoutException;

public abstract class Component<T extends Component<T>> {

    protected WebDriver driver;

    public Component(WebDriver driver){
        this.driver = driver;
    }

    public abstract boolean isAvailable();

    public T waitUntilAvailable() throws TimeoutException {
        return new Wait<T>().forComponent((T) this).toBeAvailable();
    }
}
