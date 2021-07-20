package functionality;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Browser_setup {

	WebDriver driver;

	public String open_Chrome_browser(String URL) {
		System.setProperty("webdriver.chrome.driver",
				"H:\\Tarun-Workspace\\Tarun-Workspace\\Simple_POM_Project\\Testing_data\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(URL);
		return URL;
	}

	public String open_firefox_browser(String URL) {
		System.setProperty("webdriver.gecko.driver",
				"H:\\Tarun-Workspace\\Tarun-Workspace\\Simple_POM_Project\\Testing_data\\geckodriver.exe");

		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--js-flags=--expose-gc");
		options.addArguments("--enable-precise-memory-info");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-default-apps");
		driver = new FirefoxDriver(options);
		driver.get(URL);
		return URL;

	}

	public String open_Edge_browser(String URL) {
		System.setProperty("webdriver.edge.driver",
				"H:\\Tarun-Workspace\\Tarun-Workspace\\Simple_POM_Project\\Testing_data\\msedgedriver.exe");

		driver = new EdgeDriver();
		driver.get(URL);
		return URL;

	}

	public void close_Browser() {
		driver.close();
	}

	public void hold_browser() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public String URL_status(String URL) throws MalformedURLException, IOException 
	{
		HttpURLConnection c = (HttpURLConnection) new URL(URL).openConnection();
		// set the HEAD request with setRequestMethod
		c.setRequestMethod("HEAD");
		// connection started and get response code
		c.connect();
		int r = c.getResponseCode();
		System.out.println("Http response code: " + r);

		return URL;
	}

}
