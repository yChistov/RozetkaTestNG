package com.rozetka.core;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "DataProviderSearch")
    public static Object[][] sameSearch(){
        return new Object[][]{
                {"gtx 980"},
                {"i7"}
        };
    }
}
