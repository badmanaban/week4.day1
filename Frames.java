package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement frm = driver.findElement(By.xpath("//iframe[@id='frame1']"));
		driver.switchTo().frame(frm);
		driver.findElement(By.xpath("//b[text()='Topic :']/following-sibling::input")).sendKeys("test");
		
		WebElement frm1 = driver.findElement(By.xpath("//iframe[@id='frame3']"));
		driver.switchTo().frame(frm1);
		
		driver.findElement(By.xpath("//input[@id='a']")).click();
		driver.switchTo().defaultContent();
		WebElement frm2 = driver.findElement(By.xpath("(//div[@class='card mb-3']/iframe)[2]"));
		driver.switchTo().frame(frm2);
		
		WebElement findElement = driver.findElement(By.xpath("//select[@id='animals']"));
		Select s = new Select(findElement);
		s.selectByIndex(3);
	}

}
