package steps;


import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class HomepageSteps {

  private WebDriver driver = Setup.driver();

  private HomePage homepage = new HomePage(driver);

  @Given("^user opens Google homepage$")
  public void open_google_homepage(){
    homepage.navigate("https://www.google.com/");
  }

  @When("^user enters search term \"(.+)\"$")
  public void enter_search_term(String term){
    homepage.enterSearchTerm(term);
  }

  @When("^presses Enter on keyboard$")
  public void press_enter(){
    homepage.clickEnterKey();
  }
}
