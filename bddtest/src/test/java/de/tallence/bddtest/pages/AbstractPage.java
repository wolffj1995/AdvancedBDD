package de.tallence.bddtest.pages;


import de.telekom.test.bddwebapp.frontend.element.WebElementEnhanced;
import de.telekom.test.bddwebapp.frontend.page.JQueryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

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
}
