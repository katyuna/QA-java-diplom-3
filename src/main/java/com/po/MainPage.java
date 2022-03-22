package com.po;

import com.codeborne.selenide.ElementsCollection;
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
    //Табы "Булки", Соусы", "Начинки"
    @FindBy(how = How.CLASS_NAME,using = "tab_tab__1SPyG")
    public ElementsCollection tabs;

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
    //Методы клика по табам "Булки", Соусы", "Начинки"
    public void clickBuns(){
        this.tabs.get(0).click();
    }
    public  void clickSauces(){
        this.tabs.get(1).click();
    }
    public  void clickFillings(){
        this.tabs.get(2).click();
    }
}
