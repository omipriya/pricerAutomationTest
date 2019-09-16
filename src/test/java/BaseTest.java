import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
	public WebDriver driver;
	public WebDriverWait wait;
	public StorePage storePage;

	@Before
	public void classLevelSetup() {
		// Create a Browser driver. All test classes use this.
		io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://hoff.app/store/");
		storePage = new StorePage(driver);

		// Create a wait. All test classes use this.
		wait = new WebDriverWait(driver, 15);

		// Maximize Window
		driver.manage().window().maximize();
	}

	@After
	public void teardown() {
		driver.close();
		driver.quit();
	}
}