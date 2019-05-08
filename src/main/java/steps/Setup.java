package steps;

import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.BeforeStories;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Setup {

  public static WebDriver driver(){
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anna_Vasylenko\\Projects\\Drivers\\chromedriver.exe");
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--lang=en-GB");

    return new ChromeDriver(chromeOptions);
  }

  @BeforeClass
  public void init() {
    driver();
  }

  @AfterClass
  public void close(){
    driver().close();
  }
}
