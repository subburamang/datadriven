package Datadriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bigbasket {
	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\windows 10\\eclipse-workspace\\sfd\\driver\\chromedriver.exe" );
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='form-control ng-pristine ng-valid ng-empty ng-touched']")).sendKeys("rice");
		
	}
	

}
