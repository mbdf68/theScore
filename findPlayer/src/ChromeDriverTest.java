
import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverTest {

	private WebDriver driver;	
	@Before
	public void setUp() throws Exception {
        	
		// Set path for Chrome Driver executable
		System.setProperty("webdriver.chrome.driver", "/usr/local/jar/chromedriver");
            
		// Launch ChromeDriver
		driver = new ChromeDriver();
	}
    	
	@Test
	public void test1() throws MalformedURLException, InterruptedException { 
		
		// 1. Navigate to http://www.thescore.com
		driver.get("http://www.thescore.com");
		
		// 2. Verify the URL is correct
		List<WebElement> list = driver.findElements(By.className("icon-menu"));
		assertTrue("menu not found and page is not loaded successfully!", list.size() > 0);
    				
		// 3. Click on the main menu button
		driver.findElement(By.className("icon-menu")).click();
    		
		Thread.sleep(3000);
    		
		// 4. Click on “EPL Soccer”
		driver.findElement(By.linkText("NFL Football")).click();
    		
		//driver.findElement(By.linkText("NFL News")).click();
    		
		// 5. Click on “Leaders”
		//driver.findElement(By.linkText("Leaders")).click();
    		
		// 6. Click on a random player
		// 7. Verify that the height and birthdate display correctly (fields exist, proper format, etc)

	} 

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}

