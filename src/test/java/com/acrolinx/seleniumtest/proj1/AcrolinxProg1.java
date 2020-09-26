package com.acrolinx.seleniumtest.proj1;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class AcrolinxProg1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"F:\\SeleniumTrainingByJitendra\\Tools\\Selenium3.141.59\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Step 1: Open Google Chrome and go to https://candidates.acrolinx.sh/webchecker/
		driver.get("https://candidates.acrolinx.sh/webchecker/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().frame(0);//Outer frame
		driver.switchTo().frame(0);//Inner frame
		System.out.println("STEP 1 COMPLETED");
		
		//Step 2: Click the “SIGN IN” buttonClick on Sign in Button
		WebElement signin= driver.findElement(By.xpath("//button[text()='SIGN IN']"));
		signin.click();
		System.out.println("STEP 2 COMPLETED");
		
		//Step 3: New tab opens and sign-in page appears.
		 Set<String> allWindow = driver.getWindowHandles();
		 ArrayList<String> allkindList = new ArrayList<>(allWindow);
		 driver.switchTo().window(allkindList.get(1)).getTitle();
		 Thread.sleep(5000);
		 System.out.println("STEP 3 COMPLETED");
		 
	     //Step 4: Enter the provided credentials  (User Name and Password)
		 driver.findElement(By.xpath("//input[@title='Username']")).sendKeys("sneha.bafna");
		 driver.findElement(By.xpath("//input[@title='Password']")).sendKeys("RWpbfq97+%Y");
		 System.out.println("STEP 4 COMPLETED");
		 
		 //Step 5: Click the “Sign in” button
		 driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		 System.out.println("STEP 5 COMPLETED");
		 
		 //Step 6: A confirmation page appears. Click the “Confirm” button.
		 driver.findElement(By.xpath("//button[text()='CONFIRM']")).click();
		 System.out.println("STEP 6 COMPLETED");
		 
		 //Step 7: Close this tab and switch back to the previous Acrolinx Web Checker page
		 driver.close();
		 driver.switchTo().window(allkindList.get(0));
		 System.out.println("STEP 7 COMPLETED");
		 
		 //Step 8: “Usage Statistics” page appears, click the NO button
		 driver.switchTo().frame(0); //Outer frame for editor window
		 driver.switchTo().frame(0); //Inner frame for Usage information
		 driver.findElement(By.xpath("//button[text()='No']")).click();
		 System.out.println("STEP 8 COMPLETED");
		 
		 //Step 9: In the editor window on the left-hand side, enter “This is a testt”.
		 driver.switchTo().parentFrame();
		 WebElement editor=driver.findElement(By.xpath("//div/textarea[@id='editor']"));
		 editor.click();
		 editor.sendKeys("This is a Testt");
		 driver.switchTo().frame(0);
		 System.out.println("STEP 9 COMPLETED");
		 
		 Thread.sleep(5000);
		 //Step 10: Click the Acrolinx “Check” icon
		 driver.findElement(By.id("improve")).click();
		 System.out.println("STEP 10 COMPLETED");
		 Thread.sleep(5000);
		 
		 //Step 11: Click the “Check” button to trigger a check request for the current document
		 driver.findElement(By.id("check-btn")).click();
		 Thread.sleep(5000);
		 System.out.println("STEP 11 COMPLETED");
		 
		 //Step 12: Click on the suggestion “test”, this action will replace the misspelled word with the corrected word in the editor window.
		 //WebElement Testsuggestion=driver.findElement(By.xpath("//div[@class=\"suggestionClassic\"]/span")); 
		 Thread.sleep(5000);
		 WebElement Testsuggestion=driver.findElement(By.xpath("//span[@class='suggestionLabel']"));
		 Testsuggestion.click();
		 System.out.println("STEP 12 COMPLETED");
		 
		 //Step 13: Check that the number of remaining issues is now 0
		 String actualzero_issues=driver.findElement(By.xpath("//div[text()='0 issues']")).getText();
		 String excepted_Zero_issues ="0 issues";
		 Assert.assertEquals(excepted_Zero_issues, actualzero_issues);
		 System.out.println("STEP 13 COMPLETED");
		 
		 //Step 14: Click on slide out menu and Sign out
		 driver.findElement(By.xpath("//div[@id='btn-side-menu']")).click();
		 driver.findElement(By.xpath("//div[text()='Sign Out']")).click();
		 System.out.println("STEP 14 COMPLETED");
		 
		 //Step 15 : Close the Browser
		 driver.close();
		 System.out.println("STEP 15 COMPLETED");
		 
		 System.out.println("Finish-SNeha Cleared Second Round! Yuppy!!!");
	
	
	
	}

}
