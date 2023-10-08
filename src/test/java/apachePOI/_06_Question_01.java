package apachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _06_Question_01 {
    public static void main(String[] args) throws IOException {
        /**
         *  Çarpım tablosunun tümünü varolan boş bir excel dosyasına
         *  alt alta yazdırınız.
         *
         *  -------------------------------------------------------------------
         *
         * Copy the entire multiplication tables into an existing blank excel file
         * print below.
         */


        String path = "src/test/java/apachePOI/resource/WriteInTheExcel.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);

        int newRowIndex = 0;

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                Row row = sheet.createRow(newRowIndex++);

                row.createCell(0).setCellValue(i);
                row.createCell(1).setCellValue("x");
                row.createCell(2).setCellValue(j);
                row.createCell(3).setCellValue("=");
                row.createCell(4).setCellValue(i * j);
            }
            Row nextRow = sheet.createRow(newRowIndex++);
        }

        fileInputStream.close();

        FileOutputStream fileOutputStream=new FileOutputStream(path);
        workbook.write(fileOutputStream);

        workbook.close();
        fileOutputStream.close();

        System.out.println("The process is over.");
    }
}
