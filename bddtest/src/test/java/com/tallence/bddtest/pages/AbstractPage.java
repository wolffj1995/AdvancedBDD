package com.tallence.bddtest.pages;


import de.telekom.test.bddwebapp.frontend.element.WebElementEnhanced;
import de.telekom.test.bddwebapp.frontend.page.JQueryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.regex.Pattern;

public abstract class AbstractPage extends JQueryPage {


    @FindBy(tagName = "body")
    public WebElementEnhanced body;

    public AbstractPage(WebDriver driver) {
        super(driver);
    }

    public boolean bodyMatchesRegex(final String regex, int flags) {
        Pattern pattern = Pattern.compile(regex, flags);
        String bodyText = this.body.getText();
        return pattern.matcher(bodyText).find();
    }

    protected void setInputValue(WebElement inputWebElement, String value) {
        while (!ExpectedConditions.textToBePresentInElementValue(inputWebElement, value).apply(this.driver)) {
            inputWebElement.click();
            inputWebElement.clear();
            inputWebElement.sendKeys(value);
        }
    }
}
