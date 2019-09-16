import org.junit.Assert;
import org.junit.Test;

public class StorePageTest extends BaseTest {

	@Test
	public void testBuyAndSellApple() {
		verifyBuyProduct("Apple", 20);
		verifySellProduct("Apple");
	}

	@Test
	public void testBuyAndSellBanana() {
		verifyBuyProduct("Banana", 20);
		verifySellProduct("Banana");
	}

	private void verifyBuyProduct(String buyProduct, int Qty) {
		storePage.buy(buyProduct, Qty);
		String boughtAmount = storePage.getResultAmt(buyProduct);
		Assert.assertEquals("Quantity is incorrect", Integer.parseInt(boughtAmount), Qty);
	}

	private void verifySellProduct(String sellProduct) {
		storePage.sell(sellProduct);
		Assert.assertFalse("Item not sold", storePage.doesItemExists(sellProduct));
	}

}
