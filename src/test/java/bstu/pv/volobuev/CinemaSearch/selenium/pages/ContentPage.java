package bstu.pv.volobuev.CinemaSearch.selenium.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContentPage extends Page {
    public ContentPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickShowSynopsisCheckbox(){
        webDriver.findElement(By.id("show_synopsis")).click();
    }

    public void rateMovie(Integer userRate){
        webDriver.findElements(By.className("styles_radio__star_container")).get(userRate-1).click();
    }
}
