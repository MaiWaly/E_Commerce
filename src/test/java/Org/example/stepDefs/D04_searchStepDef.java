package Org.example.stepDefs;

import Org.example.Pages.P03_homePage;
import io.cucumber.java.Before;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import io.cucumber.messages.types.Hook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class D04_searchStepDef {
    P03_homePage search = new P03_homePage();
    SoftAssert soft;
    String search_text;

    @Given("^user enters ([^\"]*) in search box$")
    public void userEntersProduct_nameInSearchBox(String product_name) {
        search_text = product_name;
        System.out.println(product_name);
        search.searchBox().sendKeys(product_name);
    }

    @When("user clicks search buttons")
    public void clicks_searchbtn() {
        search.search_btn().click();
    }

    @Then("search page is opened")
    public void open_searchPage() {
        String Expected = "https://demo.nopcommerce.com/search?q=";
        soft = new SoftAssert();
        soft.assertTrue(Hooks.myDriver.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q="), "assert of search page ==>Failed");
        soft.assertAll();
    }

    @And("search result is shown")
    public void search_result() {
        List<WebElement> search_elements = search.search_result();
        int size = search_elements.size();
        System.out.println("no of search result are==> " + size);

        for (int i = 0; i <= size - 1; i++) {
            String item_name = search_elements.get(i).getText().toLowerCase();
            System.out.println("search by item name is ==>" + item_name);
            System.out.println("search text is ==>" + search_text);
            soft = new SoftAssert();
            soft.assertTrue(item_name.contains(search_text.toLowerCase()));
            soft.assertAll();
        }
    }

    @And("user clicks the result product")
    public void clicks_result_product() {
        System.out.println("search by sku result is ==>" + search.search_result().get(0).getText());
        search.search_result().get(0).click();

    }

    @Then("product page is opened")
    public void product_page() {
        String actual_sdk = search.search_sdk().getText();
        System.out.println("search sku is ==>" + search_text);
        System.out.println("actual sku is ==>" + actual_sdk);
        soft = new SoftAssert();
        soft.assertTrue(actual_sdk.contains(search_text));
        soft.assertAll();

    }
}
