package com.softclub.ta.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import com.softclub.ta.driver.DriverSingleton;
import com.softclub.ta.pages.LoginPage;
import com.softclub.ta.pages.MainPage;

public class TestScenario1 {
    private static final String LOAD_LOGIN_PAGE = "https://www.gmail.com";
    private static final String IS_NOT_DISPLAYED_MESSAGE = " is not displayed";
    private static final String EMAIL = "pavelsoft2019@gmail.com";
    private static final String PASSWORD = "asdZXC2019";
    private LoginPage loginPage;
    private MainPage mainPage;

    @BeforeTest
    public void useDriverSingleton() {
        loginPage = new LoginPage(DriverSingleton.getDriver());
        loginPage.openPage(LOAD_LOGIN_PAGE);
        loginPage.fillEmailField(EMAIL);
        mainPage = new MainPage(DriverSingleton.getDriver());
    }

    @Test
    public void testPasswordFieldIsDisplayed() {
        Assert.assertTrue(loginPage.getPasswordField().isDisplayed(), "Password field"
                + IS_NOT_DISPLAYED_MESSAGE);
    }

    @Test
    public void testFillPassword() {
        loginPage.fillPassword(PASSWORD);

        Assert.assertTrue(mainPage.getReceivedLetters().isDisplayed(), "Main page"
                + IS_NOT_DISPLAYED_MESSAGE);
    }

    @AfterTest
    public void dismissDriver() {
        DriverSingleton.closeDriver();
    }
}