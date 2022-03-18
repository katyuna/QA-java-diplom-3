package com.po;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
    //Ссылка "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = "//a[@href='/register']")
    public SelenideElement linkRegister;
    //Кнопка "Войти"
    @FindBy(how = How.XPATH, using = "//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    public SelenideElement buttonLogin;
    //Текст "Вход"
    @FindBy(how = How.XPATH, using = "//div[@class='Auth_login__3hAey']//h2")
    public SelenideElement enterText;
    //Инпут email
    @FindBy(how = How.XPATH, using = ".//fieldset[1]//input[@name='name']")
    public SelenideElement inputEmail;
    //Инпут password
    @FindBy(how = How.XPATH, using = ".//input[@type='password']")
    public SelenideElement inputPassword;
    //Кнопка "Войти"
    @FindBy(how = How.XPATH, using = "//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    public SelenideElement buttonEnter;

    //Методы заполнения полей формы и клик по кнопке
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
    public void clickEnterButton() {
        this.buttonEnter.click();
    }

    //Метод заполнения всей формы и переход дальше
    public void fillLoginForm(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickEnterButton();
    }






    //Клик по ссылке "Зарегистрироваться"
    public void clickRegisterLink() {
        this.linkRegister.click();
    }
    //Получить текст "Вход"
    public String getEnterText (){
        return this.enterText.getText();
    }
}
