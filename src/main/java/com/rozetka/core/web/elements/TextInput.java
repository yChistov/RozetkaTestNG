package com.rozetka.core.web.elements;

import com.rozetka.core.web.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextInput extends WebComponent<TextInput> {

    public TextInput(WebDriver driver, By findByMethod) {
        super(driver, findByMethod);
    }

    public TextInput inputText(String text){
        getWebElement().clear();
        getWebElement().sendKeys(text);
        return this;
    }
}
