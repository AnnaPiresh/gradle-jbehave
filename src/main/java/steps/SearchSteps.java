package steps;


import helpers.BrowserDataHelper;
import org.jbehave.core.annotations.Then;
import org.openqa.selenium.WebDriver;
import pages.SearchPage;

import static junit.framework.TestCase.assertTrue;


public class SearchSteps{

  private WebDriver driver = Setup.driver();

  private SearchPage searchPage = new SearchPage(driver);

  @Then("^search results are matching the search term$")
  public void compare_search_results(){
    String term = BrowserDataHelper.browserData.get("search_term").toString();

    searchPage.getSearchTitles().forEach(title -> assertTrue(title.toLowerCase().contains(term.toLowerCase())));
  }

  @Then("^title of page is \"(.+)\"$")
  public void compare_page_title(String title){
    assertTrue(searchPage.getPageTitle().contains(title));
  }
}
