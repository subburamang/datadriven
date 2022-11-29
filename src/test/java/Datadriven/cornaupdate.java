package Datadriven;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class cornaupdate {
	static WebDriver driver;
	public static int indexofpopulation;
	public static int indexofcountry;

	public static void browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.worldometers.info/coronavirus/");

	}

	public static void getallheader() {
		Map<Integer, String> headerMap = new LinkedHashMap<Integer, String>();
		List<WebElement> allheader = driver
				.findElements(By.xpath("//table[@id='main_table_countries_today']/thead/tr/th"));
		for (int i = 0; i < allheader.size(); i++) {
			String header = allheader.get(i).getText().replace("\n", "");
			headerMap.put(i, header);
			if (header.equalsIgnoreCase("population")) {
				indexofpopulation=i;
			}else if (header.contains("Country")) {
				indexofcountry=i;
			}
		}
		System.out.println(headerMap);
	}

	public static void Alldata() {
		List<WebElement> Alldata = driver
				.findElements(By.xpath("//table[@id='main_table_countries_today']/tbody[1]/tr/td"));
		for (WebElement webElement : Alldata) {
			System.out.println(webElement.getText());
		}

	}

	public static void Paticulardata() {
		WebElement paticular = driver
				.findElement(By.xpath("(//table[@id='main_table_countries_today']/tbody[1]/tr[7]/td)[15]"));
		System.out.println(paticular.getText());

	}

	public static void countrylist() {
		List<WebElement> list = driver
				.findElements(By.xpath("//table[@id='main_table_countries_today']/tbody[1]/tr/td[2]"));
		for (WebElement webElement : list) {
			System.out.println(webElement.getText());
		}
	}

	public static void onecountry() {
		WebElement country = driver
				.findElement(By.xpath("//table[@id='main_table_countries_today']/tbody[1]/tr[135]/td"));
		System.out.println(country.getText());
	}

	public static void population(String countryname) {
		List<WebElement> allrows = driver
				.findElements(By.xpath("//table[@id='main_table_countries_today']/tbody[not(@class)]/tr"));
		for (int i = 0; i < allrows.size(); i++) {
			List<WebElement> allColumns = allrows.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < allColumns.size(); j++) {
				if (allColumns.get(indexofcountry).getText().equalsIgnoreCase(countryname)) {
					String population = allColumns.get(indexofpopulation).getText();
					System.out.println(countryname + "population is" + population);
					break;

				}
			}

		}
	}

	public static void main(String[] args) {

		browser();
		getallheader();
	//	Alldata();
	Paticulardata();
	//	countrylist();
	//	onecountry();
		population("india"); //dynamic

	}
}
