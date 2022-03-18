package com;

import com.po.MainPage;
import org.junit.Before;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {

    @Before
    public void before() {
        /*по умолчанию запускается Google Chrome
        Для запуска тестов в Яндекс.Браузер раскомментировать строку ниже.*/
        // System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
        MainPage mainPage = open(MainPage.URL, MainPage.class);

        //Зарегистрировать пользователя и получить его данные для авторизации
        /* UserOperations userOperations = new UserOperations();
        Map<String, String> userData = userOperations.register();
        String userName = userData.get("name");
        String userEmail = userData.get("email");
        String userPassword = userData.get("password");*/

    }
}
