package OpenCart;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("LOGIN")
public class testLogin {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeAll
    public static void run() {
        System.out.println("<<< COMIENZAN LOS TEST DE LOGIN >>>");
    }

    @BeforeEach
    public void precondiciones() throws InterruptedException {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.setup();
        loginPage.getUrl("https://digital-booking-front.digitalhouse.com/login");
    }

    @Test
    @Tag("EXITOSO")
    @Order(4)
    public void test_LogueoExitosa() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, wait);

        loginPage.completarMail("targ5181@gmail.com");
        loginPage.completarContraseña("Admin123.");
        loginPage.clickIngresar();

        String nombre = loginPage.nombreLogueado();
        assertTrue(nombre.equals("Tania Rodriguez"));
    }

    @Test
    @Tag("FALLIDO")
    @Order(3)
    public void test_LogueoMailVacio() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, wait);

        loginPage.completarMail("");
        loginPage.completarContraseña("Admin123.");

        String valida = loginPage.validaMailObligatorio();
        assertTrue(valida.equals("Este campo es obligatorio"));
    }

    @Test
    @Tag("FALLIDO")
    @Order(2)
    public void test_LogueoContraseñaVacio() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, wait);

        loginPage.completarMail("targ5181@gmail.com");
        loginPage.completarContraseña("");
        loginPage.clickIngresar();

        String valida = loginPage.validaPassObligatorio();
        assertTrue(valida.equals("Este campo es obligatorio"));
    }

    @Test
    @Tag("FALLIDO")
    @Order(1)
    public void test_LogueoMailInvalido() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, wait);

        loginPage.completarMail("targ5181");
        loginPage.completarContraseña("Admin123.");

        String valida = loginPage.validaMensajeInvalido();
        assertTrue(valida.equals("El email es inválido"));
    }

    @AfterEach
    public void endTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.close();
    }

    @AfterAll
    public static void finish() {
        System.out.println("<<< FINALIZAN LOS TEST DE LOGIN >>>");
    }
}
