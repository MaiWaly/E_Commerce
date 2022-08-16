package Org.example.stepDefs;

import Org.example.Pages.P03_homePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.messages.types.Hook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;

public class D07_followUsStepDef {
    P03_homePage follow = new P03_homePage();

    @Given("user opens facebook link")
    public void opens_facebook() {
        //1- click on facebook
        follow.facebook().click();
    }

    @Given("user opens twitter link")
    public void opens_twitter() {
        follow.twitter().click();
    }

    @Given("user opens rss link")
    public void opens_rss() {
        follow.rss().click();
    }

    @Given("user opens youtube link")
    public void opens_youtube() {
        follow.youtube().click();
    }

    @Then("^\"(.*)\" is opened in new tab$")
    public void open_newTab(String url) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(Hooks.myDriver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        //2- get window list inside array
        ArrayList<String> tabs = new ArrayList<>(Hooks.myDriver.getWindowHandles());
        System.out.println(tabs.size());

        //3- switch from tab 0 to tab 1
        Hooks.myDriver.switchTo().window(tabs.get(1));
        System.out.println("tab 1:actual url==>   " + Hooks.myDriver.getCurrentUrl());
        System.out.println("tab 1:Expected url==>   " + url);
        Assert.assertEquals(Hooks.myDriver.getCurrentUrl(),url);

        //4- switch from tab 1 to tab 0
        Hooks.myDriver.switchTo().window(tabs.get(0));
        System.out.println("tab 0:  " + Hooks.myDriver.getCurrentUrl());
        Hooks.myDriver.close();


        // reload
        tabs = new ArrayList<>(Hooks.myDriver.getWindowHandles());
    }
}

