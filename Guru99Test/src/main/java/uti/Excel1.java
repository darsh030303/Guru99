package uti;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import uti.con1;

public class Excel1{

	public static XSSFWorkbook ExcelWorkBook;
	public static XSSFSheet ExcelWorkSheet;
	public static XSSFCell Cell;
	public static XSSFRow row;
	
	public static FileInputStream ExcelFile=null;
	public static FileOutputStream fileclose=null;
	
	
	
	//this method is to set filepath and to open file
		public static void setExcelFile(String Path,String SheetName) throws Exception
		{
			ExcelFile=new FileInputStream(Path);
			//access required sheet
			ExcelWorkBook = new XSSFWorkbook(ExcelFile);
			ExcelWorkSheet = ExcelWorkBook.getSheet(SheetName);
				
		}
		
		public static String getCellData(int rawNum,int colNum)
		{
			Cell=ExcelWorkSheet.getRow(rawNum).getCell(colNum);
			String CellData=Cell.getStringCellValue();
			return CellData;
		}
		
		public static void setCellData(String result,int rawNum,int colNum) throws Exception
		{
		
			row=ExcelWorkSheet.getRow(rawNum);
			Cell=row.createCell(colNum);
			
			Cell.setCellValue(result);
			
		}
		
		public static void closefile() throws IOException
		{
		
			fileclose=new FileOutputStream(con1.Excelfilepath+con1.Excelfilename);
			ExcelWorkBook.write(fileclose);
			fileclose.flush();
			fileclose.close();
		}
}
