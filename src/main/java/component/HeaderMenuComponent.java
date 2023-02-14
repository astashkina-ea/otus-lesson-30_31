package component;

import data.menu.HeaderMenuItemDate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderMenuComponent extends AbsBaseComponent{

    public HeaderMenuComponent(WebDriver driver) {
        super(driver);
    }



    public HeaderMenuComponent moveCursorToHeaderItem(HeaderMenuItemDate headerMenuItemDate) {
        String selector = String.format("[data-name='%s'].header3__nav-item", headerMenuItemDate.getName());

        actions
                .moveToElement($(By.cssSelector(selector)))
                .build()
                .perform();

        return this;
    }
}

