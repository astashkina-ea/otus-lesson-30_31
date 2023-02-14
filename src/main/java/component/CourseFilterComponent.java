package component;

import data.CategoryData;
import data.menu.SubMenuCategoryCourseItemData;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CourseFilterComponent extends AbsBaseComponent{

    public CourseFilterComponent(WebDriver driver) {
        super(driver);
    }

    private String courseCategoryCheckBoxLocator = "//div[./label[text()='%s']]//input";

    public CourseFilterComponent courseFilterComponent(CategoryData categoryData, boolean state) {

        String locator = String.format(courseCategoryCheckBoxLocator, categoryData.getName());

        Assertions.assertEquals(state, $(By.xpath(locator)).isSelected());
        return this;

    }
}
