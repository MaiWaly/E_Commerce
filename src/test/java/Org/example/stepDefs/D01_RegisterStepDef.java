package Org.example.stepDefs;

import Org.example.Pages.P01_register;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class D01_RegisterStepDef {

    P01_register register = new P01_register();

    @Given("user go to register page")
    public void go_Register_Page() {
        register.register_link().click();

    }

    @When("user select gender type")
    public void select_gender_type() throws InterruptedException {
        Thread.sleep(1000);
        register.gender_female().click();

    }

    @And("user enter first name \"automation\" and last name \"tester\"")
    public void enter_first_last_name() throws InterruptedException {
        Thread.sleep(1000);
        register.first_name().sendKeys("automation");
        register.last_name().sendKeys("tester");

    }

    @And("user enter date of birth")
    public void user_enter_birth_date() {
        Select objSelect = new Select(register.date_day());
        objSelect.selectByVisibleText("8");
        Select objSelect2 = new Select(register.date_month());
        objSelect2.selectByIndex(10);
        Select objSelect3 = new Select(register.date_year());
        objSelect3.selectByVisibleText("1998");
    }


    @And("user enter email \"test@example.com\" field")
    public void enter_email() {
        register.e_mail().sendKeys("test@example.com");
    }

    @And("user fills Password fields \"P@ssw0rd\" \"P@ssw0rd\"")
    public void fills_password() {
        register.password().sendKeys("P@ssw0rd");
        register.confirm_password().sendKeys("P@ssw0rd");
    }

    @And("user clicks on register button")
    public void clicks_register_btn() throws InterruptedException {
        Thread.sleep(1000);
        register.register_button().click();
    }

    @Then("success message is displayed")
    public void success_message() {
        String expected = "Your registration completed";
        String actual= register.success_msg().getText();
        System.out.println("the actual messaaaage"+actual);
        SoftAssert soft = new SoftAssert();;
        soft.assertTrue(actual.contains(expected),"failure in 1st assert");
        System.out.println(register.success_msg().getCssValue("Color"));
        soft.assertEquals(register.success_msg().getCssValue("Color"),"rgb(76, 177, 124)");
        soft.assertAll();

    }

}
