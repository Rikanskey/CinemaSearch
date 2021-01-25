package bstu.pv.volobuev.CinemaSearch.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Page {
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public LoginPage clickSignInButton() throws NoSuchElementException{
        throw new NoSuchElementException("It's login page yet");
    }

    @Override
    public void clickLogoutButton() throws NoSuchElementException{
        throw new NoSuchElementException("It's sign in page");
    }

    @Override
    public ProfilePage clickProfileButton() throws NoSuchElementException{
        throw new NoSuchElementException("It's sign in page");
    }

    public MainPage authenticate(String username, String password){
        webDriver.findElement(By.id("inputEmail")).sendKeys(username);
        webDriver.findElement(By.id("inputPassword")).sendKeys(password);
        webDriver.findElement(By.id("sign_in_button")).click();
        return new MainPage(webDriver);
    }
}
