package day04_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_Alert extends TestBase {

    @Test
    public void alert() {
        //https://demo.guru99.com/test/delete_customer.php adresine gidin
        driver.get("https://demo.guru99.com/test/delete_customer.php");

        //customer id kısmına 53920 yazın
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("53920");
        bekle(2);

        //submit butonuna tıklayın
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        bekle(2);

        //cıkan alert mesajını yazdırın
        alertText();

        //alerti kabul edin
        alertAccept();
        bekle(2);

        //cıkan 2. alert mesajını yazdırın
        alertText();

        //cıkan 2. alerti kabul edin
        alertAccept();
        bekle(2);
    }
}
