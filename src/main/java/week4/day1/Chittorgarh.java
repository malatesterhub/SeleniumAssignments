package week4.day1;

import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chittorgarh {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.chittorgarh.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("navbtn_stockmarket")).click();
		driver.findElement(By.xpath("(//a[text()='NSE Bulk Deals'])[1]")).click();
		driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]//th[3]"));
		List<WebElement> lst = driver.findElements(By.xpath("//table[contains(@class,'table table-bordered')]//tr//td[3]"));
		   System.out.println("Total Security Name with Duplicates:" + lst.size());
		   for (int j = 0; j < lst.size(); j++)
		   {
			System.out.println(lst.get(j).getText());
		   }
		   HashSet<String> removeDuplicateNum=new HashSet<String>();
		   for (int i = 0; i < lst.size(); i++)
		   {
				
			   removeDuplicateNum.add(lst.get(i).getText());
		   }
		   System.out.println("Total Security Name without Duplicates:" + removeDuplicateNum.size());
		  
	}

}
