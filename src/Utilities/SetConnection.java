package Utilities;

	
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;

	public class SetConnection {
			static WebDriver driver;
			
			public static WebDriver setup() {
				
				//Se comenta la inicializacion ya que el driver lo toma desde el system32, lo cual evita problemas de versiones del driver.
				
				System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
			    ChromeOptions options = new ChromeOptions();
			    
			    //Inicia el browser maximizado
			    options.addArguments("start-maximized");
			    
			    // ¡¡¡¡ATENCION!!!!
			    // Seteo handless y Window-size Comentar los siguientes argumentos para poder visualizar los browsers
			     
			   
			    //Se escala para evitar NosuchElement
			    //options.addArguments("window-size=1920,1080");
			    
			    
			    //Se ejecuta todo en memoria interna sin necesidad de visualizar los browsers
			    //options.addArguments("headless");
			    
			    
			    driver = new ChromeDriver(options);
			    
			    
				
			    return driver;
			    
			    
			
		}
}
