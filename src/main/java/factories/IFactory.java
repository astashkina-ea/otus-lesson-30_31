package factories;

import data.BrowserData;
import exception.BrowserNorSupportedException;
import org.openqa.selenium.WebDriver;

public interface IFactory {
    WebDriver createDriver() throws BrowserNorSupportedException;
}