package POMRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver= driver;
	}

	@FindBy(linkText = "Logout")
	public WebElement logoutButton;

	
	public void logoutAction() {
		logoutButton.click();
	}
	
	public String verifyHomePageText(String homePageText) {
		
		return driver.findElement(By.xpath("//td[text()='"+homePageText+"']")).getText();
		
	}
}
