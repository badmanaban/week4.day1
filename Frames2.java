package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames2 {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		WebElement findElement = driver.findElement(By.xpath("//iframe"));
		driver.switchTo().frame(findElement);
		
		WebElement fE = driver.findElement(By.xpath("//button[@id='Click']"));
		File sh = fE.getScreenshotAs(OutputType.FILE);
		File dst = new File("./snap/sh1.png");
		FileUtils.copyFile(sh, dst);
		
		driver.switchTo().defaultContent();
		List<WebElement> frames = driver.findElements(By.xpath("//iframe"));
		int size = frames.size();
		System.out.println(size);
	}

}
