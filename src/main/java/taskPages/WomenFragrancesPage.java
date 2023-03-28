package taskPages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WomenFragrancesPage extends BasePage {

	public WomenFragrancesPage(WebDriver driver) {
		super(driver);
	}

	
	public void clickOnInstock(WebDriver driver)
	{
		WebElement instock = webEl(driver, By::xpath, "//*[@title='Add the filter Availability In stock']");

		instock.click();
	}
	
	public void addFragrances(WebDriver driver) {
		
		
		clickOnInstock(driver);
		List<WebElement> women_fragrances = webEls(driver, By::xpath, "//*[@id='collection-products']/div");
		List<WebElement> addToCards = webEls(driver, By::xpath, "//*[@id='collection-products']//*[@class='product-details']//*/form/button");

		

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		System.out.println("size:"+ women_fragrances.size());
		for(int i=0;i<women_fragrances.size();i++)
		
		{
		WebElement product=	women_fragrances.get(i);
			
		
			String locator=product.toString().split("->")[1];
			locator=locator.split("xpath: ")[1];
			locator=locator.replace("[@class='badge dicount-badge']]","[@class='product-details']//*/form/button");
			WebElement addCart=	webEl(driver, By::xpath, locator);
			addCart.click();
			System.out.println("clicked");
			WebElement closeCart=	webEl(driver, By::xpath, "//a[@class='modal-close']");
			//wait.until(ExpectedConditions.visibilityOf(closeCart));
			closeCart.click();
			System.out.println("closed");

			
		}

	}
	
	
	
	
	
	
	
	
	
	
	

}
