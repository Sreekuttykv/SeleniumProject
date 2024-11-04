package utilities;

import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelUtility {
	static FileInputStream f;// This is used to obtain input bytes from the file.
	static XSSFWorkbook w;// This represents the workbook instance, which refers to the entire Excel file.
	static XSSFSheet sh;

	public static String readStringData(int row, int col, String sheet) throws IOException {
		f = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\excel\\selenium.xlsx");// obtaining input bytes from a file
		w = new XSSFWorkbook(f);
		sh = w.getSheet(sheet); 
		XSSFRow r = sh.getRow(row);
		XSSFCell c = r.getCell(col);
		return c.getStringCellValue();
	}

	public static String readIntegerData(int row, int col, String sheet) throws IOException {
		f = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\excel\\selenium.xlsx");
		w = new XSSFWorkbook(f);
		sh = w.getSheet(sheet);
		XSSFRow r = sh.getRow(row);
		XSSFCell c = r.getCell(col);
		int val = (int) c.getNumericCellValue(); 
		return String.valueOf(val); 

	}
}


