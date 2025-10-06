import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


import java.time.Duration;

class paginaPrincipal {
    WebDriver driver;

    //hook JUnit
    @BeforeEach
    void start() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @AfterEach
    void finish() {
        driver.close();
    }

    @Test
    @DisplayName("Teste Logo")
    void testLogo() {
        driver.get("http://localhost/litecart/");
    }

}
