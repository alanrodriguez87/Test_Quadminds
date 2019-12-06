package Tests;




import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.BasePage;
import Pages.ML_Page;

public class Front extends BasePage {
		

	@BeforeMethod
	public void SetUp() {
		IniciarBrowser();
		IngresarML();
		
	}
	
	//@AfterMethod
	public void exit() {
		driver.close();
		driver.quit();
	}
	
		
		@Test
		public void Ejercicio01_Ts01() {
			ML_Page MLP = new ML_Page(driver);
			MLP.seleccionarCategoria("Hogar y Electrodomésticos");
		    MLP.seleccionarSubCategoria("Climatización");
		    MLP.validacionTituloProductoYCantidad();
		}
		

		@Test
		public void Ejercicio01_Ts02() {
			ML_Page MLP = new ML_Page(driver);
			MLP.seleccionarCategoria("Tecnología");
		    MLP.seleccionarSubCategoria("Celulares y Smartphones");
		    MLP.validacionTituloProductoYCantidad();
		    MLP.verificarCantidadGrilla();
		    
		    
		}

		//No Se Encuentra la SubCategoria Paletas. Por lo cual se modifico, el caso y su forma de busqueda.
		
		@Test 
		public void Ejercicio01_Ts03() {
			ML_Page MLP = new ML_Page(driver);
			MLP.seleccionarCategoria("Ver más categorías");
			MLP.buscarEntreTodosLosProductos("Instrumentos de Cuerdas");
			MLP.validacionTituloProductoYCantidad();
		    MLP.switchButtonEntrega();
		    MLP.entregaHoy();
	   
		}
		

		@Test
		public void Ejercicio01_Ts04() {
			ML_Page MLP = new ML_Page(driver);
			MLP.seleccionarCategoria("Herramientas e Industrias");
		    MLP.seleccionarSubCategoria("Industria Textil");
		    MLP.validacionTituloProductoYCantidad();
		    MLP.ordernarItemsPor("Mayor precio");
		    MLP.devolverPrimerYUltimoProductoOrdenado();

		}
		

		@Test
		public void Ejercicio01_Ts05() {
			ML_Page MLP = new ML_Page(driver);
			MLP.seleccionarCategoria("Juguetes y Bebés");
			MLP.seleccionarSubCategoriaTitulo("Cuarto del Bebé");
		    MLP.validacionTituloProductoYCantidad();
		    
		  
		}

		@Test
		public void Ejercicio02() { 
			ML_Page MLP = new ML_Page(driver);
			MLP.buscarProducto("gibson");
		    MLP.elegirUbicacion("Capital Federal");
		    MLP.articuloAlAzar();
		    sleep(3000);
		    MLP.tituloDetalle();
		    MLP.precioDetalle();
		    Assert.assertTrue(MLP.verificarPrecioYTitulo());
		   }

}

