package com.adient.appium;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.WebElement;

public class CalculatorOperationTest extends BaseDriver {


	private static final String FIRST_NUM   = "5";
	private static final String SECOND_NUM  = "2";
	
	@Test
	public void addOperationTest() throws InterruptedException{
		
		WebElement firstNumber = driver.findElementById("firstNumber");
		firstNumber.sendKeys(FIRST_NUM);
		
		WebElement secondNumber = driver.findElementById("secondNumber");
		secondNumber.sendKeys(SECOND_NUM);
		
		WebElement addButton = driver.findElementById("addButton");
		addButton.click();
		
		WebElement result = driver.findElementById("resultTextView");
		String resultStr = result.getText();
		
		
		
		System.out.println("==========================================================================================================");
		System.out.println(resultStr);
		System.out.println("==========================================================================================================");
		
		assertEquals("Result : 7.0", resultStr);
		
	}
	
	@Test
	public void divOperationTest() throws InterruptedException{
		
		WebElement firstNumber = driver.findElementById("firstNumber");
		firstNumber.sendKeys(FIRST_NUM);
		
		WebElement secondNumber = driver.findElementById("secondNumber");
		secondNumber.sendKeys(SECOND_NUM);
		
		WebElement addButton = driver.findElementById("divButton");
		addButton.click();
		
		WebElement result = driver.findElementById("resultTextView");
		String resultStr = result.getText();
		
		
		
		System.out.println("==========================================================================================================");
		System.out.println(resultStr);
		System.out.println("==========================================================================================================");
		
		assertEquals("Result : 2.5", resultStr);
		
	}
	
	@Test
	public void subOperationTest() throws InterruptedException{
		
		WebElement firstNumber = driver.findElementById("firstNumber");
		firstNumber.sendKeys(FIRST_NUM);
		
		WebElement secondNumber = driver.findElementById("secondNumber");
		secondNumber.sendKeys(SECOND_NUM);
		
		WebElement addButton = driver.findElementById("subButton");
		addButton.click();
		
		WebElement result = driver.findElementById("resultTextView");
		String resultStr = result.getText();
		
		
		
		System.out.println("==========================================================================================================");
		System.out.println(resultStr);
		System.out.println("==========================================================================================================");
		
		assertEquals("Result : 3.0", resultStr);
		
	}
	
	@Test
	public void mulOperationTest() throws InterruptedException{
		
		WebElement firstNumber = driver.findElementById("firstNumber");
		firstNumber.sendKeys(FIRST_NUM);
		
		WebElement secondNumber = driver.findElementById("secondNumber");
		secondNumber.sendKeys(SECOND_NUM);
		
		WebElement addButton = driver.findElementById("mulButton");
		addButton.click();
		
		WebElement result = driver.findElementById("resultTextView");
		String resultStr = result.getText();
		
		
		
		System.out.println("==========================================================================================================");
		System.out.println(resultStr);
		System.out.println("==========================================================================================================");
		
		assertEquals("Result : 10.0", resultStr);
		
	}
	
}
