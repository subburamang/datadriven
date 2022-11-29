package Datadriven;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webtable {
	public static int indexofcountry;
	public static int indexofpopulation;
	static WebDriver driver;

	public static void getpaticulardata(String countryname) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.worldometers.info/coronavirus/");

		List<WebElement> allrows = driver
				.findElements(By.xpath("//table[@id='main_table_countries_today']/tbody[not(@class)/tr]"));
		for (int i = 0; i < allrows.size(); i++) {
			List<WebElement> allcolumns = allrows.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < allcolumns.size(); j++) {
				if (allcolumns.get(indexofcountry).getText().equalsIgnoreCase(countryname)) {
					String population = allcolumns.get(indexofpopulation).getText();
					System.out.println(countryname + "population is" + population);
					break;

				}
			}
		}
	}

	public static void main(String[] args) {
		getpaticulardata("india");

	}
}
