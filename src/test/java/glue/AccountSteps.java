package glue;

import account.Account;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AccountSteps {

    Account account = null;

    @Given("^Account exists for Acc No\\. \"([^\"]*)\" with Name \"([^\"]*)\"$")
    public void accountExistsForAccNoWithName(String number, String name) {
        Assert.assertEquals(Integer.parseInt(number), account.getNumber());
        Assert.assertEquals(name, account.getName());
    }

    @And("deposits are made")
    public void depositsAreMade() {

    }

    @And("withdrawls are made")
    public void withdrawlsAreMade() {

    }

    @When("statement is produced")
    public void statementIsProduced() {

    }

    @Then("statement includes {string}")
    public void statementIncludes(String arg0) {
    }
}
