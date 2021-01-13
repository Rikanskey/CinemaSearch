package bstu.pv.volobuev.CinemaSearch.selenium;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class CinemaSearchApplicationSeleniumTest {

    private WebDriver webDriver;

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
    }

    @AfterEach
    public void tearDown(){
        webDriver.quit();
    }

    @Test
    public void mainPageGetTest(){
        WebElement webElement = webDriver.findElement(By.id("random_button"));
        WebElement webElement1 = webDriver.findElement(By.className("style_top_5__container"));
        assertEquals("Random Movie", webElement.getText());
        assertEquals(5, webElement1.findElements(By.className("styles_posterColumn__width")).size());
    }

    @Test
    public void mainPageRandomButtonClickTest(){
        webDriver.findElement(By.id("random_button")).click();
        WebElement webElement = webDriver.findElement(By.className("styles_title_info__pos"));
        assertEquals("About Movie", webElement.getText());
    }

    @Test
    public void contentPageReadSynopsisTest(){
        webDriver.findElement(By.id("random_button")).click();
        webDriver.findElement(By.id("show_synopsis")).click();
        assertTrue(webDriver.findElement(By.className("styles_synopsis__font")).isDisplayed());
    }

    @Test
    public void authorizationTest(){
        webDriver.findElement(By.className("styles__signIn_Button")).click();
        webDriver.findElement(By.id("inputEmail")).sendKeys(username);
        webDriver.findElement(By.id("inputPassword")).sendKeys(password);
        webDriver.findElement(By.id("sign_in_button")).click();
        assertEquals("Profile", webDriver.findElement(By.id("profile_button")).getText());
    }

    @Test
    public void checkOtherUserProfileTest(){
        webDriver.get(uri + "profile/1");
        assertEquals("testuser", webDriver.findElement(By.className("styles_font__nickname")).getText());
        assertFalse(isElementPresent("btn"));
    }

    private boolean isElementPresent(String webElementClassName){
        try {
            webDriver.findElement(By.className(webElementClassName));
            return true;
        }
        catch (NoSuchElementException e){
            return false;
        }
    }

    @Test
    public void authorizationLogoutTest(){
        webDriver.findElement(By.className("styles__signIn_Button")).click();
        webDriver.findElement(By.id("inputEmail")).sendKeys(username);
        webDriver.findElement(By.id("inputPassword")).sendKeys(password);
        webDriver.findElement(By.id("sign_in_button")).click();
        webDriver.findElement(By.id("logout_button")).click();
        assertEquals("Sign In", webDriver.findElement(By.className("styles__signIn_Button")).getText());
    }

    @Test
    public void userRateTopFirstMovieTest(){
        webDriver.findElement(By.className("styles__signIn_Button")).click();
        webDriver.findElement(By.id("inputEmail")).sendKeys(username);
        webDriver.findElement(By.id("inputPassword")).sendKeys(password);
        webDriver.findElement(By.id("sign_in_button")).click();
        webDriver.findElements(By.className("styles_posterColumn__width")).get(0).click();
        String movieName = webDriver.findElement(By.className("styles_title__pos")).getText();
        webDriver.findElements(By.className("styles_radio__star_container")).get(userRate-1).click();
        webDriver.findElement(By.id("profile_button")).click();
        List<WebElement> userRatedMovies = webDriver.findElements(By.className("styles_item"));
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
        webDriver.findElement(By.className("styles__signIn_Button")).click();
        webDriver.findElement(By.id("inputEmail")).sendKeys(username);
        webDriver.findElement(By.id("inputPassword")).sendKeys(password);
        webDriver.findElement(By.id("sign_in_button")).click();
        webDriver.findElement(By.id("profile_button")).click();
        WebElement webElement = webDriver.findElement(By.className("btn"));
        webElement.click();
        try {
            searchFileInModalWindow(userAvatar);
        }
        catch (AWTException e){
            log.info("Exception: ", e);
        }
        assertEquals("Avatar updated!",
                webDriver.findElement(By.className("styles__avatar_updated_message")).getText());
    }

    private void searchFileInModalWindow(String file) throws AWTException{
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(file), null);
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
    }
}
