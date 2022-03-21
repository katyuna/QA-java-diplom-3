package com.po;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site";
    //Кнопика "Личный кабинет"
    @FindBy(how = How.XPATH, using = ".//a[@href='/account']")
    public SelenideElement buttonAccount;
    //Кнопка Войти в аккаунт
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    public SelenideElement buttonEnterAccount;
    //Кнопка Оформить заказ
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    public SelenideElement buttonCreateOrder;

    public void clickAccountButton() {
        this.buttonAccount.click();
    }

    public void clickEnterAccountButton() {
        this.buttonEnterAccount.click();
    }

    public void clickCreateOrderButton() {
        this.buttonCreateOrder.click();
    }

    //Метод,определяющий отображение кнопки Оформить заказ
    public boolean isOrderButton() {
        return buttonCreateOrder.isDisplayed();
    }
}
