package com.altimetrik.utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

	private WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void takeScreenshot(String filename) {
		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src,
					new File("./src/test/resources/screenshots/" + filename + ".jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void highlight(WebElement webElement) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].style.border='4px solid Red';arguments[0].style.background='Yellow'",
					webElement);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void removeHighlight(WebElement webElement) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].style.border='';arguments[0].style.background=''", webElement);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
