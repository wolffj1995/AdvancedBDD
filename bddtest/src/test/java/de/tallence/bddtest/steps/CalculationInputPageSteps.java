package de.tallence.bddtest.steps;

import de.tallence.bddtest.pages.CalculationInputPage;
import de.telekom.test.bddwebapp.frontend.lifecycle.WebDriverWrapper;
import de.telekom.test.bddwebapp.frontend.steps.SeleniumSteps;
import de.telekom.test.bddwebapp.steps.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

@Steps
public class CalculationInputPageSteps extends SeleniumSteps {
    @Autowired
    protected WebDriverWrapper webDriverWrapper;

    @When("input field 1 $value")
    public void inputField1(final String value) {
        CalculationInputPage calculationInputPage = getCurrentPage();
        calculationInputPage.setValue1Input(value);
    }

    @When("input field 2 $value")
    public void inputField2(final String value) {
        CalculationInputPage calculationInputPage = getCurrentPage();
        calculationInputPage.setValue2Input(value);
    }

    @When("input field 3 $value")
    public void inputField3(final String value) {
        CalculationInputPage calculationInputPage = getCurrentPage();
        calculationInputPage.setValue3Input(value);
    }

    @When("submit fields")
    public void submitFields() {
        CalculationInputPage calculationInputPage = getCurrentPage();
        calculationInputPage.submit();
    }

    @Then("the name matches $name on inputPage")
    public void nameMatches(final String name) {
        CalculationInputPage calculationInputPage = getCurrentPage();
        assertTrue(calculationInputPage.nameMatches(Pattern.compile(name)));
    }

}
