package com.linkedin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import com.altimetrik.utils.BasePage;
import com.altimetrik.utils.TestDataUtil;

public class LoginPage extends BasePage {

	private WebDriver driver;

	private static final By SGN_IN_BTN = By.xpath("//a[contains(text(),'Sign in')]");
	private static final By USER_NAME = By.id("username");
	private static final By PASSWORD = By.id("password");
	private static final By SUBMIT_BTN = By.xpath("//button[@type='submit']");

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void launch_Browser_And_Click_On_SignIn() {
		driver.get("https://www.linkedin.com");
		System.out.println(driver.getTitle());
		if (driver.getTitle().equals("LinkedIn: Log In or Sign Up")) {
			System.out.println("Title Matched");
		} else {
			System.out.println("Title not matched");
		}

		highlight(driver.findElement(SGN_IN_BTN));
		takeScreenshot("SGN_IN_BTN clicking");
		driver.findElement(SGN_IN_BTN).click();

	}

	public void login_Using_DataProvider() {
		TestDataUtil tsu = new TestDataUtil();
		driver.findElement(USER_NAME).sendKeys(tsu.getStringData("LoginLinkedInTestdata", 1, 0));
		driver.findElement(PASSWORD).sendKeys(tsu.getStringData("LoginLinkedInTestdata", 1, 1));
		highlight(driver.findElement(SUBMIT_BTN));
		takeScreenshot("SUBMIT_BTN clicking");
		driver.findElement(SUBMIT_BTN).click();
		System.out.println("Clicked on sign in button sucessfully");
		driver.getTitle();
		System.out.println(driver.getTitle());
		if (driver.getTitle().equals("LinkedIn")) {
			System.out.println("Title Matched");
		} else {
			System.out.println("Title not matched");
		}
	}

}
