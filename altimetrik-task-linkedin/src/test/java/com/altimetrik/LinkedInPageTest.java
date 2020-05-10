package com.altimetrik;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.linkedin.pages.HomePage;
import com.linkedin.pages.LoginPage;

public class LinkedInPageTest {

	private LoginPage loginPage;
	private HomePage homePage;

	private WebDriver driver;

	@BeforeTest
	public void set_Up() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void linkedIn_Challenge() throws InterruptedException {
		loginPage = new LoginPage(driver);
		loginPage.launch_Browser_And_Click_On_SignIn();
		loginPage.login_Using_DataProvider();
		homePage = new HomePage(driver);
		homePage.verify_That_User_Is_On_Home_Page();
		homePage.verify_Suggested_Search("Sales");
		homePage.verify_That_No_Other_filters_are_applied();
		homePage.in_Experience_Choose_Mid_Senior_Level_Click_Ok();
		homePage.select_All_Filters_And_Select_Job_Type_as_Full_time();
		homePage.user_Clicking_On_Signout();
	}

	@AfterTest
	public void tear_Down() {
		driver.close();
	}

}