package draftTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class DraftTest {


    @Test
    public void validLogin() throws InterruptedException {

        // переменная с абсолютным адресом
        File fileFF = new File("drivers/chromedriver.exe");
        //путь к драйверу
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://booking.uz.gov.ua/ru/authorization/");
        driver.findElement(By.name("login")).sendKeys("apogeygmbh@gmail.com");
        driver.findElement(By.name("passwd")).sendKeys("90909090");
        driver.findElement(By.tagName("button")).click();
        // почему не работает через xpath
        //driver.findElement(By.xpath(".//button[@type='submit]")).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath(".//*[@href='https://booking.uz.gov.ua/ru/']")).click();
        Thread.sleep(1000);


        driver.quit();
    }


}
