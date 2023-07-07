package day09_practice;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class C03_ReadExcel {

        // Ulkeler dosyasındaki tum dataları map'a alınız ve yazdırınız.

    @Test
    public void test01() throws IOException {

        // Ulkeler dosyasındaki tum verileri koyabilecegim en uygun java objesi map'dir.

        Map<String,String> ulkelerMap = new TreeMap<>();
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        int sonSatirNumarasi = workbook.getSheet("Sayfa1").getLastRowNum();

        for (int i = 0; i <=sonSatirNumarasi ; i++) {

            String key =  workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();

            String value =  workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString() + ","
                    + workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString() + ","
                    + workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();

            ulkelerMap.put(key,value);

            //System.out.println(key + " /" + value);

        }

        System.out.println(ulkelerMap);

    }
}
