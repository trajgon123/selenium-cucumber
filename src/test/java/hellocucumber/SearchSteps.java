package hellocucumber;

import driver.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SearchSteps{
    WebDriver driver;


    @Before
    public void before(){
       this.driver =  WebDriverFactory.createWebDriver();
    }

    @Given("I am on the Home Page")
    public void iAmOnTheHomePage(){
        driver.get("https://czc.cz/");
    }

    @When("I search for {string}")
    public void iSearchForText(String searchText){
        WebElement searchBar = driver.findElement(By.cssSelector("#fulltext"));
        searchBar.sendKeys(searchText);
        searchBar.submit();
    }

    @Then("the page title should contain with {string}")
    public void titleShouldContain(String searchText){
        new WebDriverWait(driver,10L).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().contains(searchText);
            }
        });
    }

    @After
    public void close(){
        this.driver.close();
        this.driver.quit();
    }


}
