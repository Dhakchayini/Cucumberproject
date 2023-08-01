package org.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	// public static WebElement element;

	public static void browserlaunch() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public static void launchUrl(String url) {
		driver.get(url);
		
	}

	public static void title() {
		String title = driver.getTitle();
		System.out.println("Title is :" + title);
	}

	public static void currentUrl() {
		driver.getCurrentUrl();
	}

	public static void getText(WebElement element) {
		System.out.println(element.getText());
	}

	public static void getAttribute(WebElement element, String value) {
		System.out.println(element.getAttribute(value));
	}

	public static void navigate(String url) {
		driver.navigate().to(url);
	}

	public static void navigateRefresh() {
		driver.navigate().refresh();
	}

	public static void navigateback() {
		driver.navigate().back();
	}

	public static void navigateforward() {
		driver.navigate().forward();
	}

	public static void close() {
		driver.quit();
	}

	public static String getAttribute(WebElement element ) {
		String attribute = element.getAttribute("value");
		return attribute;
	}
	
	
	public static void sendKeys(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static void click(WebElement element) {
		element.click();
	}

	public static void simpleAlert() {
		driver.switchTo().alert().accept();
	}

	public static void confirmAlert(String alert) {
		if (alert.equalsIgnoreCase("confirmAlertAccept")) {
			driver.switchTo().alert().accept();
		} else if (alert.equalsIgnoreCase("confirmAlertDismiss")) {
			driver.switchTo().alert().dismiss();
		}
	}

	public static void promptAlert(String text) {
		driver.switchTo().alert().sendKeys(text);
		driver.switchTo().alert().accept();
	}

	public static void action(String actionName, WebElement element) {
		Actions action = new Actions(driver);
		if (actionName.equalsIgnoreCase("contextclick")) {
			action.contextClick(element).build().perform();
		} else if (actionName.equalsIgnoreCase("click")) {
			action.click(element).build().perform();
		} else if (actionName.equalsIgnoreCase("doubleclick")) {
			action.doubleClick(element).build().perform();
		} else if (actionName.equalsIgnoreCase("moveToElement")) {
			action.moveToElement(element).build().perform();
		} else if (actionName.equalsIgnoreCase("click")) {
			action.click(element).build().perform();
		}
	}

	public static void action(WebElement source, WebElement dest) {
		Actions action = new Actions(driver);
		action.dragAndDrop(source, dest).build().perform();
	}

	public static void robot(String value) throws AWTException {
		Robot r = new Robot();
		if (value.equalsIgnoreCase("enter")) {
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		}
	}

	public static void frameIndex(int index) {
		driver.switchTo().frame(index);
	}

	public static void frameValue(String value) {
		driver.switchTo().frame(value);
	}

	public static void frameWebElement(WebElement element) {
		driver.switchTo().frame(element);
	}

	public static void isEnabled(WebElement element) {
		System.out.println("Element is enabled: " + element.isEnabled());
	}

	public static void isDisplayed(WebElement element) {
		System.out.println("Element is displayed: " + element.isDisplayed());
	}

	public static void isSelected(WebElement element) {
		System.out.println("Element is selected: " + element.isSelected());
	}

	public static void windowHandles() {

		Set<String> allIds = driver.getWindowHandles();
		for (String id : allIds) {
			String title = driver.switchTo().window(id).getTitle();
			System.out.println(title);
		}

	}

	public static void dropDown(WebElement element, String option, String value) {
		Select s = new Select(element);
		if (option.equalsIgnoreCase("index")) {
			s.selectByIndex(Integer.parseInt(value));
		} else if (option.equalsIgnoreCase("value")) {
			s.selectByValue(value);
		} else if (option.equalsIgnoreCase("text")) {
			s.selectByVisibleText(value);
		}
	}

	public static void screenshot(String filename) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screen = ts.getScreenshotAs(OutputType.FILE);
		File dest1 = new File("C:\\Swathy\\Makemytrip\\screenshot\\" + filename + ".png");
		FileUtils.copyFile(screen, dest1);
	}

	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
	}

	public static void explicit_wait(String value, long seconds, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, seconds);
		if (value.equalsIgnoreCase("alert accept")) {
			wait.until(ExpectedConditions.alertIsPresent()).accept();
		} else if (value.equalsIgnoreCase("alert dismiss")) {
			wait.until(ExpectedConditions.alertIsPresent()).dismiss();
		} else if (value.equalsIgnoreCase("visibility")) {
			wait.until(ExpectedConditions.visibilityOf(element)).click();
			;
		} else if (value.equalsIgnoreCase("all visibility")) {
			wait.until(ExpectedConditions.visibilityOfAllElements(element));
		} else if (value.equalsIgnoreCase("clickable")) {
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		}
	}

	public static void javaScriptClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

	}

	public static void javaScriptScroll(String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (value.equalsIgnoreCase("scrolldown")) {
			js.executeScript("window.scrollBy(0,1200)", "");
		} else if (value.equalsIgnoreCase("scrollup")) {
			js.executeScript("window.scrollBy(0,-1200)", "");
		}
	}

	public static void javaScriptScrollInto(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	

	}
}

	

