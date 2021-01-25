package bstu.pv.volobuev.CinemaSearch.selenium.pages;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PROTECTED, makeFinal = true)
public class Page {
    WebDriver webDriver;

    public Page(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public WebElement getElementById(String elementId) throws NoSuchElementException {
        return webDriver.findElement(By.id(elementId));
    }

    public List<WebElement> getElementsById(String elementId) throws NoSuchElementException{
        return webDriver.findElements(By.className("styles_item"));
    }

    public WebElement getElementByClassName(String elementClassName) throws NoSuchElementException {
        return webDriver.findElement(By.className(elementClassName));
    }

    public LoginPage clickSignInButton() throws NoSuchElementException{
        webDriver.findElement(By.className("styles__signIn_Button")).click();
        return new LoginPage(webDriver);
    }

    public void clickLogoutButton() throws NoSuchElementException{
        webDriver.findElement(By.id("logout_button")).click();
    }

    public ProfilePage clickProfileButton() throws NoSuchElementException{
        webDriver.findElement(By.id("profile_button")).click();
        return new ProfilePage(webDriver);
    }
}
