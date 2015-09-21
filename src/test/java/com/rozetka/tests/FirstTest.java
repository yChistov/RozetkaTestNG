package com.rozetka.tests;

import com.rozetka.core.BaseSetup;
import com.rozetka.core.web.pages.MyHomePage;
import com.rozetka.core.web.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeoutException;

public class FirstTest extends BaseSetup {

    @Test
    public void startURL() throws TimeoutException {
        SearchPage targetPage = new MyHomePage(driver)
                .loadAsAnonymousUser()
                .loginAs("misteriys@ukr.net", "ghjuhfvbcn")
                .goToFindPage()
                .getSearch("gtx 980")
                .getBuy()
                .getDelete();
        System.out.println(targetPage.getPriceSearch());
        System.out.println(targetPage.getPriceBasket());
        Assert.assertEquals(targetPage.getPriceSearch(), targetPage.getPriceBasket());
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
    }
}

