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
		int b = Integer.parseInt(getBusquedaProducto("iphone","paging.limit"));
		int a = Integer.parseInt(cantidadDeProductosSinExcederElLimiteDePaginado("iphone"));
		Assert.assertTrue(a<=b);
		
	}
	
	@Test
	public void totalDeProductos() {
		String str  = getBusquedaProducto("fender","results.title");
		Assert.assertTrue(str.contains(detalleProductoPorId("MLA795566984")));
		
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
