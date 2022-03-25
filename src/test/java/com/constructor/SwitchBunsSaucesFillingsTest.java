package com.constructor;

import com.BaseTest;
import com.UserOperations;
import com.codeborne.selenide.Selenide;
import com.po.MainPage;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class SwitchBunsSaucesFillingsTest extends BaseTest {

    @Test
    @DisplayName ("Переход на таб Булки")
    public void testSwitchToBunIsOk(){
        //ARRANGE
        MainPage mainPage = page(MainPage.class);
        //ACT
        mainPage.clickSauces();
        mainPage.clickBuns();
        //ASSERT
        //Проверить отображение заголовка Булки
        boolean isBunHeader = mainPage.isBunsHeaderDisplayed();
        assertTrue("Таб Булки не открылся.",isBunHeader);
    }

    @Test
    @DisplayName ("Переход на таб Соусы")
    public void testSwitchToSaucesIsOk(){
        //ARRANGE
        MainPage mainPage = page(MainPage.class);
        //ACT
        mainPage.clickSauces();
        //ASSERT
        //Проверить отображение заголовка Соусы
        boolean isSaucesHeader = mainPage.isSaucesHeaderDisplayed();
        assertTrue("Таб Соусы не открылся.",isSaucesHeader);
    }

    @Test
    @DisplayName ("Переход на таб Начинки")
    public void testSwitchToFillingsIsOk(){
        //ARRANGE
        MainPage mainPage = page(MainPage.class);
        //ACT
        mainPage.clickFillings();
        //ASSERT
        //Проверить отображение заголовка Начинки
        boolean isFillingsHeader = mainPage.isFillingsHeaderDisplayed();
        assertTrue("Таб Соусы не открылся.",isFillingsHeader);
    }
    //Т.к. пользователя удалять не надо - переопределила метод
    @Override
    public void deleteUser(){
    }
}
