package Pages;


import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ML_Page extends ML_obj_Page{
		
		public String precio;
		public String titulo;
		public String tituloDetalle;
		public String precioDetalle;
		protected WebDriver driver;
		public ML_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	public void buscarProducto(String producto) {
		barra_busqueda.sendKeys(producto);
		barra_busqueda.submit();
		sleep(1500);
	}
	
	public void seleccionarCategoria(String categoria) {
		Actions action = new Actions(driver);
	    action.moveToElement(tab_categorias).perform();
	    sleep(1500);
	    categorias.findElement(By.xpath("//a[contains(.,'"+categoria+"')]")).click();
	}
	
	
	public void seleccionarSubCategoria(String subCategoria) {
		sleep(1000);
		subCategorias.findElement(By.xpath("//a[contains(.,'"+subCategoria+"')]")).click();
	}
	
	
	public void seleccionarSubCategoriaTitulo(String subCategoria) {
		sleep(1000);
		subCategoriasTitulos.findElement(By.xpath("//a[contains(.,'"+subCategoria+"')]")).click();
	}
	
	
	public void validacionTituloProductoYCantidad() {
		sleep(1000);
		Assert.assertTrue(nombreProducto.isDisplayed());
	    Assert.assertTrue(cantidadResultado.isDisplayed());
	    System.out.println("Nombre del Producto : "+ nombreProducto.getText());
	    System.out.println("Cantidad De Resultados de la Busqueda : "+cantidadResultado.getText());
	}
	
	public void verificarCantidadGrilla()  {
		sleep(1000);
		botonGrilla.click();
	    System.out.println("Cantidad de Items en la grilla : "+elementosGrilla.size());
		
	}
	
	
	public void ordernarItemsPor(String orden) {
		sleep(1000);
		botonOrdenarPor.click();
		sleep(1000);
	    botonOrdenarPor.findElement(By.xpath("//li[contains(.,'"+orden+"')]")).click();
	    sleep(3000);
	}
	
	public void devolverPrimerYUltimoProductoOrdenado() {
		System.out.println(cardsProductos.size());
	    System.out.println(cardsProductos.get(0).findElement(By.cssSelector(".price__fraction")).getText());
	    System.out.println(cardsProductos.get(cardsProductos.size()-1).findElement(By.cssSelector(".price__fraction")).getText());
	}
	
	public void elegirUbicacion(String ubicacion) {
		sleep(1000);
			for(WebElement l : localidades) {
				if(l.getText().equals(ubicacion))
					l.click();
				break;
			}
		sleep(1000);
	}
	
	public Integer randomInt(Integer a) {
		Random r = new Random();
		return r.nextInt(a);
	}
	
	public void entregaHoy() {
		int a = 0;
			for(WebElement c : llegaHoy) {
				if(llegaHoy.get(a).getText().toLowerCase().contains("Llega hoy".toLowerCase()) || llegaHoy.get(a).getText().toLowerCase().contains("Llega gratis hoy".toLowerCase()));
				a++;
			}
		System.out.println("cantidad de entregas :" + a);		
	}
		
		
	public void articuloAlAzar( ) {
		Integer b = randomInt(articulosAzar.size());
		String title = articulosAzar.get(b).findElement(By.cssSelector(".main-title")).getText().trim();
	    String price = articulosAzar.get(b).findElement(By.cssSelector(".price__fraction")).getText().trim();
	    precio = price;
	    titulo = title;
	    articulosAzar.get(b).findElement(By.cssSelector(".main-title")).click();
	}
	
	public Boolean verificarPrecioYTitulo() {
		boolean a =	titulo.toLowerCase().equals(tituloDetalle.toLowerCase());
		boolean b =	precio.equals(precioDetalle);
		System.out.println(precio);
		System.out.println(precioDetalle);
		System.out.println("Verificacion del Titulo : "+ a);
		System.out.println("Verificacion del Precio : "+ b);
		return a && b   ;
	}
	
	public void tituloDetalle() {
		 tituloDetalle = tituloPublicacion.findElement(By.tagName("h1")).getText().trim();
	}
	
	public void precioDetalle() {
		precioDetalle = precioPublicacion.findElement(By.cssSelector(".price-tag-fraction")).getText().trim();
	}
	
	public void buscarEntreTodosLosProductos(String producto) {
		sleep(1000);
			for(WebElement l : listaCategorias) {
				if(l.getText().toLowerCase().equals(producto.toLowerCase())) {
					l.click();
				break;
				}
			}
	}
	
	public void switchButtonEntrega() {
		sleep(1000);
		botonSwitchEntrega.click();
		sleep(1000);
	}
	
		
}
