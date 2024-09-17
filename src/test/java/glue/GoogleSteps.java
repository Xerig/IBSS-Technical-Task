package glue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class GoogleSteps {

    @Given("url {string} is launched")
    public void url(String url) {
        W.get().driver.get(url);
        acceptCookiesIfWarned();
    }

    private static void acceptCookiesIfWarned() {
        try {
            W.get().driver.findElement(By.cssSelector("#L2AGLb")).click();
        } catch (NoSuchElementException ignored) {
        }
    }

    @When("About page is shown")
    public void aboutPageIsShown() {
        try {
            W.get().driver.findElement(By.linkText("About")).click();
        } catch (NoSuchElementException ignored) {
        }
    }

    @Then("page displays {string}")
    public void pageDisplays(String textToFind) {
        // Get all text displayed on the page under the body tag
        String allBodyText = W.get().driver.findElement(By.tagName("body")).getText();
        // Check that the page contains the text in the Scenario
        Assert.assertTrue(allBodyText.contains(textToFind));
    }

    @When("searching for {string}")
    public void searchingFor(String query) {
        // Find search textarea
        WebElement textarea = W.get().driver.findElement(By.cssSelector("#APjFqb"));
        // Enter search term
        textarea.sendKeys(query);
        // Send enter to search
        textarea.sendKeys(Keys.RETURN);
    }

    @Then("results contain {string}")
    public void resultsContain(String textToFind) {
        String allBodyText = W.get().driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(allBodyText.contains(textToFind));
    }

    @And("result stats are displayed")
    public void resultStatsAreDisplayed() {
        W.get().driver.findElement(By.cssSelector("#hdtb-tls")).click();
    }



}
