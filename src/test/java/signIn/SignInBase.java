package signIn;

import org.openqa.selenium.WebDriver;

public class SignInBase {
    String name;
    String email;
    String password;
    WebDriver webDriver;

    public SignInBase(String email, String name, String password, WebDriver webDriver) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.webDriver = webDriver;
    }

    public Boolean signInMainPage() {
        SignInPageObject signInPageObject = new SignInPageObject(webDriver);
        signInPageObject.setEmailField(email);
        signInPageObject.setPasswordField(password);
        signInPageObject.clickEnter();
        boolean resoult = signInPageObject.resoult();
        return resoult;
    }
}
