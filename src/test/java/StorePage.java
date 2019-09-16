import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class StorePage {

	WebDriver driver;

	public StorePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	String receiptItemPath = "//table[2]/tbody/tr/th[contains(text(),";

	@FindBy(id = "buyAmount")
	WebElement amountTextbox;

	@FindBy(css = "button.btn")
	WebElement buyButton;

	@FindBy(id = "totalVAT")
	WebElement resultAmt;

	public void buy(String buyItem, int amt) {
		Select item = new Select(driver.findElement(By.cssSelector(".form-control")));
		item.selectByVisibleText(buyItem);
		amountTextbox.sendKeys(String.valueOf(amt));
		buyButton.click();
	}

	public void sell(String sellItem) {
		String sellItemReceiptPath = receiptItemPath + sellItem + ")]";
		driver.findElement(By.xpath(sellItemReceiptPath + "/following-sibling::th//button")).click();

	}

	public String getResultAmt(String buyItem) {
		String buyItemReceiptPath = receiptItemPath + buyItem + ")]";
		return driver.findElement(By.xpath(buyItemReceiptPath + "/following-sibling::th")).getText();
	}

	public boolean doesItemExists(String sellItem) {
		String sellItemReceiptPath = receiptItemPath + sellItem + ")]";
		int sellItemSize = driver.findElements(By.xpath(sellItemReceiptPath + "/following-sibling::th")).size();

		if (sellItemSize == 0)
			return false;
		else
			return true;
	}

}