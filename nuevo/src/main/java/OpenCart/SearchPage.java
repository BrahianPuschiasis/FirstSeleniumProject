package OpenCart;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BasePage {
    private By searchBox = By.cssSelector("input[name='search']");
    private By searchButtom = By.cssSelector("button.btn.btn-default.btn-lg");
    private By validateSearch = By.className("categoria");

    private By addToCart = By.cssSelector("button[onclick=\"cart.add('40', '1');\"]");

    private By alertSuccess = By.cssSelector("div.alert.alert-success.alert-dismissible");


    public SearchPage(WebDriver driver, WebDriverWait wait) {
        super(driver, null);
    }

    /** Completa la búsqueda con la ciudad especificada.
     * @param item La ciudad a buscar.
     * @throws InterruptedException Si ocurre un error durante la espera.
     */
    public void completarBusqueda(String item) throws InterruptedException {
        this.sendText(item, searchBox);
        this.sendKey(Keys.ENTER, searchBox);
    }

    /** Hace click en el botón de búsqueda.
     * @throws InterruptedException Si ocurre un error durante la espera.
     */
    public void clickBuscar() throws InterruptedException {
        this.click(searchButtom);
    }

    public void addCart() throws InterruptedException {
        this.click(addToCart);
    }


    /** Obtiene el resultado de la búsqueda.
     * @return El texto del resultado de la búsqueda.
     * @throws InterruptedException Si ocurre un error durante la espera.
     */
    public String alertSuccess() throws InterruptedException {
        System.out.println("RESULTADO DE LA BUSQUEDA: " + this.getText(alertSuccess));
        return this.getText(alertSuccess);
    }
}