package navigation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavigationPageObject {
    WebDriver webDriver;

    public NavigationPageObject(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    By lk = By.linkText("Личный Кабинет");
    By constructor = By.linkText("Конструктор");
    By stellarBurger = By.xpath("//*[name()='svg']");
    By resoult = By.xpath(".//h1[text()='Соберите бургер']");
    By resoultEnter = By.xpath("//*[@id='root']/div/main/div/h2[text()='Вход']");
    By buttonNachinka = By.cssSelector(".tab_tab__1SPyG:nth-child(3)");
    By buttonSous = By.cssSelector(".tab_tab__1SPyG:nth-child(2)");
    By buttonBread = By.cssSelector(".tab_tab__1SPyG:nth-child(1)");
    By exit = By.xpath(".//*[text()= 'Выход']");
    By fieldNachinka = By.xpath(".//div/h2[contains(.,'Начинки')]");
    By fieldSous = By.xpath(".//div/h2[contains(.,'Соусы')]");
    By fieldBread = By.xpath(".//div/h2[contains(.,'Булки')]");

//    public boolean visitbilityFieldNachinka() {
//        WebElement webElement = new WebDriverWait(webDriver, Duration.ofSeconds(5))
//                .until(ExpectedConditions.visibilityOfElementLocated(fieldNachinka));
//        return webElement.isDisplayed();
//    }

    public void clickFieldNachinka() {
        WebElement webElement = new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(buttonNachinka));
        webElement.click();
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.attributeContains(buttonNachinka, "class", "current"));
    }

//    public boolean visitbilityFieldSous() {
//        WebElement webElement = new WebDriverWait(webDriver, Duration.ofSeconds(5))
//                .until(ExpectedConditions.visibilityOfElementLocated(fieldSous));
//        return webElement.isDisplayed();
//    }

    public void clickFieldSous() {
        WebElement webElement = new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(buttonSous));
        webElement.click();
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.attributeContains(buttonSous, "class", "current"));
    }

//    public boolean visitbilityFieldBread() {
//        WebElement webElement = new WebDriverWait(webDriver, Duration.ofSeconds(5))
//                .until(ExpectedConditions.visibilityOfElementLocated(fieldBread));
//        return webElement.isDisplayed();
//    }

    public void clickFieldBread() {
        WebElement webElement = new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(buttonBread));
        webElement.click();
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.attributeContains(buttonBread, "class", "current"));
    }


    public void clickLk() {
        WebElement webElement = new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(lk));
        webElement.click();

    }

    public void clickExit() {
        WebElement webElement = new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(exit));
        webElement.click();

    }

    public void clickBurger() {
        WebElement webElement = new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(stellarBurger));
        webElement.click();

    }

    public void clickConstructor() {
        WebElement webElement = new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(constructor));
        webElement.click();

    }

    public boolean returnResoultMainPage() {
        try {

            WebElement webElement = new WebDriverWait(webDriver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.visibilityOfElementLocated(resoult));
            return webElement.isDisplayed();
        } catch (Exception E) {
            throw new RuntimeException("Пользователь не попал на главную страницу");
        }
    }

    public boolean returnResoultEnter() throws Exception {
        try {
            WebElement webElement = new WebDriverWait(webDriver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.visibilityOfElementLocated(resoultEnter));
            return webElement.isDisplayed();
        } catch (Exception e) {
            throw new RuntimeException("Пользователь не попал в личный кабинет");
        }
    }
}
