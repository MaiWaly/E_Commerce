package Org.example.stepDefs;
import Org.example.Pages.P03_homePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class D03_currenciesStepDef {

    P03_homePage currency=new P03_homePage();

    @Given("user switches currency list to Euro")
    public void opens_currency_list() {
        Select objSelect = new Select(currency.currency_list());
        objSelect.selectByVisibleText("Euro");
    }

    @Then("4 products switch to Euro")
    public void products_switch_Euro() throws InterruptedException {
        for (int i = 0; i <= 3; i++) {
            String elements = currency.products_prices().get(i).getText();
            System.out.println("List of prices " + elements);
            Assert.assertTrue(elements.contains("€"), "Euro currency assert failed");
        }
    }



}
