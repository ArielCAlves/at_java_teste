package org.example.at4automationexercisetest.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void abrir() {
        driver.get("https://automationexercise.com/login");
    }

    public void preencherFormularioCompleto(String nome, String email, String senha) {
        removerPopups();
        esperar(200);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name"))).sendKeys(nome);
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(email);
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        wait.until(ExpectedConditions.urlContains("/signup"));
        esperar(400);
        removerPopups();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1"))).click();
        scrollAte(By.id("password"));
        driver.findElement(By.id("password")).sendKeys(senha);
        driver.findElement(By.id("days")).sendKeys("10");
        driver.findElement(By.id("months")).sendKeys("June");
        driver.findElement(By.id("years")).sendKeys("1990");

        scrollAte(By.id("first_name"));
        driver.findElement(By.id("first_name")).sendKeys(nome);
        driver.findElement(By.id("last_name")).sendKeys(nome);
        driver.findElement(By.id("address1")).sendKeys("Rua Exemplo 123");
        driver.findElement(By.id("address2")).sendKeys("Complemento XYZ");
        driver.findElement(By.id("country")).sendKeys("India");
        driver.findElement(By.id("state")).sendKeys("Estado");
        driver.findElement(By.id("city")).sendKeys("Cidade");
        driver.findElement(By.id("zipcode")).sendKeys("123456");
        driver.findElement(By.id("mobile_number")).sendKeys("21999999999");

        esperar(200);
        scrollFimPagina();
        esperar(200);
        removerPopups();

        WebElement botao = driver.findElement(By.xpath("//button[@data-qa='create-account']"));
        wait.until(ExpectedConditions.elementToBeClickable(botao)).click();
    }

    public boolean verificarCadastroComSucesso() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='Account Created!']")));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    private void removerPopups() {
        try {
            driver.switchTo().defaultContent();
            WebElement popup = driver.findElement(By.cssSelector("iframe[id^='aswift_']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].remove();", popup);
        } catch (NoSuchElementException | JavascriptException ignored) {
        }
    }

    private void esperar(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {
        }
    }

    private void scrollAte(By by) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    private void scrollFimPagina() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
}
