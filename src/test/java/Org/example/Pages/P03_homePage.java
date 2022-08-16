package Org.example.Pages;

import Org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P03_homePage {
    //currency elements
    public WebElement currency_list() {
        return Hooks.myDriver.findElement(By.id("customerCurrency"));
    }


    public List<WebElement> products_prices() {

        return Hooks.myDriver.findElements(By.className("price"));
    }

    //hover categories elements

    public List<WebElement> categories() {

        return Hooks.myDriver.findElements(By.className("top-menu"));
    }

    //home slider elements
    public WebElement first_homeSlider() {
        return Hooks.myDriver.findElement(By.cssSelector("a[rel=\"0\"]"));
    }

    public WebElement second_homeSlider() {
        return Hooks.myDriver.findElement(By.cssSelector("a[rel=\"1\"]"));
    }

    public WebElement facebook() {
        return Hooks.myDriver.findElement(By.cssSelector("a[href=\"http://www.facebook.com/nopCommerce\"]"));
    }

    public WebElement twitter() {
        return Hooks.myDriver.findElement(By.cssSelector("a[href=\"https://twitter.com/nopCommerce\"]"));
    }

    public WebElement rss() {
        return Hooks.myDriver.findElement(By.cssSelector("a[href=\"/news/rss/1\"]"));
    }

    public WebElement youtube() {
        return Hooks.myDriver.findElement(By.cssSelector("a[href=\"http://www.youtube.com/user/nopCommerce\"]"));
    }

    public WebElement wishlistIcon() {
        return Hooks.myDriver.findElement(By.xpath("//div[@data-productid=\"18\"]//button[@title=\"Add to wishlist\"]"));
    }

    public WebElement succeedmsg() {
        return Hooks.myDriver.findElement(By.cssSelector("p[class=\"content\"]"));
    }

    public WebElement succeed_msg_bar() {
        return Hooks.myDriver.findElement(By.xpath("//div[@class=\"bar-notification success\"]\n"));
    }

    public WebElement wishList_lbl() {
        return Hooks.myDriver.findElement(By.cssSelector("span[class=\"wishlist-label\"]"));
    }

    public WebElement wishList_close() {
        return Hooks.myDriver.findElement(By.cssSelector("span[title=\"Close\"]"));
    }

    public WebElement searchBox() {
        return Hooks.myDriver.findElement(By.cssSelector("input[id=\"small-searchterms\"]"));
    }

    public WebElement search_btn() {
        return Hooks.myDriver.findElement(By.className("button-1"));
    }

    public List<WebElement> search_result() {
        return Hooks.myDriver.findElements(By.cssSelector("div[class=\"item-box\"]"));

    }

    public WebElement search_sdk() {
        return Hooks.myDriver.findElement(By.cssSelector("div[class=\"sku\"]"));


    }
}
