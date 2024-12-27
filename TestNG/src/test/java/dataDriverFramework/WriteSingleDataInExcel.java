package dataDriverFramework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteSingleDataInExcel {
	@Test
	public void writeSingleData() throws IOException {
		// Specify the file path
		String filePath = "D:\\DataDriverFramework\\NewSheet.xlsx";
		// Open the Excel file
		FileInputStream fis = new FileInputStream(filePath);
		// Create Workbook instance
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		// Access the sheet (create one if it doesn't exist)
		XSSFSheet sheet = workbook.createSheet("Sheet3");
		// Create rows and cells
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("New Data 1");

		// You can write more rows and columns as needed
		Row row1 = sheet.createRow(1);
		Cell cell1 = row1.createCell(0);
		cell1.setCellValue("New Data 2");

		// Write changes to the file
		FileOutputStream outFile = new FileOutputStream(filePath);
		workbook.write(outFile);
		// Close the file streams
		outFile.close();
		workbook.close();
		fis.close();

	}
}
