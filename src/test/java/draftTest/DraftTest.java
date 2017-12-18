package draftTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class DraftTest {


    @Test
    public void validLogin() throws InterruptedException {

        //1 -переменная с абсолютным адресом
        //2-путь к драйверу
        //3-создаем объект "driver"
        //4-неявное ожидание |:10 сек
        File fileFF = new File("drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        /** login page */
        //1 -URL web страницы
        //2 -поиск элемента по имени (By.name) и ввод текста (sendKeys)
        //3 -поиск элемента по имени (By.name) и ввод текста (sendKeys)
        //4 -поиск элемента по тегу (By.tagName) и нажатие клавиши (.click)
        driver.get("https://booking.uz.gov.ua/ru/authorization/");
        driver.findElement(By.name("login")).sendKeys("apogeygmbh@gmail.com");
        driver.findElement(By.name("passwd")).sendKeys("90909090");
        driver.findElement(By.tagName("button")).click();
        // почему не работает через xpath
        //driver.findElement(By.xpath(".//button[@type='submit]")).click();


        /** online reservation page*/
        //1 -явное ожидание
        //2 -поиск элемента по локатору (By.xpath) и нажатие клавиши (.click)
        //3 -явное ожидание
        Thread.sleep(1000);
        driver.findElement(By.xpath(".//*[@href='https://booking.uz.gov.ua/ru/']")).click();
        Thread.sleep(1000);


        /** online reservation page - dropdown element - "Откуда" - "Куда"*/
        //1 -поиск элемента по имени (By.name) и ввод текста (sendKeys)
        //2 -поиск элемента по локатору (By.xpath) и нажатие клавиши (.click)
        //3 -поиск элемента по имени (By.name) и ввод текста (sendKeys)
        //4 -поиск элемента по локатору (By.xpath) и нажатие клавиши (.click)
        driver.findElement(By.name("station_from")).sendKeys("Киев");
        driver.findElement(By.xpath(".//*[@class='ui-menu-item ui-state-focus']" +
                " [contains(text(),'Киев')]")).click();
        driver.findElement(By.name("station_till")).sendKeys("Ивано-Франковск");
        driver.findElement(By.xpath(".//*[@class='ui-menu-item ui-state-focus']" +
                " [contains(text(),'Ивано-Франковск')]")).click();


        /** online reservation page - checkbox "Туда и обратно"*/
        //1 -поиск элемента по имени (By.name) и нажатие клавиши (.click)
        // driver.findElement(By.name("round_trip")).click();


        /** online reservation page - input "Дата отправления"*/
        //1 -поиск элемента по локатору (By.xpath) и нажатие клавиши (.click)
        //2 -поиск элемента по локатору (By.xpath) и нажатие клавиши (.click)
        driver.findElement(By.xpath(".//input[@id='date_dep']")).click();
        driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']" +
                "//table//td[@data-month='0' and  @data-year='2018' ]" +
                " //a[@class='ui-state-default' and text()='10']")).click();

        Thread.sleep(1000);

        /** online reservation page - select "Время отправления"*/
        //1 -поиск элемента по локатору (By.xpath) и нажатие клавиши (.click)
        //2 -поиск элемента по локатору (By.xpath) и нажатие клавиши (.click)
        driver.findElement(By.xpath(".//select[@name='time_dep']")).click();
        driver.findElement(By.xpath(".//option[text()='00:00']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(".//button[@name='search']")).click();


        /** online reservation page - select "Выбор поезда и класса места (плацкарт-купе)"*/
        //1 -поиск элемента по локатору (By.xpath) и нажатие клавиши (.click)
        driver.findElement(By.xpath(".//*[@id='ts_res_tbl']/tbody/tr[4]/td[6]/div[3]/button")).click();


        Thread.sleep(10000);
        driver.quit();
    }


}
