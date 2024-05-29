package OpenCart;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class testSearch {
    private WebDriver driver;
    private WebDriverWait wait;

    @Test
    @Tag("BUSQUEDA")
    @Tag("EXITOSA")
    public void test_BusquedaExitosa() throws InterruptedException {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        SearchPage searchPage = new SearchPage(driver, wait);
        searchPage.setup();
        searchPage.getUrl("https://opencart.abstracta.us/index.php?route=common/home");

        searchPage.completarBusqueda("iphone");

        searchPage.clickBuscar();
        searchPage.addCart();


        String resultado = searchPage.alertSuccess();

        // Compara el resultado con el texto esperado
        assertEquals("Success: You have added iPhone to your shopping cart!\n" +
                "×", resultado);
        searchPage.close();

    }


}