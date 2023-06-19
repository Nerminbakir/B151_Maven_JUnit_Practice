package day05_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Iframe extends TestBase{

    @Test
    public void test01() {

        // https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/ sayfasına gidiniz
        driver.get("https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/");
        bekle(2);

        // Videoyu görecek kadar asagiya ininiz
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // Videoyu izlemek icin Play tusuna basiniz
        WebElement iframe = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/x3kfyZJhC3U?rel=0&showinfo=0']"));
        driver.switchTo().frame(iframe);

         /*
        play'i dogru locate edip click yapmamıza ragmen videoyu calıstırmadı.
        Bunun üzerine HTML kodlarını inceleyince Play'in aslında bir iframe icerisinde oldugunu gördük
        Bu durumda önce iframe locate edip sonra switchTo() ile iframe'e gecmeliyiz
         */


        WebElement play = driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        play.click();
        bekle(4);

        // videoyu durdurunuz
        WebElement play1 = driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']"));
        play1.click();
        bekle(2);

        // videoyu tam ekran yapınız
        WebElement tamEkran = driver.findElement(By.xpath("//button[@class='ytp-fullscreen-button ytp-button']"));
        tamEkran.click();
        bekle(2);

        // videoyu calıstırınız
        play1.click();
        bekle(2);

        // videoyu kucultunuz
        tamEkran.click();
        bekle(2);

        // videoyu durdurunuz
        play1.click();

        // Videoyu calistirdiginizi test ediniz
        WebElement youTubeYazisi = driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youTubeYazisi.isDisplayed());

        // 'jQuery Flexy Plugin Demos' yazısının gorunur oldugunu test ediniz
        driver.switchTo().parentFrame();
        WebElement powerfulYazisi = driver.findElement(By.xpath("//h1"));
        Assert.assertTrue(powerfulYazisi.isDisplayed());


    }
}
