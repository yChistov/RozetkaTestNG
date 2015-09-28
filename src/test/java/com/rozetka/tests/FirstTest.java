package com.rozetka.tests;

import com.rozetka.core.BaseSetup;
import com.rozetka.core.CsvDataProvider;
import com.rozetka.core.web.pages.MyHomePage;
import com.rozetka.core.web.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.concurrent.TimeoutException;

public class FirstTest extends BaseSetup {

    @Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class)
    public void startURL(Map<String, String> testData) throws TimeoutException {
        SearchPage targetPage = new MyHomePage(driver)
                .loadAsAnonymousUser()
                .loginAs(testData.get("login"), testData.get("password"))
                .goToFindPage()
                .getSearch(testData.get("search"))
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

