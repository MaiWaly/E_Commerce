package Org.example.stepDefs;

import Org.example.Pages.P03_homePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;

public class D06_homeSlidersStepDef {
    P03_homePage slider = new P03_homePage();

    @Given("user clicks the first slider")
    public void clicks_first_slider() {
        slider.first_homeSlider().click();
        System.out.println("First slider is clicked");

    }

    @Then("^user directs to \"(.*)\"$")
    public void directs_toUrl(String url) throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("the actual URL is:==> " + Hooks.myDriver.getCurrentUrl());
        Assert.assertEquals(Hooks.myDriver.getCurrentUrl(), url);
    }

    @Given("user clicks the second slider")
    public void clicks_second_slider() {
        slider.second_homeSlider().click();
        System.out.println("the second slider is clicked");
    }


}



