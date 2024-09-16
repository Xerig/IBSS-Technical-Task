package glue;

import account.Account;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class AccountSteps {

    Account account = null;

    @Given("^Account exists for Acc No\\. \"([^\"]*)\" with Name \"([^\"]*)\"$")
    public void accountExistsForAccNoWithName(int number, String name) {
        account = new Account(number,name);
        Assert.assertEquals(number, account.getNumber());
        Assert.assertEquals(name, account.getName());
    }

    @And("deposits are made")
    public void depositsAreMade(DataTable data) {
        List<List<String>> exampleDataTable = data.asLists();
        for (List<String> row : exampleDataTable) {
            // Row 0 is transaction ID, row 1 is deposit amount
            account.deposit(row.get(0), Integer.parseInt(row.get(1)));
        }
    }

    @And("withdrawls are made")
    public void withdrawlsAreMade(DataTable data) {
        List<List<String>> exampleDataTable = data.asLists();
        for (List<String> row : exampleDataTable) {
            // Row 0 is transaction ID, row 1 is withdrawal amount
            account.withdraw(row.get(0),Integer.parseInt(row.get(1)));
        }
    }

    @When("statement is produced")
    public void statementIsProduced() {
        account.statement();
    }

    @Then("statement includes {string}")
    public void statementIncludes(String arg0) {

    }
}
