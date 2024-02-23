package AbstractClassPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import rahulshettyacademy.pageobjects.CartPage;
//import rahulshettyacademy.pageobjects.OrderPage;

public class AbstractComponent {
	
	WebDriver driver;
	
public AbstractComponent(WebDriver driver)
{
	this.driver = driver;
	PageFactory.initElements(driver, this);
	
}
	
@FindBy(css = "[routerlink*='cart']")
WebElement cartHeader;

@FindBy(css="[routerlink*='myorders']")
WebElement orderHeader;

@FindBy(css="[routerlink*='dashboard']")
WebElement home;

public void waitForElementToAppear(By findBy) {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

}

public void waitForElementToAppear(WebElement findBy)
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	
	wait.until(ExpectedConditions.visibilityOf(findBy));
}

public void goToCartPage()
{
	cartHeader.click();
	
}
public void goToOrdersPage()
{
	orderHeader.click();
	
	
}
}
