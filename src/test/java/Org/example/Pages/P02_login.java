package Org.example.Pages;

import Org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P02_login {

    public WebElement user_login() {
        return Hooks.myDriver.findElement(By.cssSelector("a[href=\"/login?returnUrl=%2F\"]"));

    }
    public WebElement e_mail() {
        return Hooks.myDriver.findElement(By.id("Email"));

    }
    public WebElement password() {
        return Hooks.myDriver.findElement(By.id("Password"));

    }
    public WebElement login_button() {
        return Hooks.myDriver.findElement(By.cssSelector("button[class=\"button-1 login-button\"]"));

    }
    public WebElement myAccount() {
        return Hooks.myDriver.findElement(By.cssSelector("a[href=\"/customer/info\"]"));

    }

    public WebElement failed_msg() {
        return Hooks.myDriver.findElement(By.className("message-error"));

    }
}
