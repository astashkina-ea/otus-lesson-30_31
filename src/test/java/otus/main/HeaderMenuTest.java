package otus.main;

import component.CourseFilterComponent;
import component.HeaderMenuComponent;
import component.popup.HeaderSubMenuPopup;
import data.CategoryData;
import data.menu.HeaderMenuItemDate;
import data.menu.SubMenuCategoryCourseItemData;
import exception.BrowserNorSupportedException;
import factories.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

public class HeaderMenuTest {

    private WebDriver driver;

    @BeforeAll
    public static void setUpDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void init() throws BrowserNorSupportedException {
        driver = new WebDriverFactory().createDriver();
    }

    @AfterEach
    public void close(){
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @Test
    public void clickCourseCategoryMenu(){
        new MainPage(driver)
                .open();

        HeaderSubMenuPopup headerSubMenuPopup = new HeaderSubMenuPopup(driver);
        headerSubMenuPopup.popupShouldNotBeVisible(HeaderMenuItemDate.LEARNING);

        new HeaderMenuComponent(driver)
                .moveCursorToHeaderItem(HeaderMenuItemDate.LEARNING);

        headerSubMenuPopup.popupShouldBeVisible(HeaderMenuItemDate.LEARNING);
        headerSubMenuPopup.clickSubMenuItemByMenuName(SubMenuCategoryCourseItemData.GAMEDEV);

        new CourseFilterComponent(driver)
                .courseFilterComponent(CategoryData.GAMEDEV, true);
    }
}
