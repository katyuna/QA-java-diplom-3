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



    /*Табы "Булки", Соусы", "Начинки"
    @FindBy(how = How.CLASS_NAME,using = "tab_tab__1SPyG")
    public ElementsCollection tabs;*/

    //Таб "Булки"
    @FindBy(how = How.XPATH,using = ".//span[contains(text(),'Булки')]")
    public SelenideElement tabBun;
    //Таб "Соусы"
    @FindBy(how = How.XPATH,using = ".//span[contains(text(),'Соусы')]")
    public SelenideElement tabSauces;
    //Таб "Начинки"
    @FindBy(how = How.XPATH,using = ".//span[contains(text(),'Начинки')]")
    public SelenideElement tabFillings;


    //Заголовки табов
    @FindBy(how = How.XPATH, using = ".//h2[text()='Булки']")
    private SelenideElement bunsHeader;
    @FindBy(how = How.XPATH, using = ".//h2[text()='Соусы']")
    private SelenideElement saucesHeader;
    @FindBy(how = How.XPATH, using = ".//h2[text()='Начинки']")
    private SelenideElement fillingsHeader;



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
        this.tabBun.click();
    }
    public  void clickSauces(){
        this.tabSauces.click();
    }
    public  void clickFillings(){
        this.tabFillings.click();
    }

    //Методы,определяющие отображение заголовков табов Булки, Соусы, Начинки
    public boolean isBunsHeaderDisplayed() {
        return bunsHeader.isDisplayed();
    }
    public boolean isSaucesHeaderDisplayed() {
        return saucesHeader.isDisplayed();
    }
    public boolean isFillingsHeaderDisplayed() {
        return fillingsHeader.isDisplayed();
    }
}
