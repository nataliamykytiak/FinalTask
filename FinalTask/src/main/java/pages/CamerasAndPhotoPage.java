package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CamerasAndPhotoPage extends BasePage{

    @FindBy(xpath = "//ul/li[contains(@class, 's-item') and contains(@data-view, 'iid')]")
    private List<WebElement> searchResults;



    public CamerasAndPhotoPage(WebDriver driver){
        super(driver);
    }

}
