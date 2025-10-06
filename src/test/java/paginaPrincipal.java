import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

class paginaPrincipal {
    WebDriver driver;

    //hook JUnit
    @BeforeEach
    void start() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.araujo.com.br/");
    }
    @AfterEach
    void finish() {
        driver.close();
    }

    @Test
    @DisplayName("Colocando produto no carrinho")
    void testProdutoCarrinho() {

        WebElement produto = driver.findElement(By.xpath("//div[@id='carousel-9b26250b30ce087420103f636d']//img[@alt='C E Ferulic SkinCeuticals Serum Antioxidante 30ml']"));
        produto.click();

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("https://www.araujo.com.br/c-e-ferulic-skinceuticals-serum-antioxidante-30ml/65565.html"));

        WebElement adicionandoCesta = driver.findElement(By.xpath("//button[@class='primaryButtonAddCart add-to-cart primaryButton']"));
        adicionandoCesta.click();
    }

}
