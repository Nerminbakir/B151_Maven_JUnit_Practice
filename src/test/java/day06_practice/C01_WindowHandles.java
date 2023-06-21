package day06_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandles extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        // 'https://www.n11.com' adresine gidin
        driver.get("https://www.n11.com");
        String sayfa1Handle = driver.getWindowHandle();
        System.out.println("SAYFA1HANDLE: " + sayfa1Handle);

        bekle(2);

        // arama motoruna 'Oppo' yazıp aratın
        driver.findElement(By.xpath("//input[@id='searchData']")).sendKeys("Oppo" + Keys.ENTER);
        bekle(2);

        // ilk ürüne tıklayın
        WebElement ilkUrun = driver.findElement(By.xpath("(//img[@class='lazy cardImage'])[1]"));
        ilkUrun.click();
        bekle(2);

        //String sayfa2Handle = driver.getWindowHandle();
        //System.out.println("SAYFA2HANDLE: " + sayfa2Handle);
        //driver hala ilk sayfada bunu anlıyorum

        Set<String> windowHandleSeti = driver.getWindowHandles();
        System.out.println(windowHandleSeti);

        String sayfa2Handle="";
        for (String each:windowHandleSeti) {
            if(!each.equals(sayfa1Handle)){
                sayfa2Handle = each;
            }
        }

        System.out.println("SAYFA2HANDLE: " + sayfa2Handle);
        driver.switchTo().window(sayfa2Handle);

        // ikinci sayfa Title'ının 'Türkiye' icerdigini test edin
        String  ikinciSayfaTitle = driver.getTitle();
        Assert.assertTrue(ikinciSayfaTitle.contains("Türkiye"));
        bekle(2);

        // ilk sayfaya donun ve Title'ını yazdırın
        driver.switchTo().window(sayfa1Handle);

        String  ilkSayfaTitle = driver.getTitle();
        System.out.println("İLK SAYFA TİTLE: " + ilkSayfaTitle);


    }
}
