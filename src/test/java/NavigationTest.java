
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import signIn.SignInBase;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NavigationTest extends BaseTest {

    @DisplayName("Переход по клику на «Личный кабинет»")
    @Test
    public void checkClickLk() throws Exception {
        navigationPageObject.clickLk();
        boolean resoult = navigationPageObject.returnResoultEnter();
        assertTrue(resoult);
    }

    @DisplayName("Переход по клику на «Конструктор»")
    @Test
    public void checkClickConstructor() throws Exception {
        navigationPageObject.clickLk();
        navigationPageObject.clickConstructor();
        boolean resoult = navigationPageObject.returnResoultMainPage();
        assertTrue(resoult);
    }

    @DisplayName("Переход по клику на «бургер»")
    @Test
    public void checkClickBurger() throws Exception {
        navigationPageObject.clickLk();
        navigationPageObject.clickBurger();
        boolean resoult = navigationPageObject.returnResoultMainPage();
        assertTrue(resoult);
    }

    @DisplayName("Выход по кнопке «Выйти» в личном кабинете")
    @Test
    public void checkClickButtonExit() throws Exception {
        SignInBase signInBase = new SignInBase("test11155@mail.ru", "Вася", "ulaula", driver);
        navigationPageObject.clickLk();
        //заполняем форму и получаем результат
        signInBase.signInMainPage();
        navigationPageObject.clickLk();
        navigationPageObject.clickExit();
        boolean resoult = navigationPageObject.returnResoultEnter();
        assertTrue(resoult);

    }

    @DisplayName("переходы к разделу «Соусы»")
    @Test
    public void checkSous() {
        navigationPageObject.clickFieldSous();
    }

    @DisplayName("переходы к разделу «Булки»")
    @Test
    public void checkBread() throws InterruptedException {
        navigationPageObject.clickFieldNachinka();
        navigationPageObject.clickFieldBread();

    }

    @DisplayName("переходы к разделу «Начинки»")
    @Test
    public void checkNachinka() {
        navigationPageObject.clickFieldNachinka();

    }
}
