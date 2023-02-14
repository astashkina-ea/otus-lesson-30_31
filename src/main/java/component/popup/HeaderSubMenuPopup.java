package component.popup;

import component.AbsBaseComponent;
import data.menu.HeaderMenuItemDate;
import data.menu.ISubMenu;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Locale;

public class HeaderSubMenuPopup extends AbsBaseComponent implements ISubMenuPopup {

    public HeaderSubMenuPopup(WebDriver driver) {
        super(driver);
    }

    private String headerSubmenuPopupSelector = "[data-name='%s'].js-header3-popup";
    private String subMenuItemByNameLocator = "(//*[contains(@class, 'header3__nav-item-popup-content')]//a[contains(@href, '%s')])[1]";

    @Override
    public void popupShouldNotBeVisible(HeaderMenuItemDate headerMenuItemDate) {
        String selector = String.format(headerSubmenuPopupSelector, headerMenuItemDate.getName());
        Assertions.assertTrue(webDriverWait.waitForCondition(
                ExpectedConditions.attributeContains($(By.cssSelector(selector)),
                        "style", "none"))
                , String.format("Popup %s should not be visible", headerMenuItemDate.getName()));
    }

    @Override
    public void popupShouldBeVisible(HeaderMenuItemDate headerMenuItemDate) {
        String selector = String.format(headerSubmenuPopupSelector, headerMenuItemDate.getName());
        Assertions.assertTrue(webDriverWait.waitForCondition(
                ExpectedConditions.not(ExpectedConditions.attributeContains($(By.cssSelector(selector)),
                        "style", "none"))
        ));
    }

    public void clickSubMenuItemByMenuName(ISubMenu subMenuItemData) {
        String locator = String.format(subMenuItemByNameLocator, subMenuItemData.getName().toLowerCase(Locale.ROOT) );
        $(By.xpath(locator)).click();
    }
}
