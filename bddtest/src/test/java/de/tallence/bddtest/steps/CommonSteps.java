package de.tallence.bddtest.steps;

import de.telekom.test.bddwebapp.frontend.lifecycle.WebDriverWrapper;
import de.telekom.test.bddwebapp.frontend.page.Page;
import de.telekom.test.bddwebapp.frontend.steps.SeleniumSteps;
import de.telekom.test.bddwebapp.steps.Steps;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Then;
import org.springframework.beans.factory.annotation.Autowired;

@Steps
public class CommonSteps extends SeleniumSteps {
    @Autowired
    protected WebDriverWrapper webDriverWrapper;

    @Then("the $pageClassName is shown")
    @Alias("the $pageClassName is shown again")
    public void waitUntilPageIsShown(String pageClassName) {
        try {
            createExpectedPage((Class<? extends Page>) this.getClass().forName("de.tallence.bddtest.pages." + pageClassName));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("A Page class with the given Name does not exist.", e);
        }
    }
}
