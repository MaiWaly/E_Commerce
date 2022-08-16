package Org.example.Pages;

import Org.example.stepDefs.Hooks;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P01_register {
    public WebElement register_link() {
        return Hooks.myDriver.findElement(By.className("ico-register"));
    }

    public WebElement gender_female() {
        return Hooks.myDriver.findElement(By.id("gender-female"));
    }
    public WebElement first_name() {
        return Hooks.myDriver.findElement(By.id("FirstName"));
    }
    public WebElement last_name() {
        return Hooks.myDriver.findElement(By.id("LastName"));
    }
    public WebElement date_day() {
        return Hooks.myDriver.findElement(By.name("DateOfBirthDay"));
    }
    public WebElement date_month() {
        return Hooks.myDriver.findElement(By.name("DateOfBirthMonth"));
    }
    public WebElement date_year() {
        return Hooks.myDriver.findElement(By.name("DateOfBirthYear"));
    }
    public WebElement e_mail() {
        return Hooks.myDriver.findElement(By.id("Email"));
    }
    public WebElement password() {
        return Hooks.myDriver.findElement(By.id("Password"));
    }
    public WebElement confirm_password() {
        return Hooks.myDriver.findElement(By.id("ConfirmPassword"));
    }
    public WebElement register_button() {
        return Hooks.myDriver.findElement(By.id("register-button"));
    }

    public WebElement success_msg() {
        return Hooks.myDriver.findElement(By.className("result"));
    }
}

