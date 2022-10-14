package week5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class Servicenow {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://dev125633.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Mani@123");
		driver.findElement(By.id("sysverb_login")).click();
		Shadow shadow=new Shadow(driver); 
		shadow.setImplicitWait(10); 
		shadow.findElementByXPath("//div[text()='All']").click();
		shadow.findElementByXPath("//span[text()='Service Catalog']").click();
		WebElement eleFrame = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(eleFrame);
		driver.findElement(By.xpath("//h2[text()[normalize-space()='Mobiles']]")).click();
		driver.findElement(By.xpath("//strong[text()='Apple iPhone 13']")).click();
		driver.findElement(By.xpath("(//label[@class='radio-label'])[2]")).click();
		driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']")).click();
		driver.findElement(By.xpath("//option[text()='Unlimited']")).click();
		driver.findElement(By.xpath("//label[text()='Pink']")).click();
		driver.findElement(By.xpath("//label[text()='128 GB']")).click();
		driver.findElement(By.xpath("//button[contains(@class,'request_catalog_button_with_icon btn')]")).click();
		String verification = driver.findElement(By.xpath("//span[text()='Thank you, your request has been submitted']")).getText();
		System.out.println(verification);
		String reqnum = driver.findElement(By.xpath("//a[@class='linked requestItemUrl']//b[1]")).getText();
	    System.out.println(reqnum);
	
		
		
	}

}
