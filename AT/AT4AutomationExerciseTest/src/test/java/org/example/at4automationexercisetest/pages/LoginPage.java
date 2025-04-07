package org.example.at4automationexercisetest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By campoEmail = By.cssSelector("[data-qa='login-email']");
    private By campoSenha = By.cssSelector("[data-qa='login-password']");
    private By botaoLogin = By.cssSelector("[data-qa='login-button']");
    private By textoBemVindo = By.xpath("//a[contains(text(),'Logged in as')]");
    private By mensagemErro = By.xpath("//p[contains(text(),'incorrect')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void abrir() {
        driver.get("https://automationexercise.com");
        driver.findElement(By.linkText("Signup / Login")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoEmail));
    }

    public void login(String email, String senha) {
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(campoEmail));
        WebElement senhaInput = wait.until(ExpectedConditions.visibilityOfElementLocated(campoSenha));
        WebElement botao = wait.until(ExpectedConditions.elementToBeClickable(botaoLogin));

        emailInput.clear();
        senhaInput.clear();
        emailInput.sendKeys(email);
        senhaInput.sendKeys(senha);
        botao.click();
    }

    public boolean verificarLoginComSucesso() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(textoBemVindo)).isDisplayed();
    }

    public boolean verificarMensagemErro() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(mensagemErro)).isDisplayed();
    }
}
