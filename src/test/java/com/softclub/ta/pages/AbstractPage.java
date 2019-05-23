package com.softclub.ta.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    private static final Logger LOGGER = LogManager.getLogger(AbstractPage.class);
    protected static final int WEB_DRIVER_WAIT_TIME_OUT_IN_SECONDS = 30;
    private WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage(String url) {
        LOGGER.info(url + " opened");
        getDriver().get(url);
    }

    public void waitForVisibilityOf(WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, WEB_DRIVER_WAIT_TIME_OUT_IN_SECONDS);
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOf(element);
        LOGGER.info("Wait for condition: {}", condition);
        webDriverWait.until(condition);
    }

    public WebDriver getDriver() {
        return driver;
    }
}
