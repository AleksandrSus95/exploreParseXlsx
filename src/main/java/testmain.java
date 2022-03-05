import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.annotation.processing.SupportedSourceVersion;
import java.io.*;
import java.nio.file.Paths;
import java.util.Iterator;

public class testmain {
    public static void main(String[] args) {
        File file = new File(Paths.get(System.getProperty("user.dir")).toString(), "test.xlsx");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator iterator = datatypeSheet.iterator();

            while (iterator.hasNext()) {
                Row currentRow = (Row) iterator.next();
                Iterator cellIterator = currentRow.iterator();
                cellIterator.hasNext();
                while (cellIterator.hasNext()) {
                    Cell currentCell = (Cell) cellIterator.next();
                    System.out.print(currentCell);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

