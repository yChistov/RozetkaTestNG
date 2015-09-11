package com.rozetka.core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static com.rozetka.core.DriverMaster.getDriver;

public abstract class BaseSetup {

    protected WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    @Parameters({"browser"})
    public void setUp(@Optional("firefox") String browser){
        driver = getDriver(browser);

    }

    @AfterSuite(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}

