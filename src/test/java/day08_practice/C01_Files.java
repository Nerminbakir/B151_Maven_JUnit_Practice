package day08_practice;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_Files {

    @Test
    public void test01() {

        // masaüstünde bir text dosyası olusturunuz.

        // masaüstünde text dosyasının olup olmadıgını test ediniz.

        // Assert.assertTrue(Files.exists(Paths.get("C:\\Users\nrmn_\\OneDrive\\Masaüstü\\batch151.txt")));

        // dinamik hale getirelim
        //"C:\Users\nrmn_               \OneDrive\Masaüstü\batch151.txt"

        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\OneDrive\\Masaüstü\\batch151.txt";

        String dosyaYolu = farkliKisim + ortakKisim;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));











    }
}
