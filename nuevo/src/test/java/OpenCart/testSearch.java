package OpenCart;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class testSearch {
    private WebDriver driver;
    private WebDriverWait wait;


    @BeforeAll
    public static void createReport() {
        System.out.println("<<< COMIENZAN LOS TEST DE BUSCAR >>>");
    }


    @Test
    @Tag("BUSQUEDA")
    @Tag("EXITOSA")
    public void test_BusquedaExitosa() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(options);        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
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

    }

    @AfterEach
    public void cerrar() {
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.close();
    }

    @AfterAll
    public static void saveReport() {
        System.out.println("<<< FINALIZAN LOS TEST DE BUSCAR >>>");
    }


}