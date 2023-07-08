package day11_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {

    @Test
    public void test01() {

        girisYap();

        // input olarak verilen satır sayısı ve sutun sayısına sahip cell'deki text'i dinamik olarak yazdırın

        int satir = 3;
        int sutun = 3;

        WebElement arananCell = driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));
        System.out.println(arananCell.getText());


    }

    public void girisYap() {
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.xpath("//button[@id='details-button']")).click(); // gelişmiş yazan yere tıklıyoruz
        driver.findElement(By.xpath("(//a)[5]")).click(); // güvenli degil yazan yere tıklıyoruz

        driver.findElement(By.xpath("(//a[@class='nav-link'])[7]")).click(); // log in

        Actions actions = new Actions(driver);
        WebElement userName = driver.findElement(By.xpath("//input[@id='UserName']"));
        actions.click(userName).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();

    }

}
