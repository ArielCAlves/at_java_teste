package org.example.at4automationexercisetest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogoutPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void finalizarCadastroELogout() {
        try {
            wait.until(ExpectedConditions.urlContains("account_created"));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='Account Created!']")));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Continue')]"))).click();
        } catch (TimeoutException ignored) {
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Logout')]"))).click();
    }

    public boolean verificarPaginaLogin() {
        try {
            return wait.until(ExpectedConditions.urlToBe("https://automationexercise.com/login"));
        } catch (TimeoutException e) {
            return false;
        }
    }
}
