package com.linkedin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.altimetrik.utils.BasePage;

import junit.framework.Assert;

public class HomePage extends BasePage {

	private WebDriver driver;

	private static final By HOME_LABEL = By.xpath("//span[contains(text(),'Home')]");
	private static final By ALL_FILTERS = By
			.xpath("//button[@type='button'][@data-control-name='all_filters']/span[1]");
	private static final By CLEAR_BTN = By
			.xpath("//button[@data-control-name='all_filters_clear']/span[contains(text(),clear)]");
	private static final By MOST_RECENT_RADIO_BTN = By.xpath("//label[@for='sf-sortBy-DD']");
	private static final By EXPERIENCE_LEVEL_LABEL = By.xpath("//legend[@aria-label='Filter by: Experience Level']");
	private static final By MID_SENIOR_LEVEL_CHKBOX = By.xpath("//label[@for='sf-experience-4']");
	private static final By FILTER_COUNT = By
			.xpath("//button[@data-control-name='all_filters_clear']/span[contains(text(),clear)]/span");
	private static final By JOB_TYPE_LABEL = By.xpath("//legend[@aria-label='Filter by: Job Type']");
	private static final By FULL_TIME_CHKBOX = By.xpath("//label[@for='sf-jobType-F']");
	private static final By SUGGESTED_SEARCH = By.xpath("//input[@placeholder='Search']");
	private static final By ME_DROPDOWN = By.id("nav-settings__dropdown");
	private static final By SIGN_OUT_BTN = By.xpath("//div//ul/li/ul/li/a[@data-control-name='nav.settings_signout']");

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void verify_That_User_Is_On_Home_Page() throws InterruptedException {
		Thread.sleep(3000);
		highlight(driver.findElement(HOME_LABEL));
		driver.findElement(HOME_LABEL);
		Thread.sleep(3000);
		takeScreenshot("HOME_LABEL");
		removeHighlight(driver.findElement(HOME_LABEL));
		System.out.println("User is on LinkedIn Home Page");

	}

	public void verify_Suggested_Search(String search_data) throws InterruptedException {
		highlight(driver.findElement(SUGGESTED_SEARCH));
		takeScreenshot("SUGGESTED_SEARCH");
		Thread.sleep(3000);
		driver.findElement(SUGGESTED_SEARCH).sendKeys(search_data, Keys.ENTER);
		Thread.sleep(3000);
		removeHighlight(driver.findElement(SUGGESTED_SEARCH));
		System.out.println("In the Suggested Searches Click Sales");
	}

	public void verify_That_No_Other_filters_are_applied() throws InterruptedException {
		Thread.sleep(5000);
		highlight(driver.findElement(ALL_FILTERS));
		Thread.sleep(4000);
		takeScreenshot("Clicking on ALL_FILTERS");
		Thread.sleep(4000);
		driver.findElement(ALL_FILTERS).click();
		Thread.sleep(4000);
		highlight(driver.findElement(MOST_RECENT_RADIO_BTN));
		driver.findElement(MOST_RECENT_RADIO_BTN).click();
		Thread.sleep(3000);
		removeHighlight(driver.findElement(MOST_RECENT_RADIO_BTN));
		driver.findElement(CLEAR_BTN).click();
		highlight(driver.findElement(CLEAR_BTN));
		takeScreenshot("No FILTERS Applied");
		Thread.sleep(3000);
		removeHighlight(driver.findElement(CLEAR_BTN));
		Thread.sleep(3000);
		System.out.println("Verified that no other filters are applied");
	}

	public void in_Experience_Choose_Mid_Senior_Level_Click_Ok() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(EXPERIENCE_LEVEL_LABEL);
		highlight(driver.findElement(EXPERIENCE_LEVEL_LABEL));
		Thread.sleep(3000);
		removeHighlight(driver.findElement(EXPERIENCE_LEVEL_LABEL));
		highlight(driver.findElement(MID_SENIOR_LEVEL_CHKBOX));
		driver.findElement(MID_SENIOR_LEVEL_CHKBOX).click();
		Thread.sleep(3000);
		takeScreenshot("Selecting on MID_SENIOR_LEVEL_CHKBOX");
		removeHighlight(driver.findElement(MID_SENIOR_LEVEL_CHKBOX));
		assertTest(1);

	}

	public void select_All_Filters_And_Select_Job_Type_as_Full_time() throws InterruptedException {
		highlight(driver.findElement(JOB_TYPE_LABEL));
		driver.findElement(JOB_TYPE_LABEL);
		Thread.sleep(3000);
		removeHighlight(driver.findElement(JOB_TYPE_LABEL));
		highlight(driver.findElement(FULL_TIME_CHKBOX));
		takeScreenshot("Selecting FULL_TIME_CHKBOX");
		driver.findElement(FULL_TIME_CHKBOX).click();
		Thread.sleep(3000);
		removeHighlight(driver.findElement(FULL_TIME_CHKBOX));
		assertTest(2);
	}

	public void assertTest(int count) {
		highlight(driver.findElement(FILTER_COUNT));
		String count_of_Filter = driver.findElement(FILTER_COUNT).getText();
		int i = Integer.parseInt(count_of_Filter);
		Assert.assertEquals(count, i);
	}

	public void user_Clicking_On_Signout() throws InterruptedException {
		highlight(driver.findElement(ME_DROPDOWN));
		driver.findElement(ME_DROPDOWN).click();
		Actions mouseHover = new Actions(driver);
		mouseHover.moveToElement(driver.findElement(SIGN_OUT_BTN));
		Thread.sleep(3000);
		highlight(driver.findElement(SIGN_OUT_BTN));
		Thread.sleep(3000);
		driver.findElement(SIGN_OUT_BTN).click();
		Thread.sleep(3000);

	}

}
