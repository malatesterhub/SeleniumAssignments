package marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	/*
	 * Testcase 1 (Amazon) 01) Launch Chome 02) Load https://www.amazon.in/ 03) Type
	 * "Bags" in the Search box 04) Choose the displayed item in the result with
	 * bags for boys 05) Print the total number of results (like 30000) 1-48 of over
	 * 30,000 results for "bags for boys" 06) Select the first 2 brands in the left
	 * menu (like American Tourister, Generic) 07) Confirm the results have got
	 * reduced like 5000 &30,000 (use step 05 for compare) 08) Choose New Arrivals
	 * (Sort) 09) Print the first resulting bag info (name, discounted price) 10)
	 * Take screenshot and close
	 */
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bags");
		driver.findElement(By.xpath("//span[text()=' for boys']")).click();
		String bagCount = driver.findElement(By.xpath("//div[@id='search']/span[1]/div[1]/h1[1]/div[1]/div[1]/div[1]/div[1]/span[1]")).getText();
		System.out.println(bagCount + " bags for boys");
		driver.findElement(By.xpath("(//div[contains(@class,'a-checkbox a-checkbox-fancy')]/following-sibling::span)[3]")).click();
		Thread.sleep(5);
		driver.findElement(By.xpath("//span[text()='Generic']")).click();
		String genAmeBagCount = driver.findElement(By.xpath("//div[@id='search']/span[1]/div[1]/h1[1]/div[1]/div[1]/div[1]/div[1]/span[1]")).getText();
		System.out.println(genAmeBagCount + " bags for boys");
		String splitedBagCount = bagCount.split(" ")[3].replaceAll(",", "");
		String splitedGenAmeBagCount = genAmeBagCount.split(" ")[3].replaceAll(",", "");
		System.out.println("splitedBagCount:" +splitedBagCount+", splitedGenAmeBagCount:" + splitedGenAmeBagCount);
		int count1=Integer.parseInt(splitedBagCount);
		int count2=Integer.parseInt(splitedGenAmeBagCount);
		if(count1==count2)
		{
			System.out.println("Both bags counts are equal");
		}
		else
		{
			System.out.println("Both bags counts are not equal");
		}
		driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
		driver.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();
		driver.findElement(By.xpath("//a[@class='a-link-normal s-no-outline']//div")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> list=new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));
		System.out.println(driver.findElement(By.id("productTitle")).getText());
		System.out.println(driver.findElement(By.className("a-price-whole")).getText());
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./snaps/screenshort.png");
		FileUtils.copyFile(source, dest);
	}
	
}
