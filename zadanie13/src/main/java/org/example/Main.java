package org.example;
import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Main {

    @Test
    public void successfulLogin() {
        //Открываем сайт Стройпарка и расширяем окно на весь экран
        open("https://stroyparkdiy.ru/");
        getWebDriver().manage().window().maximize();

        //Закрываем всплывающее объявление
        $(".mobapp_popup__close.js-mobapp_popup-trigger").click();

        //Находим кнопку "Войти"
        $(".sp-header__user-avatar").hover();
        $(".use-ajax.ajax-processed").click();

        //Вводим данные для авторизации и выполняем вход
        $("#edit-mail--2").setValue("alisa20053105@gmail.com");
        $("#edit-password").setValue("zadanie1BFT");
        $("#edit-submit--4").click();

        //Проверка правильности выполнения теста: наличие кнопки "Выход"
        $(".sp-header__user-avatar").hover();
        $("li.o-logout").shouldBe(Condition.visible);

        //Закрываем браузер
        Selenide.closeWebDriver();
    }
}