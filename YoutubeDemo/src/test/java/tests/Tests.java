package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Tests extends BaseClass {

	@Test
	public void testSearch() {
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Search\"]")).click();
		driver.findElement(By.id("com.google.android.youtube:id/search_edit_text")).sendKeys("minions 2015 memorable moments");
		driver.findElement(By.id("com.google.android.youtube:id/text")).click();
		
	}
}
