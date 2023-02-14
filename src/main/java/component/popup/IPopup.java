package component.popup;

import data.menu.HeaderMenuItemDate;
import data.menu.ISubMenu;

public interface IPopup {
    public void popupShouldNotBeVisible(HeaderMenuItemDate headerMenuItemDate);
    public void popupShouldBeVisible(HeaderMenuItemDate headerMenuItemDate);

}
