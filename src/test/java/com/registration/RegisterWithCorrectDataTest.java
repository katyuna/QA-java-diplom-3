package com.registration;

import com.BaseTest;
import com.model.User;
import com.po.LoginPage;
import com.po.MainPage;
import com.po.RegisterPage;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class RegisterWithCorrectDataTest extends BaseTest {

    @Test
    @DisplayName("Успешная регистрация нового пользователя")
    public void testRegistrationIsOk() {
        //Создать экземпляры страниц
        MainPage mainPage = page(MainPage.class);
        RegisterPage registerPage = page(RegisterPage.class);
        LoginPage loginPage = page(LoginPage.class);

        //Сгенерировать пользователя
        User user = User.getRandomUser();

        //Перейти по страницам на регистрацию
        mainPage.buttonAccount.click();
        loginPage.linkRegister.click();

        //Заполнить форму регистрации
        registerPage.fillForm(user.getName(), user.getEmail(), user.getPassword());

        //Проверить по заголовку "Вход", что после регистрации произошел переход на страницу логина
        $(byXpath("//div[@class='Auth_login__3hAey']//h2")).shouldHave(exactText("Вход"));
    }
}
