package com.tallence.bddtest.pages;

import de.telekom.test.bddwebapp.frontend.element.WebElementEnhanced;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends AbstractPage {

    @FindBy(id = "nameInput")
    private WebElementEnhanced nameInput;

    @FindBy(id = "submitButton")
    private WebElementEnhanced submitButton;

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getURL() {
        return "";
    }

    public void setNameInput(String name) {
        setInputValue(nameInput,name);
    }

    public void submit() {
        this.submitButton.click();
    }
}
