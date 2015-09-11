package com.rozetka.tests;

import com.rozetka.core.BaseSetup;
import com.rozetka.core.web.pages.MyHomePage;
import org.testng.annotations.Test;

import java.util.concurrent.TimeoutException;

public class FirstTest extends BaseSetup {

    @Test
    public void startURL() throws TimeoutException {
        new MyHomePage(driver)
                .loadAsAnonymousUser()
                .loginAs("misteriys@ukr.net", "ghjuhfvbcn");
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
    }
}

