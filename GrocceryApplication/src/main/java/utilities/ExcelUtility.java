package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	static FileInputStream f;//class used To Open/Acess excel file
	static XSSFWorkbook w;//class used to acess the workbook
	static XSSFSheet sh;//class used to represent a sheet inside the workbook
	

	public static String readStringData(int row, int col,String sheet) throws IOException
	
	{
		
		
		f = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\GrocceryApplication\\src\\test\\resources\\TestData.xlsx");
		w = new XSSFWorkbook(f);
		sh = w.getSheet(sheet);//getSheet method get the details from the sheet1
		XSSFRow r = sh.getRow(row);//XSSFRow is a class for getting details from the row and getRow() is a method
		XSSFCell c = r.getCell(col);//XSSFCell is a class for getting details from the cell and getCell() is a method
		return c.getStringCellValue();//method to get string value from a cell
		

	}
	
	
	public static String readIntegerData(int row, int col,String sheet) throws IOException 
	
	{
		f = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\GrocceryApplication\\src\\test\\resources\\TestData.xlsx");
		w = new XSSFWorkbook(f);
		sh = w.getSheet(sheet);
		XSSFRow r = sh.getRow(row);
		XSSFCell c = r.getCell(col);
		int val =   (int) c.getNumericCellValue();  //convert double to int using typecasting
		return String.valueOf(val);   //convert integer to string using valueOf() method
		//return value;
	
	}


}
