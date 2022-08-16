package Org.example.stepDefs;

import Org.example.Pages.P02_login;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

public class D02_LogInStepDef {
    P02_login login = new P02_login();
    SoftAssert soft;

    @Given("user go to login page")
    public void user_login_page() {

        login.user_login().click();
    }

    @When("^user login with \"(.*)\" \"(.*)\" and \"(.*)\"$")
    public void user_login(String type, String userName, String password) throws InterruptedException {
        Thread.sleep(2000);
        login.e_mail().sendKeys(userName);
        login.password().sendKeys(password);
    }

    @And("user press on login button")
    public void press_login_button() {

        login.login_button().click();

    }

    @Then("user login to the system successfully")
    public void login_succeed() {

        soft = new SoftAssert();
        soft.assertEquals("https://demo.nopcommerce.com/", Hooks.myDriver.getCurrentUrl());
        soft.assertTrue(login.myAccount().isDisplayed(), "My account tab is not displayed");
        System.out.println("successful login is done " + Hooks.myDriver.getCurrentUrl());
        soft.assertAll();

    }

    @Then("user could not login to the system")
    public void login_failed() {
        soft = new SoftAssert();
        String actual = login.failed_msg().getText();
        System.out.println("the actual failed msg " + actual);
        soft.assertTrue(actual.contains("Login was unsuccessful."), "failed msg assert is faaaaaaaaaaaaild");
        soft.assertEquals(login.failed_msg().getCssValue("Color"), "rgb(228, 67, 75)");
        System.out.println(login.failed_msg().getCssValue("Color"));
        soft.assertAll();

    }
}


