package com.login;

import com.BaseTest;
import com.UserOperations;
import com.model.User;
import com.po.LoginPage;
import com.po.MainPage;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Map;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EnterAccountWithEnterAccountButtonTest extends BaseTest {

    @Test
    @DisplayName("Вход в аккацнт по кнопке Войти в Аккаунт на главной странице")
    public void testEnterAccountButtonIsOk() {

        //Зарегистрировать пользователя и получить его данные для авторизации
        UserOperations userOperations = new UserOperations();
        Map<String, String> userData = userOperations.register();
        String userName = userData.get("name");
        String userEmail = userData.get("email");
        String userPassword = userData.get("password");

        //Создать экземпляры страниц
        MainPage mainPage = page(MainPage.class);
        LoginPage loginPage = page(LoginPage.class);
        mainPage.buttonEnterAccount.click();

        loginPage.fillLoginForm(userEmail, userPassword);

        //Подождать пока кнопка появится и убедится что она действительно появилась
        mainPage.buttonCreateOrder.shouldBe(enabled);
        //Проверку проверить, что отображается кнопка Оформить заказ
        boolean createOrderButtonIsDisplayed = mainPage.isOrderButton();
        assertTrue(createOrderButtonIsDisplayed);
    }
}
