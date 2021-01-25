package bstu.pv.volobuev.CinemaSearch.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class ProfilePage extends Page {
    public ProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void updateUserAvatar(String userAvatar){
        webDriver.findElement(By.className("btn")).click();
        try {
            searchFileInModalWindow(userAvatar);
        }
        catch (AWTException ignored){
        }
    }

    private void searchFileInModalWindow(String file) throws AWTException {
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
