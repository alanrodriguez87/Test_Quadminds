package Pages;

	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

	import Utilities.SetConnection;

	public class BasePage {
		
		protected WebDriver driver;
		protected WebDriverWait wait;
			
		public void IniciarBrowser() 
		{
		
			this.driver = SetConnection.setup();
			wait = new WebDriverWait(driver, 10);
					
		}
		
		public void IngresarML() {
			driver.get("https://www.mercadolibre.com.ar");
			
			
		}
		
		public static void sleep (long milisec) {
			try {
				
				Thread.sleep(milisec);			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		public void waitForElementVisible(WebElement we, int segundos) {
			WebDriverWait wait = new WebDriverWait(driver, segundos);		
			wait.until(ExpectedConditions.visibilityOf(we));		
		}
}
