package OpenCart;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testRegister {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeAll
    public static void createReport() {
        System.out.println("<<< COMIENZAN LOS TEST DE REGISTRO >>>");
    }

    @BeforeEach
    public void setUp() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(options);        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        RegisterPage registerPage = new RegisterPage(driver, wait);

        registerPage.setup();
        registerPage.getUrl("https://opencart.abstracta.us/index.php?route=common/home");


    }


    @Test
    @Tag("REGISTRO")
    @Tag("EXITOSO")
    public void probandoBotones() throws InterruptedException {
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.clickCrearCuenta();
        registerPage.clickRegister();


        registerPage.escribirNombre("123123");
        registerPage.escribirApellido("3123123");
        registerPage.escribirCorreo("asdasdlasldmasd@gmail.com");
        registerPage.escribirTelephone("123456");
        registerPage.escribirContraseña("123456");
        registerPage.repetirContraseña("123456");
        registerPage.btnRadio();
        registerPage.boxAgree();
        registerPage.clickRegistrarse();

        String resultado = registerPage.validaMailObligatorio();

        // Compara el resultado con el texto esperado
        assertEquals("Congratulations! Your new account has been successfully created!", resultado);



    }


    @AfterEach
    public void cerrar() {
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.close();
    }

    @AfterAll
    public static void saveReport() {
        System.out.println("<<< FINALIZAN LOS TEST DE REGISTRO >>>");
    }
}
