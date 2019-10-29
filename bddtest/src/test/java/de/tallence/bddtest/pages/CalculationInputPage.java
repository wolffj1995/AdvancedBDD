package de.tallence.bddtest.pages;

import de.telekom.test.bddwebapp.frontend.element.WebElementEnhanced;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Pattern;

public class CalculationInputPage extends AbstractPage {

    @FindBy(id = "name")
    private WebElementEnhanced name;
    @FindBy(id = "value1Input")
    private WebElementEnhanced value1Input;
    @FindBy(id = "value2Input")
    private WebElementEnhanced value2Input;
    @FindBy(id = "value3Input")
    private WebElementEnhanced value3Input;
    @FindBy(id = "submitButton")
    private WebElementEnhanced submitButton;

    public CalculationInputPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getURL() {
        return "/calculation-input.html";
    }

    public void setValue1Input(String value1Input) {

        if (!this.value1Input.isDisplayed())
            new WebDriverWait(this.driver, 60L).until((webDriver) -> this.value1Input.isDisplayed());
        this.value1Input.setValue(value1Input);
    }

    public void setValue2Input(String value2Input) {
        if (!this.value2Input.isDisplayed())
            new WebDriverWait(this.driver, 60L).until((webDriver) -> this.value2Input.isDisplayed());
        this.value2Input.setValue(value2Input);
    }

    public void setValue3Input(String value3Input) {
        if (!this.value3Input.isDisplayed())
            new WebDriverWait(this.driver, 60L).until((webDriver) -> this.value3Input.isDisplayed());
        this.value3Input.setValue(value3Input);
    }

    public void submit() {
        if (!this.submitButton.isDisplayed())
            new WebDriverWait(this.driver, 60L).until((webDriver) -> this.submitButton.isDisplayed());
        this.submitButton.click();
    }

    public boolean nameMatches(Pattern pattern) {
        return pattern.matcher(name.getText()).find();
    }
}
