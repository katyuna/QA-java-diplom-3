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

public class EnterAccountWithAccountButtonTest extends BaseTest {
    @Test
    @DisplayName("Вход в аккаунт по кнопке Личный Кабинет на главной странице")
    public void testAccountButtonIsOk() {
        //Зарегистрировать пользователя и получить его данные для авторизации
        UserOperations userOperations = new UserOperations();
        Map<String, String> userData = userOperations.register();
        String userName = userData.get("name");
        String userEmail = userData.get("email");
        String userPassword = userData.get("password");

        //Создать экземпляры страниц
        MainPage mainPage = page(MainPage.class);
        LoginPage loginPage = page(LoginPage.class);

        //Клик по "Личный кабинет"
        mainPage.buttonAccount.click();
        //Заполнить форму логина
        loginPage.fillLoginForm(userEmail, userPassword);
        //Подождать пока кнопка "Оформить заказ" появится
        mainPage.buttonCreateOrder.shouldBe(enabled);
        //Проверить, что кнопка "Оформить заказ" отображается
        boolean createOrderButtonIsDisplayed = mainPage.isOrderButton();
        assertTrue(createOrderButtonIsDisplayed);

    }

}
