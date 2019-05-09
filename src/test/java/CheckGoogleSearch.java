import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import steps.HomepageSteps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(BlockJUnit4ClassRunner.class)
public class CheckGoogleSearch extends JUnitStories {
    private static WebDriver driver = driver();

  @Override
  public Configuration configuration() {
    return new MostUsefulConfiguration()
            .useStoryLoader(new LoadFromClasspath(this.getClass()))
            .useStoryReporterBuilder(new StoryReporterBuilder()
                    .withDefaultFormats()
                    .withFormats(Format.HTML,Format.CONSOLE)
            .withRelativeDirectory("../../build/jbehave/"));

  }

  @Override
  public InjectableStepsFactory stepsFactory() {
    return new InstanceStepsFactory(configuration(), new HomepageSteps(driver));
  }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(CodeLocations.codeLocationFromPath("src/test/resources"),
                "**/*.story",
                "**/exclude_*.story");
    }

    private static WebDriver driver(){
        System.setProperty("webdriver.chrome.driver", "path-to-chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("intl.accept_languages", "en-GB");
        chromeOptions.setExperimentalOption("prefs", prefs);


        return new ChromeDriver(chromeOptions);
    }

    @AfterClass
    public static void close(){
        driver.close();
    }
}
