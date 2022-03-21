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

public class GoToProfileTest extends BaseTest {

    @Test
    @DisplayName("Переход в личный кабинет")
    public void testExitButtonIsDisplayedInToAccountPage() {
        //Зарегистрировать пользователя и получить его данные для авторизации
        UserOperations userOperations = new UserOperations();
        Map<String, String> userData = userOperations.register();
        String userEmail = userData.get("email");
        String userPassword = userData.get("password");

        //Создать экземпляры страниц
        MainPage mainPage = page(MainPage.class);
        LoginPage loginPage = page(LoginPage.class);
        ProfilePage profilePage = page(ProfilePage.class);

        //Клик по кнопке "Войти в аккаунт" и авторизоваться
        mainPage.buttonEnterAccount.click();
        loginPage.fillLoginForm(userEmail, userPassword);
        //Подождать пока кнопка "Оформить заказ" появится
        mainPage.buttonCreateOrder.shouldBe(enabled);
        //Перейти в Личный кабинет
        mainPage.buttonAccount.click();
        //Подождать пока кнопка Выход появится
        profilePage.exitButton.shouldBe(enabled);

        //Проверить, что отображается кнопка Выход
       boolean isExitButtonDisplayed = profilePage.isExitButton();
       assertTrue(isExitButtonDisplayed);

    }
}