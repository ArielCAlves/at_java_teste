package org.example.at4automationexercisetest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.example.at4automationexercisetest.pages.LoginPage;
import org.example.at4automationexercisetest.pages.SignUpPage;
import org.example.at4automationexercisetest.pages.LogoutPage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AutomationExerciseTests {

    private static WebDriver driver;
    private static LoginPage loginPage;
    private static SignUpPage signUpPage;
    private static LogoutPage logoutPage;
    private static String email;
    private static final String senha = "senha123";

    @BeforeAll
    static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        signUpPage = new SignUpPage(driver);
        logoutPage = new LogoutPage(driver);
    }

    @AfterEach
    void captureScreenshotOnFailure(TestInfo testInfo) throws IOException {
        if (testInfo.getTags().contains("failed")) {
            var screenshot = ((org.openqa.selenium.TakesScreenshot) driver)
                    .getScreenshotAs(org.openqa.selenium.OutputType.BYTES);
            Files.write(Paths.get("screenshots/" + testInfo.getDisplayName() + ".png"), screenshot);
        }
    }

    @AfterAll
    static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @Order(1)
    void deveCadastrarNovoUsuarioComSucesso() {
        email = "teste" + System.currentTimeMillis() + "@email.com";
        signUpPage.abrir();
        signUpPage.preencherFormularioCompleto("Teste", email, senha);
        assertTrue(signUpPage.verificarCadastroComSucesso());
    }

    @Test
    @Order(2)
    void deveFinalizarCadastroEVoltarParaLogin() {
        logoutPage.finalizarCadastroELogout();
        assertTrue(logoutPage.verificarPaginaLogin());
    }

    @Test
    @Order(3)
    void deveLogarComCredenciaisValidas() {
        loginPage.abrir();
        loginPage.login(email, senha);
        assertTrue(loginPage.verificarLoginComSucesso());
    }

    @Test
    @Order(4)
    void deveFinalizarCadastroEVoltarParaLoginNovamente() {
        logoutPage.finalizarCadastroELogout();
        assertTrue(logoutPage.verificarPaginaLogin());
    }

    @Test
    @Order(5)
    void naoDeveLogarComCredenciaisInvalidas() {
        loginPage.abrir();
        loginPage.login("emailErrado@email.com", "senhaErrada");
        assertTrue(loginPage.verificarMensagemErro());
    }
}