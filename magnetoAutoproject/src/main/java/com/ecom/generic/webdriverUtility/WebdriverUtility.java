package com.ecom.generic.webdriverUtility;

import java.awt.Window;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {
	
//	Actions act ;

	public void waitforPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void WaitforElementToBePresent(WebDriver driver, WebElement element, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void toSwitchtonewWindow(WebDriver driver) {
		driver.switchTo().newWindow(WindowType.WINDOW);
	}

	public void toSwitchtonewTab(WebDriver driver) {
		driver.switchTo().newWindow(WindowType.TAB);
	}

	public void switchBtwWindow(WebDriver driver, String partialurl) {
		Set<String> ids = driver.getWindowHandles();
		for (String id : ids) {
			driver.switchTo().window(id);
			if (driver.getCurrentUrl().contains(partialurl)) {
				break;
			}
		}
	}

	public void ToSelectByvtext(WebElement ele, String text) {
		Select dp = new Select(ele);
		dp.selectByVisibleText(text);
	}

	public void ToSelectByindex(WebElement ele, int index) {
		Select dp = new Select(ele);
		dp.selectByIndex(index);
	}

	public void ToSelectByvalue(WebElement ele, String value) {
		Select dp = new Select(ele);
		dp.selectByValue(value);
	}

	public void switchToFrameByIndex(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrameByWebElement(WebDriver driver, WebElement ele) {
		driver.switchTo().frame(ele);
	}

	public void switchToFrameBynameORId(WebDriver driver, String nameORId) {
		driver.switchTo().frame(nameORId);
	}

	public void moveToElement(WebDriver driver, WebElement ele) {
		Actions act  = new Actions(driver);
		act.moveToElement(ele).perform();
	}

	public void doubleClickonElement(WebDriver driver, WebElement ele) {
		Actions act  = new Actions(driver);
		act.doubleClick(ele).perform();
	}

	public void rightclickOnElement(WebDriver driver, WebElement ele) {
		Actions act  = new Actions(driver);
		act.contextClick(ele).perform();
	}

	public void clickOnElement(WebDriver driver, WebElement ele) {
		Actions act  = new Actions(driver);
		act.click(ele).perform();
	}

	public void clickandHold(WebDriver driver, WebElement ele) {
		Actions act  = new Actions(driver);
		act.clickAndHold(ele).perform();
	}
	
//	public void scrollToelement(WebDriver driver, WebElement ele) {
//		Actions act  = new Actions(driver);
//		act.scrollToElement(ele).perform();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoview(false)", ele);	
//		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
//		js.executeScript("document.body.scrollHeight");
//	}
	
	public void scrollToelement(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

}
