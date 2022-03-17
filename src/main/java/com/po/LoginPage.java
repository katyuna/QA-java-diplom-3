package com.po;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    @FindBy(how = How.XPATH, using = "//a[@href='/register']")
    public SelenideElement linkRegister;

    @FindBy(how = How.XPATH, using = "//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    public SelenideElement buttonLogin;

    @FindBy(how = How.XPATH, using = "//div[@class='Auth_login__3hAey']//h2")
    public SelenideElement enterText;

    public void clickRegisterLink() {
        this.linkRegister.click();
    }

    public String getEnterText (){
        return this.enterText.getText();
    }
}
