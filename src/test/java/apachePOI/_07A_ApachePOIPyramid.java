package apachePOI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class _07A_ApachePOIPyramid {
    public static void main(String[] args) throws IOException {

        String path = "src/test/java/apachePOI/resource/_ApachePOIPyramid.xlsx";
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Pyramid");


        int newRowIdx = sheet.getPhysicalNumberOfRows();
        int base = 7;

        for (int i = 0; i < base; i++) {
            Row row = sheet.createRow(newRowIdx++);

            int spaceCount = base - i - 1;
            int starCount = i * 2 + 1;

            String rowString = "";
            for (int j = 0; j < spaceCount; j++) {
                rowString += " ";
            }
            for (int j = 0; j < starCount; j++) {
                rowString += "*";
            }
            for (int j = 0; j < spaceCount; j++) {
                rowString += " ";
            }

            for (int j = 0; j < rowString.length(); j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(String.valueOf(rowString.charAt(j)));
            }

            newRowIdx++;
        }
        workbook.write(fileOutputStream);
        workbook.close();
        fileOutputStream.close();
        System.out.println("The process is over.");
    }
}