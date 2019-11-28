package com.tallence.bddtest.pages;

import de.telekom.test.bddwebapp.frontend.element.WebElementEnhanced;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.regex.Pattern;

public class CalculationResultPage extends AbstractPage {

    @FindBy(id = "name")
    private WebElementEnhanced name;
    @FindBy(id = "result")
    private WebElementEnhanced result;

    public CalculationResultPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getURL() {
        return "/calculation-result.html";
    }

    public boolean nameMatches(Pattern pattern) {
        return pattern.matcher(name.getText()).find();
    }

    public boolean resultMatches(Pattern pattern) {
        return pattern.matcher(result.getText()).find();
    }

    public boolean resultEquals(final String expected) {
        return expected.equals(result.getText());
    }

    public String getResultText() {
        return result.getText();
    }
}
