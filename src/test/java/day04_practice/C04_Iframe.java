package day04_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Iframe extends TestBase {

    @Test
    public void iframe() {

        // https://html.com/tags/iframe sayfasına gidiniz
        driver.get("https://html.com/tags/iframe");

        // Videoyu görecek kadar asagiya ininiz
        Actions actions = new Actions(driver); //Video'yu görebilmek için kullandık.
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        bekle(2);

        // Videoyu izlemek icin Play tusuna basiniz
        WebElement iframe = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframe);
        /*
        Play'i dogru locate edip click yapmamıza ragmen videoyu çalıştırmadı. Bunun üzerine HTML kodlarını inceleyince Play'in aslında iframe içerisinde oldugunu gördük.
        Bu durumda önce iframe'i locate edip switchTo() ile iframe'e gecmeliyiz.
         */

        WebElement play = driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        play.click();
        bekle(2);

        // Videoyu calistirdiginizi test ediniz
        WebElement youTubeYazisi = driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youTubeYazisi.isDisplayed());

        // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz
        driver.switchTo().parentFrame();
        WebElement powerfulYazisi = driver.findElement(By.xpath("//span[@id='Powerful_but_easy_to_misuse']"));
        Assert.assertTrue(powerfulYazisi.isDisplayed());







    }
}
