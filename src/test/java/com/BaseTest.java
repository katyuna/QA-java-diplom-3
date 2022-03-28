package com;

import com.codeborne.selenide.Selenide;
import com.po.MainPage;
import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {
    protected UserOperations userOperations;

    @Before
    public void before() {
        /*по умолчанию запускается Google Chrome
        Для запуска тестов в Яндекс.Браузер раскомментировать строку ниже.*/
        //System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
        //Либо отдельными командами maven
        //Либо отдельная сборка в Jenkins для каждого браузера
        MainPage mainPage = open(MainPage.URL, MainPage.class);
    }

    @After
    //Удалить пользователя
    public void deleteUser(){
        userOperations.delete();
    }
   //Закрыть браузер
    public void closeBrowser() {
        Selenide.closeWindow();
    }
}
