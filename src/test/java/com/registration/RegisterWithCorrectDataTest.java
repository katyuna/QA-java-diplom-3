package com.registration;

import com.BaseTest;
import com.model.User;
import com.po.LoginPage;
import com.po.MainPage;
import com.po.RegisterPage;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RegisterWithCorrectDataTest extends BaseTest {

    @Test
    @DisplayName("Успешная регистрация нового пользователя")
    public void testLoginButtonDisplayedAfterRegistration() {

        //ARRANGE
        //Создать экземпляры страниц
        MainPage mainPage = page(MainPage.class);
        RegisterPage registerPage = page(RegisterPage.class);
        LoginPage loginPage = page(LoginPage.class);
        //Сгенерировать пользователя
        User user = User.getRandomUser();

        //ACT
        //Перейти по страницам на регистрацию
        mainPage.buttonAccount.click();
        loginPage.linkRegister.click();
        //Заполнить форму регистрации
        registerPage.fillForm(user.getName(), user.getEmail(), user.getPassword());
        //Подождать пока кнопка Логина появится (страница загрузится)
        loginPage.buttonLogin.shouldBe(enabled);

        //ASSERT
        //Проверить, что отображается кнопка Логина
        boolean isLoginButtonDisplayed = loginPage.isLoginButton();
        assertTrue("Не произошел переход на страницу логина после регистрации",isLoginButtonDisplayed);
    }
}