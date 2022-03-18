package com;

import com.po.MainPage;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {

    @Before
    public void before() {
        /*по умолчанию запускается Google Chrome
        Для запуска тестов в Яндекс.Браузер раскомментировать строку ниже.*/
        // System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
        MainPage mainPage = open(MainPage.URL, MainPage.class);
    }
}
