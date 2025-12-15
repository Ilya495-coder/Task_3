import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SignInTest extends BaseTest {

    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    @Test
    public void signInMain() throws Exception {
        //кликаем на кнопку войти в аккаунт
        signInPageObject.clickButtonSignInMainPage();
        //заполняем форму и получаем результат
        boolean actual = signInBase.signInMainPage();
        assertTrue(actual);

    }

    @DisplayName("Вход через кнопку в форме регистрации")
    @Test
    public void signInFormRegistration() throws Exception {
        //кликаем на кнопку личный кабинет
        signInPageObject.clickLk();
        //кликаем на кнопку зарегистрироваться
        signInPageObject.clickButtonRegister();
        //кликаем на кнопку войти
        signInPageObject.clickEnter();
        //заполняем форму и получаем результат
        boolean actual = signInBase.signInMainPage();
        assertTrue(actual);

    }

    @DisplayName("Вход через кнопку «Личный кабинет»")
    @Test
    public void signInForButtonLk() throws Exception {
        //кликаем на кнопку личный кабинет
        signInPageObject.clickLk();
        //заполняем форму и получаем результат
        boolean actual = signInBase.signInMainPage();
        assertTrue(actual);
    }

    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Test
    public void signInRecoverPassword() throws Exception {
        //кликаем на кнопку личный кабинет
        signInPageObject.clickLk();
        //кликаем на кнопку восстановить пароль
        signInPageObject.clickRecoverPassword();
        //кликаем на кнопку войти
        signInPageObject.clickEnter();
        //заполняем форму и получаем результат
        boolean actual = signInBase.signInMainPage();
        assertTrue(actual);
//
    }

}
