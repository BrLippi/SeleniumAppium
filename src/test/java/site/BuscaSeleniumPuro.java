package site;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BuscaSeleniumPuro {

    String url = "https://www.iterasys.com.br";
    WebDriver driver;

    @Before

    public void iniciar(){

        System.setProperty("webdriver.chrome.driver", "drivers/chrome/chromedriver.exe");
        driver = new ChromeDriver();




    }

    @After

    public void finalizar(){
        driver.quit();

    }

    @Test

    public void buscaCurso(){

        driver.get(url);
        driver.findElement(By.id("searchtext")).sendKeys("Mantis" + Keys.ENTER);
        driver.findElement(By.cssSelector("span.comprar")).click();
        Assert.assertEquals("Mantis", driver.findElement(By.cssSelector("span.item-title")).getText());
        Assert.assertEquals("R$ 49,99", driver.findElement(By.cssSelector("span.new-price")).getText());

    }

}
