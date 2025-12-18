package signIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPageObject {
    WebDriver webDriver;

    public SignInPageObject(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    By lk = By.linkText("Личный Кабинет");
    By buttonSignInMainPage = By.xpath("//button[text()='Войти в аккаунт']");
    By emailField = By.xpath(".//label[normalize-space()='Email']/following-sibling::input[1]");
    By passwordField = By.xpath(".//label[normalize-space()='Пароль']/following-sibling::input[1]");
    By enter = By.xpath(".//*[text()= 'Войти']");
    By resoult = By.xpath(".//h1[text()='Соберите бургер']");
    By registerButton = By.xpath(".//*[text()='Зарегистрироваться']");
    By recoverPassword = By.xpath(".//*[text()='Зарегистрироваться']");


    public void clickLk() {
        WebElement webElement = new WebDriverWait(webDriver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(lk));
        webElement.click();

    }

    public void clickRecoverPassword() {
        WebElement webElement = new WebDriverWait(webDriver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(recoverPassword));
        webElement.click();

    }

    public void clickButtonSignInMainPage() {
        webDriver.findElement(buttonSignInMainPage).click();
    }

    public void setEmailField(String email) {
        WebElement webElement = new WebDriverWait(webDriver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(emailField));
        webElement.click();
        webElement.sendKeys(email);

    }

    public void setPasswordField(String password) {
        WebElement webElement = new WebDriverWait(webDriver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(passwordField));
        webElement.click();
        webElement.sendKeys(password);

    }

    public void clickEnter() {
        WebElement webElement = new WebDriverWait(webDriver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(enter));
        webElement.click();
    }

    public boolean resoult() {
        try {

            WebElement webElement = new WebDriverWait(webDriver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.visibilityOfElementLocated(resoult));
            return webElement.isDisplayed();
        } catch (Exception E) {
            throw new RuntimeException("Пользователь не залогинен");
        }
    }

    public void clickButtonRegister() {
        WebElement webElement = new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(registerButton));
        webElement.click();
    }
}
