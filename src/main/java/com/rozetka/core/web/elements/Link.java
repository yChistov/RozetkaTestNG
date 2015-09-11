package com.rozetka.core.web.elements;

import com.rozetka.core.web.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Link extends WebComponent<Link> {

    public Link(WebDriver driver, By findByMethod) {
        super(driver, findByMethod);
    }
}
