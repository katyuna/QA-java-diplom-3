package com.constructor;

import com.BaseTest;
import com.codeborne.selenide.SelenideElement;
import com.po.MainPage;
import io.qameta.allure.Step;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Condition.enabled;
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
        //Получить класс активного элемента
        String activeElementClass = mainPage.tabs.get(0).getAttribute("class");
        //ASSERT
        //Проверить, класс активного элемента
        assertTrue("Не произошел переход на таб Булки", activeElementClass.contains("tab_tab_type_current__2BEPc"));
    }

    @Test
    @DisplayName ("Переход на таб Соусы")
    public void testSwitchToSaucesIsOk(){
        //ARRANGE
        MainPage mainPage = page(MainPage.class);
        //ACT
        mainPage.clickSauces();
        //Получить класс активного элемента
        String activeElementClass = mainPage.tabs.get(1).getAttribute("class");
        //ASSERT
        //Проверить, класс активного элемента
        assertTrue("Не произошел переход на таб Соусы", activeElementClass.contains("tab_tab_type_current__2BEPc"));
    }

    @Test
    @DisplayName ("Переход на таб Начинки")
    public void testSwitchToFillingsIsOk(){
        //ARRANGE
        MainPage mainPage = page(MainPage.class);
        //ACT
        mainPage.clickFillings();
        //Получить класс активного элемента
        String activeElementClass = mainPage.tabs.get(2).getAttribute("class");
        //ASSERT
        //Проверить, класс активного элемента
        assertTrue("Не произошел переход на таб Начинки", activeElementClass.contains("tab_tab_type_current__2BEPc"));
    }
}
