package com.softclub.ta.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getLogger(MainPage.class);

    @FindBy(xpath = "//a[@title='Входящие']")
    private WebElement receivedLetters;

    @FindBy(xpath = "//span[@class='gb_xa gbii']")
    private WebElement accountGoogle;

    @FindBy(xpath = "//*[@id='gb_71']")
    private WebElement quitAccount;

    @FindBy(xpath = "//*[@id='view_container']//form[@method='post']//input[@type='email']")
    private WebElement emailField;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(), this);
    }

    public WebElement getReceivedLetters() {
        waitForVisibilityOf(receivedLetters);
        return receivedLetters;
    }

    public MainPage clickButton(WebElement button) {
        LOGGER.info(button + " clicked");
        waitForVisibilityOf(button);
        button.click();
        return this;
    }

    public MainPage clickAccountGoogleButton() {
        clickButton(accountGoogle);
        return this;
    }

    public MainPage clickQuitAccountButton() {
        clickButton(quitAccount);
        return this;
    }
}
