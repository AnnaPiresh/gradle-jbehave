package pages;

import helpers.BrowserDataHelper;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage{

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "q")
    private WebElement searchField;

    @FindBy(css = "a h3")
    private List<WebElement> results;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 15);
    }

    public HomePage navigate(String url){
        driver.navigate().to(url);
        return this;
    }

    public HomePage enterSearchTerm(String term){
        wait.until(ExpectedConditions.elementToBeClickable(searchField));
        searchField.sendKeys(term);

        BrowserDataHelper.browserData.put("search_term", term);

        return this;
    }

    public HomePage clickEnterKey(){
        searchField.sendKeys(Keys.ENTER);

        return this;
    }

    public String getPageTitle(){
        wait.until(ExpectedConditions.urlContains("search"));
        return driver.getTitle();
    }

    public List<String> getSearchTitles(){
        return results.stream().map(WebElement::getText).collect(Collectors.toList());
    }


}
