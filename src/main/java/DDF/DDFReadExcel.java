package DDF;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DDFReadExcel {
	
	//File, FileInputStream, HSFFWorkbook(.xls), XSSFWorkbook(.xlsx),XSSFSheet
	//getSheet, getCell, getRow,GetStringcellvalue, getlastRow,getlastcellno

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try
		{
		
		File f=new File("G:\\Excel files\\orangehrm.xlsx");
		
		FileInputStream fis=new FileInputStream(f);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		XSSFSheet sh=wb.getSheet("Sheet1");
		
		//read data in Excel
		String data=sh.getRow(3).getCell(0).getStringCellValue();
		
		//totalrows
		
		int rowsize=sh.getLastRowNum();
		
		System.out.println("row size : " +(rowsize+1));
		
		//total column
		
		short colsize=sh.getRow(1).getLastCellNum();
		
		System.out.println("column size : "+colsize);
		
		System.out.println(data);
		
		}
		
		catch(FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		
		catch(IOException i)
		{
			System.out.println(i.getMessage());
		}

	} 

}
