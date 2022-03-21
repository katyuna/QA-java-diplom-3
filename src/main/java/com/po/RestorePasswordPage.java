package com.po;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RestorePasswordPage {
    @FindBy(how = How.XPATH, using = ".//a[@href='/login']")
    public SelenideElement linkLogin;

    //Клик по ссылке войти
    public void clickLoginLink() {
        this.linkLogin.click();


    }
}
