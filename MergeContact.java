package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Merge Contacts')]")).click();
		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[1]")).click();
		Thread.sleep(3000);
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> l = new ArrayList<String>(windowHandles);
		driver.switchTo().window(l.get(1));

		driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
		driver.switchTo().window(l.get(0));
		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();
		Thread.sleep(3000);
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> l1 = new ArrayList<String>(windowHandles1);
		driver.switchTo().window(l1.get(1));
		// Thread.sleep(3000);
		WebElement fe = driver.findElement(By.xpath("((//table)[5]/tbody/tr/td)[1]/div/a"));
		fe.click();
		driver.switchTo().window(l.get(0));
		Thread.sleep(3000);

		driver.findElement(By.xpath("(//a[contains(text(),'Merge')])[2]")).click();

		Alert alert = driver.switchTo().alert();
		alert.accept();

		 if (driver.getTitle().contains("Contact")) {
		 System.out.println("you are in view contacts page");

		 }
	}

}
