package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import Utilities.ApiConnection;


public class Backend extends ApiConnection{
	
	@Test 
	public void totalDeProductosEncontrados() {
		String Resultados = getBusquedaProducto("iphone","results.id");
		System.out.println(Resultados);
	}
	
	@Test 
	public void cantidadDeProductosEncontradosSinExcederElLimiteDePaginado() {
		getBusquedaProducto("iphone","paging.limit");
		Assert.assertTrue(cantidadDeProductosSinExcederElLimiteDePaginado("iphone").equals(getBusquedaProducto("iphone","paging.limit")));
		
	}
	
	@Test
	public void totalDeProductos() {
		String str  = getBusquedaProducto("iphone","results.title");
		Assert.assertTrue(str.contains(detalleProductoPorId("MLA827896003")));
		
	}
	
	@Test
	public void ValidarApisEntreSi() {
		String producto = "fender";
		busquedaProducto(producto);
		getBusquedaCamposPorIdRandom();
		Assert.assertTrue(validacionAlAzarEntreApis());
		
	}
		
		
		
//	
		
	
}
