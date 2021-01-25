package bstu.pv.volobuev.CinemaSearch.selenium;

import bstu.pv.volobuev.CinemaSearch.selenium.pages.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class CinemaSearchApplicationSeleniumTest {

    private final WebDriver webDriver;

    private MainPage mainPage;

    private final String uri = "http://192.168.3.101:8080/";

    private final String username = "testuser";

    private final String password = "test123";

    private final Integer userRate = 7;

    private final String userAvatar = "D:\\avatar.jpeg";

    public CinemaSearchApplicationSeleniumTest(){
        System.setProperty("webdriver.chrome.driver", "D://ChromeDriver/chromedriver2.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }

    @BeforeEach
    public void setUp(){
        webDriver.get(uri);
        mainPage = new MainPage(webDriver);
    }

    @AfterEach
    public void tearDown(){
        webDriver.quit();
    }

    @Test
    public void mainPageGetTest(){
        WebElement webElement = mainPage.getElementById("random_button");
        WebElement webElement1 = mainPage.getElementByClassName("style_top_5__container");
        assertEquals("Random Movie", webElement.getText());
        assertEquals(5, webElement1.findElements(By.className("styles_posterColumn__width")).size());
    }

    @Test
    public void mainPageRandomButtonClickTest(){
        ContentPage contentPage = mainPage.clickRandomMovieButton();
        WebElement webElement = contentPage.getElementByClassName("styles_title_info__pos");
        assertEquals("About Movie", webElement.getText());
    }

    @Test
    public void contentPageReadSynopsisTest(){
        ContentPage contentPage = mainPage.clickRandomMovieButton();
        contentPage.clickShowSynopsisCheckbox();
        assertTrue(contentPage.getElementByClassName("styles_synopsis__font").isDisplayed());
    }

    @Test
    public void authorizationTest(){
        mainPage = authorization(mainPage, username, password);
        assertEquals("Profile", mainPage.getElementById("profile_button").getText());
    }

    private MainPage authorization(Page page, String username, String password){
        LoginPage loginPage = page.clickSignInButton();
        return loginPage.authenticate(username, password);
    }

    @Test
    public void checkOtherUserProfileTest(){
        webDriver.get(uri + "profile/1");
        ProfilePage profilePage = new ProfilePage(webDriver);
        assertEquals("testuser",
                profilePage.getElementByClassName("styles_font__nickname").getText());
        assertFalse(isElementPresent(profilePage, "btn"));
    }

    private boolean isElementPresent(Page currentPage, String webElementClassName){
        try {
            currentPage.getElementByClassName(webElementClassName);
            return true;
        }
        catch (NoSuchElementException e){
            return false;
        }
    }

    @Test
    public void authorizationLogoutTest(){
        mainPage = authorization(mainPage, username, password);
        mainPage.clickLogoutButton();
        assertEquals("Sign In",
                mainPage.getElementByClassName("styles__signIn_Button").getText());
    }

    @Test
    public void userRateTopFirstMovieTest(){
        mainPage = authorization(mainPage, username, password);
        ContentPage contentPage = mainPage.clickNTopMovie(0);
        String movieName = contentPage.getElementByClassName("styles_title__pos").getText();
        contentPage.rateMovie(userRate);
        ProfilePage profilePage = contentPage.clickProfileButton();
        List<WebElement> userRatedMovies = profilePage.getElementsById("styles_item");
        boolean isRatedMovieInList = false;
        for (WebElement movie : userRatedMovies){
            if (movie.findElement(By.className("styles_profile_list_name")).getText().equals(movieName) &&
                    movie.findElement(By.className("styles_profile_list_mark")).getText().equals(userRate.toString()))
                isRatedMovieInList = true;
        }
        assertTrue(isRatedMovieInList);
    }

    @Test
    public void userUpdateAvatar() {
        mainPage = authorization(mainPage, username, password);
        ProfilePage profilePage = mainPage.clickProfileButton();
        profilePage.updateUserAvatar(userAvatar);
        assertEquals("Avatar updated!",
                profilePage.getElementByClassName("styles__avatar_updated_message").getText());
    }
}
