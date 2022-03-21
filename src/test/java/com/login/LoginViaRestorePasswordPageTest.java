package com.login;

import com.BaseTest;
import com.UserOperations;
import com.po.LoginPage;
import com.po.MainPage;
import com.po.RestorePasswordPage;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Map;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class LoginViaRestorePasswordPageTest extends BaseTest {
    @Test
    @DisplayName("Вход в профиль по ссылке Войти на странице восстановления пароля")
    public void testCreateOrderButtonIsDisplayedAfterLoginViaRestorePasswordPage() {
        //Зарегистрировать пользователя и получить его данные для авторизации
        UserOperations userOperations = new UserOperations();
        Map<String, String> userData = userOperations.register();
        String userEmail = userData.get("email");
        String userPassword = userData.get("password");

        //Создать экземпляры страниц
        MainPage mainPage = page(MainPage.class);
        LoginPage loginPage = page(LoginPage.class);
        RestorePasswordPage restorePasswordPage = page(RestorePasswordPage.class);

        //Перейти по страницам до формы логина
        mainPage.buttonAccount.click();
        loginPage.linkForgotPassword.click();
        restorePasswordPage.linkLogin.click();

        //Заполнить форму логина
        loginPage.fillLoginForm(userEmail, userPassword);
        //Подождать пока кнопка "Оформить заказ" появится
        mainPage.buttonCreateOrder.shouldBe(enabled);
        //Проверить, что кнопка "Оформить заказ" отображается
        boolean isCreateOrderButtonIsDisplayed = mainPage.isOrderButton();
        assertTrue(isCreateOrderButtonIsDisplayed);




    }
}
