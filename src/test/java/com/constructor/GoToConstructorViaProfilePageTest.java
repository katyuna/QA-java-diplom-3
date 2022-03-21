package com.constructor;

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

public class GoToConstructorViaProfilePageTest extends BaseTest {
    @Test
    @DisplayName("Переход в конструктор из личного кабинета")
    public void testIsCreateBurgerTextDisplayedAfterGoToConstructorViaProfile() {
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
        //Перейти в Личный кабинет
        mainPage.buttonAccount.click();
        //Подождать пока кнопка Выход появится
        profilePage.exitButton.shouldBe(enabled);
        //Перейти в конструктор по логотипу Stellar Burgers
        profilePage.logoStellarBurgers.click();
        //Подождать пока кнопка "Оформить заказ" появится
        mainPage.buttonCreateOrder.shouldBe(enabled);
        //Проверить, что кнопка "Оформить заказ" отображается
        boolean createOrderButtonIsDisplayed = mainPage.isOrderButton();
        assertTrue(createOrderButtonIsDisplayed);
    }
}
