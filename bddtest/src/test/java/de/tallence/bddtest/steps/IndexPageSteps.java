package de.tallence.bddtest.steps;

import de.tallence.bddtest.config.properties.TestDataProperties;
import de.tallence.bddtest.config.properties.TestProperties;
import de.tallence.bddtest.pages.IndexPage;
import de.telekom.test.bddwebapp.frontend.lifecycle.WebDriverWrapper;
import de.telekom.test.bddwebapp.frontend.steps.SeleniumSteps;
import de.telekom.test.bddwebapp.steps.Steps;
import org.jbehave.core.annotations.Composite;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;

@Steps
public class IndexPageSteps extends SeleniumSteps {
    @Autowired
    protected WebDriverWrapper webDriverWrapper;
    @Autowired
    private TestProperties testProperties;

    @When(value = "enter name $name")
    public void enterName(final String name) {
        IndexPage indexPage = getCurrentPage();
        indexPage.setNameInput(name);
    }

    @When("submit name")
    public void submitName() {
        IndexPage indexPage = getCurrentPage();
        indexPage.submit();
    }

    @When(value = "enter name $name and submit", priority = 1)
    @Composite(steps = {"When enter name <name>", "When submit name"})
    public void enterNameAndSubmit(final String name) {
    }

    @Given("the index page is called")
    public void indexPageCalled() {
        webDriverWrapper.getDriver().get(testProperties.appHostIncludingPort + testProperties.appContextPath);
    }
}
