package Utils;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import POMRepo.HomePage;
import POMRepo.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public FileUtil fUtil = new FileUtil();

	@BeforeSuite
	public void bsConfig() {
		System.out.println("Data Base");
	}

	@BeforeClass
	public void bcConfig() throws IOException {
		
		String url = fUtil.fetchDataFromPropertyFile("url");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		System.out.println("Lunch the browser");

		driver.get(url);

		System.out.println("Navigate to the URL");
	}

	@BeforeMethod
	public void bmConfig() throws IOException {
		String username = fUtil.fetchDataFromPropertyFile("username");
		String password = fUtil.fetchDataFromPropertyFile("password");

		LoginPage login = new LoginPage(driver);
		login.loginAction(username, password);

		System.out.println("Login");
	}

	@AfterMethod
	public void amConfig() {
		HomePage home=new HomePage(driver);
		home.logoutAction();

		System.out.println("Logout");

	}

	@AfterClass
	public void acConfig() {
		driver.quit();
		System.out.println("Close the browser");
	}

	@AfterSuite
	public void asConfig() {
		System.out.println("Close Data Base");
	}

}
