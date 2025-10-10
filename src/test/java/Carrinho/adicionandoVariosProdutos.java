package Carrinho;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class adicionandoVariosProdutos {
    WebDriver driver;

    //hook JUnit
    @BeforeEach
    public void start() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--window-size=1920,1080");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.araujo.com.br/");
    }
    @AfterEach
    public void finish() {
        //driver.quit();
    }

    @Test
    @DisplayName("Adicionando vários itens no carrinho")
    void adicionandoItensDiversos(){

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement barraPesquisa = driver.findElement(By.xpath("//input[@placeholder='Precisou? Araujo Tem']"));
        WebElement adicionarPrimeiroProduto = driver.findElement(By.class(".buy-button"));
        WebElement pesquisar = driver.findElement(By.xpath("//i[@class='searchBar__icon icon-search']"));


        barraPesquisa.sendKeys("protetor solar");
        pesquisar.click();
        wait.until(
                ExpectedConditions.urlToBe("https://www.araujo.com.br/busca?q=protetor+solar&lang=pt_BR")
        );
        adicionarPrimeiroProduto.click();


        barraPesquisa.sendKeys("coca cola");
        pesquisar.click();
        wait.until(
                ExpectedConditions.urlToBe("https://www.araujo.com.br/busca?q=coca+cola&lang=pt_BR")
        );
        adicionarPrimeiroProduto.click();
    }
}
