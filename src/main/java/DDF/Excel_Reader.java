package DDF;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Reader {
	
	File f;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sh;
	
	public Excel_Reader(String excelPath)   //constructor
	{
		try
		{
		f=new File(excelPath);
	    fis=new FileInputStream(f);
	    wb=new XSSFWorkbook(fis);
		}
		catch(Exception e)   
		{
			System.out.println(e.getMessage());
		}
	} 
	
	public int ExcelRowsize(String sheetName)
	{
		sh=wb.getSheet(sheetName);
		int rowsize=sh.getLastRowNum();
		return rowsize;
	}
	
	public int Excelcolsize(String sheetName)
	{
		sh=wb.getSheet(sheetName);
		int colsize=sh.getRow(0).getLastCellNum();
		return colsize;
	}
	
	public String getData(String sheetName,int row, int col)
	{
		String data=wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
		return data;
	}
}
