package Org.example.stepDefs;

import Org.example.Pages.P03_homePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class D05_hoverCategoriesStepDef {
    P03_homePage hover=new P03_homePage();

    int selectedCategory;
    List<WebElement> categories_links;
    @Given("user hovers a category")
    public void hover_category() throws InterruptedException {
        D05_hoverCategoriesStepDef hover = new D05_hoverCategoriesStepDef();
        Actions action = new Actions(Hooks.myDriver);

        categories_links = Hooks.myDriver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li"));
//        System.out.println(mainLinks.get(3).getText());
        selectedCategory = generateRandomNumber(0, 6);
        action.moveToElement(categories_links.get(selectedCategory)).perform();
        String selectedCategoryText = categories_links.get(selectedCategory).getText();
        System.out.println("to know which category is selected:   " + selectedCategoryText);
        Thread.sleep(2000);
    }
    @And("user selects subcategory")
    public void select_subcategory() throws InterruptedException {

        selectedCategory = selectedCategory + 1;
        String locator = "(//ul[@class='top-menu notmobile']//ul)[" + selectedCategory + "]/li";
        List<WebElement> subCategoryLinks = Hooks.myDriver.findElements(By.xpath(locator));

        // minimize implicit wait to not waste time if it's empty
        Hooks.myDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        String selectedSubCategoryText;
        if (!subCategoryLinks.isEmpty()) {
            int subCategoryCount = subCategoryLinks.size();
            System.out.println("category link " + subCategoryCount);
            System.out.println(subCategoryLinks.get(0).getText());
            System.out.println(subCategoryLinks.get(1).getText());
            System.out.println(subCategoryLinks.get(2).getText());
            int selectedSubCategory = generateRandomNumber(0, 2);
            selectedSubCategoryText = subCategoryLinks.get(selectedSubCategory).getText();
            subCategoryLinks.get(selectedSubCategory).click();
            // Do your assertion on selected sub category
            String actualSubcategory = selectedSubCategoryText.toLowerCase().trim();
            String page_title = Hooks.myDriver.findElement(By.className("page-title")).getText().toLowerCase().trim();
            System.out.println("page title is ==>" + page_title);
            System.out.println("Selected subcategory is ==> " + actualSubcategory);
            Assert.assertTrue(page_title.contains(actualSubcategory), "assert page title failed");

        } else {
            categories_links.get(selectedCategory-1).click();
            /*String actualMainCategory = categories_links.get(selectedCategory-1).getText().toLowerCase().trim();
            System.out.println("Maaaaaaaaaaain category "+actualMainCategory);
            String page_title = Hooks.myDriver.findElement(By.cssSelector("div[class=\"page-title\"] h1")).getText().toLowerCase().trim();
            Thread.sleep(20000);
            System.out.println("page title is ==>" + page_title);
            System.out.println("Selected MainCategory is ==> " + actualMainCategory);
            Assert.assertTrue(page_title.contains(actualMainCategory), "assert main category page title failed");*/
            // Do your assertion on selected main category
        }

        // reset it to the initial value
        Hooks.myDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }
    public static int generateRandomNumber(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }
}
