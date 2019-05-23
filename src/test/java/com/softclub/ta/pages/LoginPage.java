package com.softclub.ta.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.softclub.ta.driver.DriverSingleton;

public class LoginPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getLogger(LoginPage.class);

    @FindBy(xpath = "//*[@id='view_container']//form[@method='post']//input[@type='email']")
    private WebElement emailField;

    @FindBy(id = "identifierNext")
    private WebElement nextButton;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//content[contains(.,'Далее')]")
    private WebElement passwordNextButton;

    @FindBy(id = "profileIdentifier")
    private WebElement profileIdentifier;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(), this);
    }

    public WebElement getEmailField() {
        waitForVisibilityOf(emailField);
        return emailField;
    }

    public WebElement getPasswordField() {
        waitForVisibilityOf(passwordField);
        return passwordField;
    }

    public LoginPage clickButton(WebElement button) {
        LOGGER.info(button + " clicked");
        waitForVisibilityOf(button);
        button.click();
        return this;
    }

    public LoginPage fillEmailField(String email) {
        LOGGER.info("Email field is filled");
        waitForVisibilityOf(emailField);
        emailField.sendKeys(email);
        clickButton(nextButton);
        return this;
    }

    public LoginPage fillPassword(String password) {
        LOGGER.info("Password is filled");
        waitForVisibilityOf(passwordField);
        passwordField.sendKeys(password);
        clickButton(passwordNextButton);
        return this;
    }
}
