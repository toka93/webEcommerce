package task;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.logging.Level;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import taskPages.HomePage;
import taskPages.WomenFragrancesPage;

public class stepDefinitions {

	public static WebDriver driver;

	public WebDriver startDriver() throws MalformedURLException {

		WebDriverManager.chromedriver().avoidBrowserDetection().setup();
		driver = new ChromeDriver(chromeOption());

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));

		return driver;
	}

	public static ChromeOptions chromeOption() {
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default.content_settings.popups", 0);
		options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("--disable-web-security");
		options.addArguments("--allow-running-insecure-content");
		options.addArguments("--allow-insecure-localhost");
		options.addArguments("--no-sandbox");
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-features=VizDisplayCompositor");
		LoggingPreferences loggingprefs = new LoggingPreferences();
		loggingprefs.enable(LogType.BROWSER, Level.ALL);

		return options;

	}

	@After
	public void stopDriver() {

		driver.quit();
	}

	private HomePage homePage;
    private WomenFragrancesPage womenPage;
	
	@Before
	public void before(Scenario scenario) throws MalformedURLException {

		driver = startDriver();
		homePage = new HomePage(driver);
		womenPage= new WomenFragrancesPage(driver);

	}

	@Given("User Navigate to {string}")
	public void openURL(String url) {

		driver.navigate().to(url);

	}

	@When("Select Women Fragrances from Fragrances Tab in the upper bar")
	public void openWomenFragrances() {

		homePage.openWomenFragrances(driver);
		womenPage.addFragrances(driver);

	}

}
