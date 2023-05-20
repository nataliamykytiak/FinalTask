package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage{

    @FindBy(xpath = "//*[@data-component-type='s-search-result']")
    private List<WebElement> searchResults;

    @FindBy(xpath = "//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[2]/div/div/div/div/div[2]/div[1]/h2/a/span")
    private WebElement searchResultsFirstItem;

    @FindBy(xpath = "//ul/li[contains(@class, 's-item') and contains(@data-view, 'iid')]")
    private WebElement searchResultsCategoryName;


    public SearchResultsPage(WebDriver driver){
        super(driver);
    }

    public List<WebElement> getSearchResults() {
        return searchResults;
    }

    public String getSearchResultsSize() {
        return String.valueOf(searchResults.size());
    }

    public String getSearchResultsCategoryName(){
        return searchResultsCategoryName.getText();
    }


    public String getSearchResultsFirstItemName() {
        return searchResultsFirstItem.getText();
    }
}
