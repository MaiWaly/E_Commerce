package Org.example.stepDefs;
import Org.example.Pages.P03_homePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public class D08_WishlistStepDef {
    P03_homePage wish = new P03_homePage();
    SoftAssert soft;
    @Given("user clicks wishlist icon")
    public void clicks_wishlist_icon() {

        wish.wishlistIcon().click();
    }

    @Then("successful message is displayed")
    public void succeed_msg_displayed() {
        soft=new SoftAssert();
        String actual_message = wish.succeed_msg_bar().getText();
        System.out.println("actual Successful message is ==> " + actual_message);
        String expected ="The product has been added to your wishlist";
        soft.assertTrue(actual_message.contains(expected),"Successful message assertion is ==>Failed");
        String color = wish.succeed_msg_bar().getCssValue("background-color");
        System.out.println("RGBA color value is==>" + color);
        String hex = Color.fromString(color).asHex();
        System.out.println("Hex value is ==>" + hex);
        soft.assertEquals(hex, "#4bb07a");
        soft.assertAll();
    }

    @When("wishlist tab is clickable")
    public void clicks_wishlist_tab() {
        wish.wishList_close().click();
        WebDriverWait wait = new WebDriverWait(Hooks.myDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(wish.wishList_lbl()));
        wish.wishList_lbl().click();

    }

    @And("qty value got increased more then 0")
    public void open_wishlist_tab() {
        soft=new SoftAssert();
        String count = Hooks.myDriver.findElement(By.className("qty-input")).getAttribute("value");
        int countint = Integer.parseInt(count);
        System.out.println("the quantity value is==> " + countint);
        Assert.assertTrue(countint > 0, "Assert quantity failed");
        soft.assertAll();
    }


}

