package day04_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_WindowHandle extends TestBase {
    @Test
    public void windowHandle() {

        // 1- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        String amazonWindowHandle = driver.getWindowHandle();


        // 2- url'in 'amazon' icerdigini test edelim
        String actualUrl = driver.getCurrentUrl();
        String expextedUrl = "amazon";

        Assert.assertTrue(actualUrl.contains(expextedUrl));

        // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        bekle(2);

        String bestBuyWindowHandle = driver.getWindowHandle();


        // 4- title'in 'Best Buy' icerdigini test edelim
        String actualTitle = driver.getTitle();
        String expextedTitle = "Best Buy";

        Assert.assertTrue(actualTitle.contains(expextedTitle));

        // 5- ilk sayfaya(amazon) donup sayfada java aratalım
        driver.switchTo().window(amazonWindowHandle);
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Java", Keys.ENTER);

        // 6- arama sonuclarının 'Java' icerdigini test edelim
        WebElement aramaSonuclari = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        Assert.assertTrue(aramaSonuclari.getText().contains("Java"));

        // 7- ikinci sayfaya(bestbuy) donelim
        driver.switchTo().window(bestBuyWindowHandle);
        bekle(2);

        // 8- logonun gorundugunu test edelim
        WebElement logo = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());








    }
}
