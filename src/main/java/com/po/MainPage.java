package com.po;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site";

    @FindBy(how = How.XPATH, using = "//a[@href='/account']")
    public SelenideElement buttonAccount;

    public void clickAccountButton() {
        this.buttonAccount.click();
    }
}
