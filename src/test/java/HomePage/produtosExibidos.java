package HomePage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

class produtosExibidos {
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
        driver.quit();
    }

    @Test
    @DisplayName("Colocando produto no carrinho")
    void testAddProdutoCarrinho() {

    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    WebElement adicionarButton = driver.findElement(By.xpath("//div[@title='Ração para Cães Quatree Gourmet Adultos Raças Médias e Grandes Livre de Corantes 15Kg']//i[@class='newicon-plus']"));
    adicionarButton.click();

    WebElement abrirCesta = driver.findElement(By.xpath("//i[@class='newicon-basket']"));
    wait.until(ExpectedConditions.elementToBeClickable(abrirCesta));
    abrirCesta.click();

    WebElement contadorCesta = driver.findElement(By.xpath("//div[@class='miniCart__cartProducts__itemDetails--quantity']//div[@class='productQuantity ']"));
    wait.until(
            d -> contadorCesta.isEnabled()
        );
    }

    @Test
    @DisplayName("Removendo produto do carrinho")
    void testRemoProdutoCarrinho() {

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement abrirCesta = driver.findElement(By.xpath("//i[@class='newicon-basket']"));
        wait.until(ExpectedConditions.elementToBeClickable(abrirCesta));
        abrirCesta.click();

        WebElement contadorCesta = driver.findElement(By.xpath("//div[@class='miniCart__cartProducts__itemDetails--quantity']//div[@class='productQuantity ']"));
        wait.until(
                d -> contadorCesta.isEnabled()
        );

        WebElement removerProduto = driver.findElement(By.xpath("//div[@class='miniCart__cartProducts__itemDetails--quantity']//i[@class='newicon-trash']"));
        wait.until(
                d-> removerProduto.isEnabled()
        );
        removerProduto.click();

        WebElement popUpRemoverCesta =driver.findElement(By.xpath("//div[@id='modal-productRemove']//div[@class='modal-content popupInfo-content']"));
        wait.until(
                d-> popUpRemoverCesta.isDisplayed()
        );

        WebElement confirmarEscolha = driver.findElement(By.xpath("//button[normalize-space()='Sim']"));
        confirmarEscolha.click();

        WebElement cestaVazia = driver.findElement(By.xpath("//i[@class='icon-sad-basket']"));
        wait.until(
                d-> cestaVazia.isDisplayed()
        );
    }

}
