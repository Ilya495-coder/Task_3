import checkIn.DriverFactory;
import navigation.NavigationPageObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import signIn.SignInBase;
import signIn.SignInPageObject;

import java.time.Duration;

public class BaseTest {
    NavigationPageObject navigationPageObject;
    WebDriver driver;
    SignInPageObject signInPageObject;
    SignInBase signInBase;


    @BeforeEach
    public void setObject()  {
        driver = new DriverFactory().getDriver();
        driver.get("https://stellarburgers.education-services.ru/");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(d ->
                        ((JavascriptExecutor) d)
                                .executeScript("return document.readyState")
                                .equals("complete"));
        navigationPageObject = new NavigationPageObject(driver);
        signInPageObject = new SignInPageObject(driver);
        signInBase = new SignInBase("test11155@mail.ru", "Вася", "ulaula", driver);

    }

    @AfterEach
    public void exit() {
        driver.quit();

    }
}
