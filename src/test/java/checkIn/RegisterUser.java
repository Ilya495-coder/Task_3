package checkIn;

import io.restassured.http.ContentType;
import lombok.Data;
import org.openqa.selenium.WebDriver;

import static io.restassured.RestAssured.given;

@Data
public class RegisterUser {
    String name;
    String email;
    String password;
    WebDriver webDriver;

    public RegisterUser(String email, String name, String password, WebDriver webDriver) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.webDriver = webDriver;
    }

    public boolean registration()  {
        RegistrationPageObject checkInPageObject = new RegistrationPageObject(webDriver);
        checkInPageObject.clickLk();
        checkInPageObject.clickButtonRegister();
        checkInPageObject.setNameField(name);
        checkInPageObject.setEmailField(email);
        checkInPageObject.setPasswordField(password);
        checkInPageObject.clickButtonRegister();
        boolean actual = checkInPageObject.returnResoult();
        return actual;
    }

    public void delete() {
        PostAuthUserPojo postAuthUserPojo = new PostAuthUserPojo(email, password, name);
        String token = given()
                .contentType(ContentType.JSON)
                .body(postAuthUserPojo)
                .when()
                .post("https://stellarburgers.education-services.ru/api/auth/register")
                .then().extract().path("accessToken");
        if (token != null) {
            given()
                    .contentType(ContentType.JSON)
                    .header("authorization", token)
                    .when()
                    .delete("https://stellarburgers.education-services.ru/api/auth/user")
                    .then().statusCode(200);
        }
    }

}
