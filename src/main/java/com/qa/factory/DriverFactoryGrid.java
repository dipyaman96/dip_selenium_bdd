package com.qa.factory;


import org.openqa.selenium.WebDriver;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactoryGrid {

	public WebDriver driver;

	//public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	public static ThreadLocal<RemoteWebDriver> tlDriver = new ThreadLocal<>();

	/**
	 * This method is used to initialize the thradlocal driver on the basis of given
	 * browser
	 * 
	 * @param browser
	 * @return this will return tldriver.
	 * @throws MalformedURLException 
	 */
	public WebDriver init_driver(String browser) throws MalformedURLException {

		System.out.println("browser value is: " + browser);

		if (browser.equals("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			tlDriver.set(new ChromeDriver());
			
			DesiredCapabilities cap= DesiredCapabilities.chrome();
			URL url=new URL("http://localhost:4444/wd/hub");
			tlDriver.set(new RemoteWebDriver(url,cap));
			
		} else if (browser.equals("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			tlDriver.set(new FirefoxDriver());
			
			DesiredCapabilities cap= DesiredCapabilities.firefox();
			URL url=new URL("http://localhost:4444/wd/hub");
			tlDriver.set(new RemoteWebDriver(url,cap));
			
		} else if (browser.equals("safari")) {
//			tlDriver.set(new SafariDriver());
			
			DesiredCapabilities cap= DesiredCapabilities.edge();
			URL url=new URL("http://localhost:4444/wd/hub");
			tlDriver.set(new RemoteWebDriver(url,cap));
			
		} else {
			System.out.println("Please pass the correct browser value: " + browser);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();

	}

	/**
	 * this is used to get the driver with ThreadLocal
	 * 
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
}
