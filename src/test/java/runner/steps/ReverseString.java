package runner.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import exercise1.StringManipulator;
import org.junit.Assert;

public class ReverseString {

    String output;

    @When("^user enters a string \"([^\"]*)\"$")
    public void enterString(String input) throws Throwable {
        StringManipulator stringManipulator = new StringManipulator();
        output = stringManipulator.reverseEverything(input);
    }

    @Then("^output should be a reverse string \"([^\"]*)\"$")
    public void validateReverseString(String expected) throws Throwable {
        Assert.assertTrue(output.equals(expected));
    }
}
