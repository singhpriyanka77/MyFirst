package TestCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import CommonComponents.BaseTest;
import PageObjectsPackage.LandingPage;
import PageObjectsPackage.ProductCatalogue;


@Test(dataProvider="getData",groups= {"Purchase"})
public class SubmitOrderTest extends BaseTest{
	String productName = "ZARA COAT 3";

	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException
	{
        // This will implicitly call BaseTest and initialise the driver
		
		LandingPage landingPage = new LandingPage(driver);
		
		landingPage.loginApplication(input.get("email"), input.get("password"));
		
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("product"));
		
		
		
		
		

	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{

		
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//data//PurchaseOrder.json");
		return new Object[][]  {{data.get(0)}, {data.get(1) } };
		
	}

	
	
	

	  
	
	
	
	
	
	
	
	


}
