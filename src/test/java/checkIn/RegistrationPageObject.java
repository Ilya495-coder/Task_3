package checkIn;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class RegistrationPageObject {

    WebDriver webDriver;

    public RegistrationPageObject(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    By lk = By.linkText("Личный Кабинет");
    By registerButton = By.xpath(".//*[text()='Зарегистрироваться']");
    By passwordField = By.xpath(".//label[normalize-space()='Пароль']/following-sibling::input[1]");
    By nameField = By.xpath(".//label[normalize-space()='Имя']/following-sibling::input[1]");
    By emailField = By.xpath(".//label[normalize-space()='Email']/following-sibling::input[1]");
    By resoult = By.xpath("//*[@id='root']/div/main/div/h2[text()='Вход']");

    public void clickLk() {
        webDriver.findElement(lk).click();

    }

    public void setEmailField(String email) {
        WebElement webElement = new WebDriverWait(webDriver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(emailField));
        webElement.click();
        webElement.sendKeys(email);
    }

    public void clickButtonRegister() {
        WebElement webElement = new WebDriverWait(webDriver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(registerButton));
        webElement.click();
    }

    public void setPasswordField(String password) {
        webDriver.findElement(passwordField).sendKeys(password);
    }

    public void setNameField(String name) {
        webDriver.findElement(nameField).sendKeys(name);
    }


    public boolean returnResoult() {
        try {
            new WebDriverWait(webDriver, Duration.ofSeconds(1))
                    .until(ExpectedConditions.visibilityOfElementLocated(resoult));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
