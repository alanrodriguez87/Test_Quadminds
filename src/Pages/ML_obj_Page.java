package Pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ML_obj_Page extends BasePage{
	
	@FindBy(how = How.CSS, using = ".nav-search-input")
	protected  WebElement barra_busqueda;
	
	@FindBy(how = How.CSS, using = ".nav-menu-categories-link")
	protected WebElement tab_categorias;
	
	@FindBy(how = How.CSS, using = ".nav-categs-departments")
	protected WebElement categorias;
	
	@FindBy(how = How.CSS, using = ".nav-categs-detail__categ-list")
	protected WebElement subCategorias;
	
	@FindBy(how = How.CSS, using = ".nav-categs-detail__title")
	protected WebElement subCategoriasTitulos;
	
	@FindBy(how = How.CSS, using = ".breadcrumb__title")
	protected WebElement nombreProducto;
	
	@FindBy(how = How.CSS, using = ".quantity-results")
	protected WebElement cantidadResultado;
	
	@FindBy(how = How.CSS, using = "[class='ico grid']")
	protected WebElement botonGrilla;
	
	@FindAll({ @FindBy(css = "[id='searchResults'] [class='item-link item__js-link']") })
	protected List<WebElement> elementosGrilla;
	
	@FindBy(how = How.CSS, using = ".ui-dropdown__link")
	protected WebElement botonOrdenarPor;
	
	@FindAll({ @FindBy(css = "[id='searchResults'] li ") })
	protected List<WebElement> cardsProductos;
	
	@FindAll({ @FindBy(css = "[id='id_state'] [class='filter-name']") })
	protected List<WebElement> localidades;
	
	@FindBy(how = How.CSS, using = ".text-shipping.same_day")
	protected List<WebElement> llegaHoy;
	
	@FindBy(how = How.CSS, using = ".rowItem.item.highlighted.item--grid.item--has-row-logo.new")
	protected List<WebElement> articulosAzar;
	
	@FindBy(how = How.CSS, using = ".categories__subtitle")
	protected List<WebElement> listaCategorias;

	@FindBy(how = How.CSS, using = ".spotlight__switch-bar.spotlight__switch--off")
	protected WebElement botonSwitchEntrega;
	
	@FindBy(how = How.CSS, using = ".item-title")
	protected WebElement tituloPublicacion;
	
	@FindBy(how = How.CSS, using = "[class='layout-description-wrapper'] [class='price-tag']")
	protected WebElement precioPublicacion;
	
}
