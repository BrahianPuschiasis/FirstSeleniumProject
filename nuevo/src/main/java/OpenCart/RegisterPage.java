package OpenCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage{


    private By btnMyAccount = By.cssSelector("[title='My Account']");

    private By btnRegister = By.linkText("Register");


    private By nombre = By.id("input-firstname");
    private By apellido = By.id("input-lastname");
    private By email = By.id("input-email");

    private By telephone = By.id("input-telephone");
    private By password = By.id("input-password");
    private By repassword = By.id("input-confirm");


    private By radioNo = By.cssSelector("input[name='newsletter'][value='0']");

    private By checkboxAgree = By.cssSelector("input[name='agree'][value='1']");

    private By btnContinue = By.cssSelector("input.btn.btn-primary");

    private By successMessage = By.xpath("//div[@id='content']/p[text()='Congratulations! Your new account has been successfully created!']");


    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, null);
    }

    public void btnRadio() throws InterruptedException {
        this.click(radioNo);
        Thread.sleep(1000); // Considera reemplazar esto con una espera explícita
    }

    public void boxAgree() throws InterruptedException {
        this.click(checkboxAgree);
        Thread.sleep(1000); // Considera reemplazar esto con una espera explícita
    }



    public void clickCrearCuenta() throws InterruptedException {
        this.click(btnMyAccount);
    }
    public void clickRegister() throws InterruptedException {
        this.click(btnRegister);
    }

    public void escribirNombre(String name) throws InterruptedException {
        this.sendText(name, nombre);
    }


    public void escribirApellido(String name) throws InterruptedException {
        this.sendText(name, apellido);
    }

    public void escribirTelephone(String name) throws InterruptedException {
        this.sendText(name, telephone);
    }


    public void escribirCorreo(String mail) throws InterruptedException {
        this.sendText(mail, email);
    }


    public void escribirContraseña(String pass) throws InterruptedException {
        this.sendText(pass, password);
    }

    public void repetirContraseña(String pass) throws InterruptedException {
        this.sendText(pass, repassword);
    }


    public void clickRegistrarse() throws InterruptedException {
        this.click(btnContinue);
        Thread.sleep(1000); // Considera reemplazar esto con una espera explícita
    }



    public String validaMailObligatorio() throws InterruptedException {
        System.out.println("Se valida mensaje de cuenta creada: " + this.getText(successMessage));
        return this.getText(successMessage);
    }



}
