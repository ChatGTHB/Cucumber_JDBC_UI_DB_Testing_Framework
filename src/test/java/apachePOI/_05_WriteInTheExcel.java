package apachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _05_WriteInTheExcel {

    public static void main(String[] args) throws IOException {

        String path = "src/test/java/apachePOI/resource/WriteInTheExcel.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);

        int lastRowIndex = sheet.getPhysicalNumberOfRows();
        Row newRow = sheet.createRow(lastRowIndex);
        Cell newCell = newRow.createCell(0);
        newCell.setCellValue("Hello World");

        fileInputStream.close();

        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

        workbook.close();
        fileOutputStream.close();

        System.out.println("The process is over.");
    }
}
