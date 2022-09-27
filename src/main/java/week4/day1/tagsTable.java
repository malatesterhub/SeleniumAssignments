package week4.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class tagsTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		List<WebElement> rows = driver.findElements(By.xpath("//div[@class='render']//table//tr"));
		System.out.println("The number of rows are:"+ rows.size());
		List<WebElement> columns = driver.findElements(By.xpath("//div[@class='render']//table//thead//th"));
		System.out.println("The number of columns are:" +columns.size());
	}

}
