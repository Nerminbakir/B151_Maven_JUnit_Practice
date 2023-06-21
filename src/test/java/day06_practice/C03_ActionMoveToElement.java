package day06_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.Set;

public class C03_ActionMoveToElement extends TestBase {

    @Test
    public void test01() {

        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");
        String sayfa1Handle = driver.getWindowHandle();
        System.out.println("SAYFA1HANDLE: " + sayfa1Handle);

        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        WebElement dilSecenekMenusu = driver.findElement(By.xpath("//span[@class='icp-nav-link-inner']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(dilSecenekMenusu).perform();
        bekle(2);

        // Change country/region butonuna basiniz
        driver.findElement(By.xpath("//div[text()='Change country/region.']")).click();
        bekle(2);

        // United States dropdown'undan 'Turkey (Türkiye)' seciniz
        WebElement ddm = driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Turkey (Türkiye)");
        bekle(2);

        // United States dropdown'undan 'Turkey (Türkiye)' secildikten sonra dropdown kendiliginden kapanmadıgı ve
        // Go to website butonuna tiklayamadıgımız için sayfadaki herhangi bir yere tıkladık.
        driver.findElement(By.xpath("//div[@class='a-row a-ws-row']")).click();

        // Go to website butonuna tiklayiniz
        driver.findElement(By.xpath("//input[@class='a-button-input']")).click();
        bekle(2);

        // acilan yeni sayfanin Title'inin Elektronik icerdigini test ediniz
        Set<String> windowHandleSeti = driver.getWindowHandles();
        System.out.println(windowHandleSeti);

        String sayfa2Handle= "";
        for (String each:windowHandleSeti) {
            if(!each.equals(sayfa1Handle)){
                sayfa2Handle = each;
            }
        }

        System.out.println("SAYFA2HANDLE: " + sayfa2Handle);
        driver.switchTo().window(sayfa2Handle);


        String actualTitle = driver.getTitle();
        String expectedTitle = "Elektronik";
        Assert.assertTrue(actualTitle.contains(expectedTitle));


    }
}
