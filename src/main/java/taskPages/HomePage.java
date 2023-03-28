package taskPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void openWomenFragrances(WebDriver driver) {
		WebElement fragrances = webEl(driver, By::xpath, "//a[@href='/collections/perfumes' and @title='Fragrances']");

		fragrances.click();
		WebElement womenfragrances = webEl(driver, By::xpath,
				"//a[@href='/collections/womens-perfumes' and @title='Women Fragrances']");

		JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("arguments[0].scrollIntoView(true);", womenfragrances);

	}
	
	
	
	
	
	
	
	
	
	
	

}
