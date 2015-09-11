package com.rozetka.core.web;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeoutException;

public abstract class WebPage<T extends WebPage<T>> extends Component<T> {

    public WebPage(WebDriver driver){
        super(driver);
    }

    public abstract T load();

    public T loadAndWaitUntilAvailable() throws TimeoutException {
        load();
        return waitUntilAvailable();
    }
}
