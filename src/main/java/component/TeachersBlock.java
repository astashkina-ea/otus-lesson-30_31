package component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.TeacherCardPage;

import java.util.List;

public class TeachersBlock extends AbsBaseComponent {

    public TeachersBlock(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".teacher__name")
    private List<WebElement> teacherName;

    @FindBy(css = "a.teacher")
    private List<WebElement> teacherTiles;

    public String getTeacherNameByIndex(int index){
        return teacherName.get(--index).getText();
    }

    public TeacherCardPage clickTeacheTile(int index) {
        teacherTiles.get(--index).click();
        return new TeacherCardPage(driver);
    }
}