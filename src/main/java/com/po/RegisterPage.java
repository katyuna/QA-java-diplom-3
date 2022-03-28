package com.po;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage {

    // Задаем URL страницы константой
    public static final String URL_REGISTER = "https://stellarburgers.nomoreparties.site/register";

    @FindBy(how = How.XPATH, using = ".//fieldset[1]//input[@name='name']")
    public SelenideElement inputName;
    @FindBy(how = How.XPATH, using = ".//fieldset[2]//input[@name='name']")
    public SelenideElement inputEmail;
    @FindBy(how = How.XPATH, using = ".//input[@type='password']")
    public SelenideElement inputPassword;
    @FindBy(how = How.XPATH, using = "//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    public SelenideElement buttonRegister;
    @FindBy(how = How.XPATH, using = ".//p[@class='input__error text_type_main-default']")
    private SelenideElement errorMessage;
    @FindBy(how = How.XPATH, using = ".//a[@href='/login']")
    public SelenideElement linkLogin;

    //Методы заполнения полей формы и клик по кнопке
    public void setName(String name)
    {
        this.inputName.click();
        this.inputName.setValue(name);
    }
    public void setEmail(String email)
    {
        this.inputEmail.click();
        this.inputEmail.setValue(email);
    }
    public void setPassword(String password)
    {
        this.inputPassword.click();
        this.inputPassword.setValue(password);
    }
    public void clickRegisterButton() {
        this.buttonRegister.click();
    }
    //Метод заполнения всей формы и переход дальше
    public void fillForm(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        clickRegisterButton();
    }
    //Метод,определяющий есть ли ошибка
    public boolean isErrorMessage() {
        return errorMessage.isDisplayed();

    }
    //Клик по ссылке "Войти"
    public void clickLoginLink(){
        this.linkLogin.click();
    }
}
