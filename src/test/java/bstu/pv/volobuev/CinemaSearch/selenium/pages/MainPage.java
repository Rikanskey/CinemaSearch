package bstu.pv.volobuev.CinemaSearch.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends Page {
    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ContentPage clickNTopMovie(Integer movieNumber){
        webDriver.findElements(By.className("styles_posterColumn__width")).get(movieNumber).click();
        return new ContentPage(webDriver);
    }

    public ContentPage clickRandomMovieButton(){
        webDriver.findElement(By.id("random_button")).click();
        return new  ContentPage(webDriver);
    }
}
