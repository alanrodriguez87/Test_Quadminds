package Utilities;


import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class ApiConnection {
	
	
	public String IDs;	
	public String IdRandom;	
	public String TituloID;
	public String PrecioID;
	public String AceptaMercadoPagoID;
    public String MonedaID;
    public String EnviogratisID;
    public String titulo;
    public String precio;
    public String MercadoPago;
    public String Moneda;
    public String Envio;	
	protected Random aleatorio = new Random();	
	   
	public String getBusquedaProducto(String item, String path) {
	        Response response = given()
	                .when()
	                .get("https://api.mercadolibre.com/sites/MLA/search?q="+item);
	        String responseValues = response.getBody().asString();
	        JsonPath jsonPath = new JsonPath(responseValues);
	        String dato = jsonPath.getString(path);
	        boolean a = !path.isEmpty();
	        System.out.println("Producto Encontrado :"+ a);
	        //System.out.println(path + ": "+ dato);
	        return dato;

	    }
	  
	    
	    public String cantidadDeProductosSinExcederElLimiteDePaginado(String item) {
	        Response response = given()
	                .when()
	                .get("https://api.mercadolibre.com/sites/MLA/search?q="+item);
	        String responseValues = response.getBody().asString();
	        JsonPath jsonPath = new JsonPath(responseValues); 
	        String str  = jsonPath.getString("results.id"); 
	        ArrayList <String> Productos = new ArrayList<String> (Arrays.asList(str.split(",")));
	        System.out.println("Cantidad de productos Encontrados : "+ Productos.size());
	        return Integer.toString(Productos.size());

	       
	    }
	    
	    public String detalleProductoPorId(String ID) {
	        Response response = given()
	                .when()
	                .get("https://api.mercadolibre.com/items/"+ID);
	        String responseValues = response.getBody().asString();
	        JsonPath jsonPath = new JsonPath(responseValues);
	        String dato = jsonPath.getString("title");
	        System.out.println(dato);
	        return dato;
	    }
	    
	    public String response(String item) {
			Response response = given()
					.when()
					.get("https://api.mercadolibre.com/sites/MLA/search?q="+item);
			String responseValues = response.getBody().asString();
			System.out.println(responseValues);
			return responseValues;
	    }
	    
	    public String path(String response, String path, int index) {
	    	JsonPath jsonPath = new JsonPath(response);
			String[] PathArray = jsonPath.getString("results."+path).split(",");
			return PathArray[index];
		}
	    
	    
	    public String busquedaProducto(String item) {    
		    String response = response(item);
			int limitAPI = Integer.parseInt(cantidadDeProductosSinExcederElLimiteDePaginado(item));	
			int rand = aleatorio.nextInt(limitAPI-1);
			titulo = path(response, "title", rand);
			precio = path(response, "price", rand);
			MercadoPago = path(response,"accepts_mercadopago",rand);
			Moneda = path(response,"currency_id",rand);
			Envio = path(response,"shipping.free_shipping",rand);
			IdRandom = path(response,"id",rand);
			IdRandom = IdRandom.replaceAll(" ", "");
			return item;
		    }   
	    
	    public void getBusquedaCamposPorIdRandom() {
	        Response response = given()
	                .when()
	                .get("https://api.mercadolibre.com/items/"+IdRandom);
	        String responseValues = response.getBody().asString();
	        JsonPath jsonPath = new JsonPath(responseValues);
	        TituloID = jsonPath.getString("title");
	        PrecioID = jsonPath.getString("price");
	        AceptaMercadoPagoID = jsonPath.getString("accepts_mercadopago");
	        MonedaID = jsonPath.getString("currency_id");
	        EnviogratisID = jsonPath.getString("shipping.free_shipping");
	        
	    
	    }
	    	public boolean validacionAlAzarEntreApis() {
	    		boolean a = titulo.replaceAll(" ", "").equals(TituloID.replaceAll(" ", ""));
	    		boolean b = precio.replaceAll(" ", "").equals(PrecioID.replaceAll(" ", ""));
	    		boolean c = MercadoPago.replaceAll(" ", "").equals(AceptaMercadoPagoID.replaceAll(" ", ""));
	    		boolean d = Moneda.replaceAll(" ", "").equals(MonedaID.replaceAll(" ", ""));
	    		boolean e = Envio.replaceAll(" ", "").equals(EnviogratisID.replaceAll(" ", ""));
//	    		System.out.println(IdRandom);
//	    		System.out.println(titulo);
//	    		System.out.println(TituloID);
//	    		System.out.println(precio);
//	    		System.out.println(PrecioID);
//	    		System.out.println(MercadoPago);
//	    		System.out.println(AceptaMercadoPagoID);
//	    		System.out.println(Moneda);
//	    		System.out.println(MonedaID);
//	    		System.out.println(Envio);
//	    		System.out.println(EnviogratisID);
	    		return a && b && c && d && e;
	    	}
	    
	    
	    
	    
	
}