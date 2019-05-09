package steps;


import helpers.BrowserDataHelper;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

import static junit.framework.TestCase.assertTrue;

public class HomepageSteps{

  private HomePage homepage;

  public HomepageSteps(WebDriver driver){
      this.homepage = new HomePage(driver);
  }

  @Given("user opens Google homepage")
  public void open_google_homepage(){
    homepage.navigate("https://www.google.com/");
  }

  @When("user enters search term \"$term\"")
  public void enter_search_term(String term){
    homepage.enterSearchTerm(term);
  }

  @When("presses Enter on keyboard")
  public void press_enter(){
    homepage.clickEnterKey();
  }

  @Then("search results are matching the search term")
  public void compare_search_results(){
    String term = BrowserDataHelper.browserData.get("search_term").toString();

    homepage.getSearchTitles().forEach(title -> assertTrue(title.toLowerCase().contains(term.toLowerCase())));
  }

  @Then("title of page is \"$title\"")
  public void compare_page_title(String title){
    assertTrue(homepage.getPageTitle().contains(title));
  }
}
