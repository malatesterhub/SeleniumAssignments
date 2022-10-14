package week5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class NewCaller {

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
		filter.sendKeys("Callers");
		shadow.findElementByXPath("//mark[text()='Callers']").click();
		Thread.sleep(3000);
		WebElement eleFrame = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(eleFrame);
		driver.findElement(By.xpath("//button[text()='New']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("sys_user.first_name")).sendKeys("Mani");
		driver.findElement(By.id("sys_user.last_name")).sendKeys("Mala");
		driver.findElement(By.id("sys_user.title")).sendKeys("Title");
		driver.findElement(By.id("sys_user.email")).sendKeys("nmk024@gmail.com");
		driver.findElement(By.id("sys_user.mobile_phone")).sendKeys("9003974649");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		WebElement search = driver.findElement(By.xpath("//input[@class='form-control']"));
		search.sendKeys("Mala");
		search.sendKeys(Keys.ENTER);
		String verify = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		if(verify.contains("Mala"))
		{
			System.out.println("Caller Name Matches");
		}
		else
		{
			System.out.println("Caller Name Not Matches");
		}
		
		
	}

}
