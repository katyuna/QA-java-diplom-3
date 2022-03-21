package com.login;

import com.BaseTest;
import com.UserOperations;
import com.po.LoginPage;
import com.po.MainPage;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Map;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class EnterAccountWithEnterAccountButtonTest extends BaseTest {

    @Test
    @DisplayName("Вход в профиль по кнопке Войти в Аккаунт на главной странице")
    public void testEnterAccountButtonIsOk() {

        //Зарегистрировать пользователя и получить его данные для авторизации
        UserOperations userOperations = new UserOperations();
        Map<String, String> userData = userOperations.register();
        String userEmail = userData.get("email");
        String userPassword = userData.get("password");

        //Создать экземпляры страниц
        MainPage mainPage = page(MainPage.class);
        LoginPage loginPage = page(LoginPage.class);

        //Клик по кнопке "Войти в аккаунт" на главной странице
        mainPage.buttonEnterAccount.click();
        //Заполнить форму логина
        loginPage.fillLoginForm(userEmail, userPassword);
        //Подождать пока кнопка "Оформить заказ" появится
        mainPage.buttonCreateOrder.shouldBe(enabled);
        //Проверить, что кнопка "Оформить заказ" отображается
        boolean createOrderButtonIsDisplayed = mainPage.isOrderButton();
        assertTrue(createOrderButtonIsDisplayed);
    }
}
