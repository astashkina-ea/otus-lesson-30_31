package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import waiters.StandardWaiter;


//класс для подключения разных вспомогательных инструментов
public abstract class PageObject {

    protected Actions actions;
    protected WebDriver driver;
    protected StandardWaiter webDriverWait;


    public PageObject(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        webDriverWait = new StandardWaiter(driver);

        PageFactory.initElements(driver, this);
    }

    protected WebElement $(By selector) {
        return driver.findElement(selector);
    }
}