import checkIn.RegisterUser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


public class RegistrationTest extends BaseTest {
    String name = "Вася";
    String email = UUID.randomUUID().toString() + "@mail.ru";
    String password = UUID.randomUUID().toString();

    @DisplayName("Положительный кейс. Успешная регистрация")
    @Test
    public void register() throws Exception {
        RegisterUser registerUser = new RegisterUser(email, name, password, driver);
        boolean actual = registerUser.registration();
        assertTrue(actual);
        registerUser.delete();
    }

    @DisplayName("Положительный кейс. Успешная регистрация с паролем 6 символов")
    @Test
    public void registerWithPassword6Char() throws Exception {
        RegisterUser registerUser = new RegisterUser(email, name, "123456", driver);
        boolean actual = registerUser.registration();
        assertTrue(actual);
        registerUser.delete();
    }

    @DisplayName("Негативный кейс. Регистрация с паролем 5 символов")
    @Test
    public void registerWithPassword5Char() throws Exception {
        RegisterUser registerUser = new RegisterUser(email, name, "12345", driver);
        assertFalse(registerUser.registration());
    }
}
