package test.maven.selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookType;
import org.testng.annotations.Test;

public class ExcelPracticeTest {

	XSSFWorkbook work = null;
	FileInputStream fis = null;

	@Test
	public ArrayList<String> excelDataDriven(String testcase) throws IOException {
		fis = new FileInputStream("C:\\Users\\pinku\\MavenSelenium\\data.xlsx");
		work = new XSSFWorkbook(fis);
		ArrayList<String> al =new ArrayList<String>();
		for (int i = 0; i < work.getNumberOfSheets(); i++) {
			if (work.getSheetName(i).contentEquals("Sheet1")) {
				XSSFSheet sheet = work.getSheetAt(i);
				Iterator<Row> row1 = sheet.iterator();
				Row r = row1.next();
				Iterator<Cell> cell1 = r.cellIterator();
				int k = 0, columnIndex = 0;
				while (cell1.hasNext()) {
					if (cell1.next().getStringCellValue().contentEquals("Test Case")) {
						columnIndex = k;
					}
					k++;
				}
				while (row1.hasNext()) {
					Row r1 = row1.next();
					if (r1.getCell(columnIndex).getStringCellValue().contentEquals(testcase)) {
						
						Iterator<Cell> c1 = r1.cellIterator();
						while (c1.hasNext()) {
							Cell c2 = c1.next();
							if(c2.getCellType()==CellType.STRING) {
								al.add(c2.getStringCellValue());
							}else {
								String s1=NumberToTextConverter.toText(c2.getNumericCellValue());
								al.add(s1);
							}
							
						}

					}
				}
			}
		}
return al;
	}

}
