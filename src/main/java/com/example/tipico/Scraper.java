package com.example.tipico;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;


public class Scraper {
	private WebDriver driver;

	public Scraper() {
		System.setProperty("webdriver.chrome.driver", "src/main/java/com/example/utils/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*", "--start-maximized");
		driver = new ChromeDriver(options);
//		WebDriverManager.getInstance(CHROME).setup();
//		driver.get("https://www.tipico-careers.com/en/jobs/");
	}

	public List<Job> scrapeJobs() {
		driver.get("https://www.tipico-careers.com/en/jobs/");
		List<WebElement> jobElements = driver.findElements(By.xpath("//div[@class='jobs-wrapper']//div[@class='job-item']"));
		List<Job> jobs = new ArrayList<>();
		for (WebElement jobElement : jobElements) {
			String title = jobElement.findElement(By.className("job-title")).getText();
			String department = jobElement.findElement(By.className("job-department")).getText();
			String location = jobElement.findElement(By.className("job-location")).getText();
			Job job = new Job(title, department, location);
			jobs.add(job);
		}
		return jobs;
	}

	public void close() {
		driver.quit();
	}
}