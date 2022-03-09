import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.file.Paths;
import java.util.Iterator;

public class testMain {
    public static void main(String[] args) {
        File file = new File(Paths.get(System.getProperty("user.dir")).toString(), "test.xlsx");
        String elementsExport = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
            iterator.next();
            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                while (cellIterator.hasNext()) {
                    Cell currentCell = cellIterator.next();
                    elementsExport += " " + currentCell.toString();
                }
            }
            fileInputStream.close();
            file.delete();
        } catch (FileNotFoundException e) {
            System.out.println("Export file not Found in dir");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Can't parse file");
            e.printStackTrace();
        }

        System.out.println(elementsExport);
    }
}

