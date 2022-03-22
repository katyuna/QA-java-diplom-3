package com.registration;

import com.BaseTest;
import com.model.User;
import com.po.LoginPage;
import com.po.MainPage;
import com.po.RegisterPage;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class RegisterWithIncorrectPasswordTest extends BaseTest {
    @Test
    @DisplayName("Регистрация пользователя с некоррекным паролем")
    public void testErrorMessageDisplayedAfterRegistrationWithIncorrectPassword() {

        //ARRANGE
        //Создать экземпляры страниц
        MainPage mainPage = page(MainPage.class);
        RegisterPage registerPage = page(RegisterPage.class);
        LoginPage loginPage = page(LoginPage.class);
        //Сгенерировать пользователя с некоррекным паролем
        User user = User.getRandomUserIncorrectPassword();

        //ACT
        //Перейти по страницам на регистрацию
        mainPage.buttonAccount.click();
        loginPage.linkRegister.click();
        //Заполнить форму регистрации
        registerPage.fillForm(user.getName(), user.getEmail(), user.getPassword());

        //ASSERT
        //Проверить, что показано сообщение о неверном пароле
        boolean errorMessageIsDisplayed = registerPage.isErrorMessage();
        assertTrue("Нет сообщения об ошибке ввода пароля", errorMessageIsDisplayed);
    }
}
