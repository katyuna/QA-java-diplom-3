package com.profile;

import com.BaseTest;
import com.UserOperations;
import com.po.LoginPage;
import com.po.MainPage;
import com.po.ProfilePage;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Map;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class ExitProfileTest extends BaseTest {
    @Test
    @DisplayName("Выход из личного кабинета кабинет")
    public void testLoginButtonDisplayedAfterExitProfile() {

        //ARRANGE
        //Зарегистрировать пользователя и получить его данные для авторизации
        UserOperations userOperations = new UserOperations();
        Map<String, String> userData = userOperations.register();
        String userEmail = userData.get("email");
        String userPassword = userData.get("password");
        //Создать экземпляры страниц
        MainPage mainPage = page(MainPage.class);
        LoginPage loginPage = page(LoginPage.class);
        ProfilePage profilePage = page(ProfilePage.class);

        //ACT
        //Клик по кнопке "Войти в аккаунт" и авторизоваться
        mainPage.buttonEnterAccount.click();
        loginPage.fillLoginForm(userEmail, userPassword);
        //Перейти в Личный кабинет
        mainPage.buttonAccount.click();
        //Подождать пока кнопка Выход появится (страница загрузится)
        profilePage.exitButton.shouldBe(enabled);
        //Клик по кнопке выхода
        profilePage.clickExitButton();
        //Подождать пока кнопка Логина появится (страница загрузится)
        loginPage.buttonLogin.shouldBe(enabled);

        //ASSERT
        //Проверить, что отображается кнопка Логина
        boolean isLoginButtonDisplayed = loginPage.isLoginButton();
        assertTrue("Не произошел переход на страницу логина после выхода из личного кабинета", isLoginButtonDisplayed);

    }
}
