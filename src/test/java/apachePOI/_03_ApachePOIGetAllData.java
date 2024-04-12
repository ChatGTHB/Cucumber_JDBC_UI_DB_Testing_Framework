package apachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class _03_ApachePOIGetAllData {

    public static void main(String[] args) throws IOException {

        String path = "src/test/java/apachePOI/resource/ApacheExcel.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet sheet = workbook.getSheetAt(0); // Sheet sheet=workbook.getSheet("Sheet1");
        int rowCount = sheet.getPhysicalNumberOfRows();

        // The First Way
        for (int i = 0; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            int cellCount = row.getPhysicalNumberOfCells();
            for (int j = 0; j < cellCount; j++) {
                Cell cell = row.getCell(j);
                System.out.print(cell + "\t");
            }
            System.out.println();
        }

        System.out.println("*****************************************************");
        // The Second Way
        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            for (int j = 0; j < sheet.getRow(i).getPhysicalNumberOfCells(); j++) {
                System.out.print(sheet.getRow(i).getCell(j) + "\t");
            }
            System.out.println();
        }
    }
}
