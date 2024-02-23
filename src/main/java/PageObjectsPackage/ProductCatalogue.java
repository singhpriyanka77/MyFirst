package PageObjectsPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractClassPackage.AbstractComponent;
import TestCases.OrderPage;

public class ProductCatalogue extends AbstractComponent{

	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		// initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(css = ".mb-3")
	List<WebElement> products;
	
	@FindBy(css = ".ng-animating")
	WebElement spinner;

	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");


	public void goToOrdersPage() {
		// TODO Auto-generated method stub
		
	}

	public List<WebElement> getProductList() {
		// TODO Auto-generated method stub
		
		waitForElementToAppear(productsBy);
		return products;
	
	}

	public void addProductToCart(String productName) {
		// TODO Auto-generated method stub
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		//waitForElementToDisappear(spinner);
	}

	public WebElement getProductByName(String productName)
	{
		WebElement prod =	getProductList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}

}
