package Datadriven;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Adactin {
	
	static WebDriver driver;
	 public static void adactin() throws AWTException {
		
	WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.get("https://adactinhotelapp.com/");
		 Robot a=new Robot();	
		 WebElement findElement = driver.findElement(By.id("username"));
	 }
	

}
