package week5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class MandatoryFields {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://dev125633.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Mani@123");
		driver.findElement(By.id("sysverb_login")).click();
		Shadow shadow=new Shadow(driver); 
		shadow.setImplicitWait(20); 
		shadow.findElementByXPath("//div[text()='All']").click();
		WebElement filter = shadow.findElementByXPath("//input[@id='filter']");
		shadow.setImplicitWait(10);
		filter.click();
		filter.sendKeys("Knowledge");
		shadow.findElementByXPath("//mark[text()='Knowledge']").click();
		Thread.sleep(3000);
		WebElement eleFrame = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(eleFrame);
		driver.findElement(By.xpath("//span[text()='IT']")).click();
		driver.findElement(By.xpath("//div[@id='category-segmentedtab']/div[1]/ul[1]/li[4]/a[1]")).click();
		driver.findElement(By.xpath("//div[@id='category-segmentedtab']/div[1]/ul[1]/li[4]/div[1]/div[1]/ul[1]/li[4]/a[1]")).click();
		driver.findElement(By.xpath("//span[text()='Create an Article']")).click();
		driver.findElement(By.xpath("//input[@id='kb_knowledge.short_description']")).sendKeys("IT-Java");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();

	}

}
