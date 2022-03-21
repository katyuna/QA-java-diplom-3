package com.po;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProfilePage {
    //Кнопка "Выход"
    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    public SelenideElement exitButton;

    //Клик по кнопке Выход
    public void clickExitButton(){
        this.exitButton.click();
    }

    //Метод,определяющий отображение кнопки Выход
    public boolean isExitButton() {
        return exitButton.isDisplayed();
    }
}
