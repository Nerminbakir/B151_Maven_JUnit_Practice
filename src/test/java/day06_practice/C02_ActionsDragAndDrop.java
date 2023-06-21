package day06_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_ActionsDragAndDrop extends TestBase {

    @Test
    public void test01() {

        // https://demoqa.com/droppable adresine gidiniz
        driver.get("https://demoqa.com/droppable");

        // 'Drag me' butonunu tutup 'Drop here' kutusunun ustune birakiniz
        WebElement dragMe = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropHere = driver.findElement(By.xpath("//div[@id='droppable']"));
        Actions actions = new Actions(driver);

        actions.dragAndDrop(dragMe, dropHere).perform();


        // 'Drop here' yazisi yerine 'Dropped!' oldugunu test ediniz
        WebElement dropped = driver.findElement(By.xpath("//p[text()='Dropped!']"));
        String actualYazi = dropped.getText();
        String expectedYazi = "Dropped!";

        Assert.assertEquals(expectedYazi,actualYazi);
    }
}
