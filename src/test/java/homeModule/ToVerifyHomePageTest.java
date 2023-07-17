package homeModule;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POMRepo.HomePage;
import Utils.BaseClass;

public class ToVerifyHomePageTest extends BaseClass{
	@Test
	public void toVerifyHomePageTest() {

		String expectedTitle = "Enter";

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.titleContains(expectedTitle));

		String actualTitle = driver.getTitle();

		Assert.assertTrue(actualTitle.contains(expectedTitle));
		System.out.println("Pass: the home page title is verified");
		
		HomePage home = new HomePage(driver);

		String actualHomePageText = home.verifyHomePageText("Enter Time-Track");

		Assert.assertTrue(actualHomePageText.contains("Enter Time-Track"));
		System.out.println("Pass: the home page text is verified");

	}

}
