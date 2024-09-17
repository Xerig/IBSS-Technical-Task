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

import java.util.List;

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
        W.get().driver.findElement(By.linkText("About")).click();
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

    @And("number of {string} is more than {double}")
    public void numberOfIsMoreThan(String numberLabel, double num) {
        String resultsStats = W.get().driver.findElement(By.cssSelector("#result-stats")).getText();
        // Remove brackets and commas from result, split it into an array of single words/numbers
        // using a space delimiter, and then convert it into a List.
        List<String> resultsStatsSplit = List.of(resultsStats.replaceAll("[(),]", "").split(" "));
        int indexOfLabel = resultsStatsSplit.indexOf(numberLabel);
        // Get the number that appears directly before the word describing the number desired.
        double numberFound = Double.parseDouble(resultsStatsSplit.get(indexOfLabel - 1));
        Assert.assertTrue(numberFound > num);
    }

}
