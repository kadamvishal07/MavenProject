package com.vishal.project.MavenProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelReadWrite {
	@Test
	public void excelRead() throws IOException
	{
		FileInputStream file = new FileInputStream("C:\\Java_Selenium\\testDataExcel.xlsx");
		XSSFWorkbook xlWorkbook = new XSSFWorkbook(file);
		
		int numOfSheets = xlWorkbook.getNumberOfSheets();
		for (int i=0; i<numOfSheets; i++)
		{
			if (xlWorkbook.getSheetName(i).equals("DataFile"))
			{
				XSSFSheet xlSheet = xlWorkbook.getSheetAt(i);
				Iterator<Row> rows = xlSheet.iterator();//Sheet is collection of Rows
				Row firstRow = rows.next();
				Iterator<Cell> cells =  firstRow.cellIterator();
				int indexValue =0;
				int columnIndex = 0;
				while (cells.hasNext())
				{
					Cell cellValue = cells.next();
					//Identify the "TestCases" column by scanning the entire row.
					if (cellValue.getStringCellValue().equals("TestCases"))
					{
						columnIndex=indexValue;
						System.out.println("Got It");
					}
					indexValue++;
				}
				System.out.println("Column Index at which TestCase found = "+columnIndex+" and total index present = "+indexValue);
				
				while(rows.hasNext())
				{
					Row r = rows.next();
					if(r.getCell(columnIndex).getStringCellValue().equalsIgnoreCase("Search"))
					{
						Iterator<Cell>c = r.cellIterator();
						while (c.hasNext())
						{
							Cell cType = c.next();
							if(cType.getCellType()==CellType.STRING)
							{
								System.out.print(" || "+cType.getStringCellValue());
							}
							else
							{
								System.out.print(" || "+cType.getNumericCellValue());
							}
						}
						System.out.println();
					}
				}
			}
			
		}
				
	}
}
