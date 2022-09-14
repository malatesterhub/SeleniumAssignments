package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Leaftaps 
{

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver chrome=new ChromeDriver();
		chrome.get("http://leaftaps.com/opentaps/control/main");
		chrome.manage().window().maximize();
		chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		chrome.findElement(By.xpath("//input[@id='username']")).sendKeys("demosalesmanager");
		chrome.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		chrome.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		chrome.findElement(By.linkText("CRM/SFA")).click();
		chrome.findElement(By.linkText("Leads")).click();
		chrome.findElement(By.linkText("Find Leads")).click();
		chrome.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Manimala");
		chrome.findElement(By.xpath("//button[text()='Find Leads']")).click();
		chrome.findElement(By.xpath("//a[text()='10384']")).click();
		String title = chrome.getTitle();
		System.out.println(title);
		chrome.findElement(By.xpath("//a[text()='Edit']")).click();	
		chrome.findElement(By.id("updateLeadForm_companyName")).clear();
		chrome.findElement(By.id("updateLeadForm_companyName")).sendKeys("Test");
		chrome.findElement(By.xpath("(//input[@name='submitButton'])[1]")).click();	
		String companyName = chrome.findElement(By.xpath("//span[text()='Test (10384)']")).getText();
		if(companyName.contains("Test"))
				{
					System.out.println("Company name matched");
				}
		
		chrome.close();
	}

}
