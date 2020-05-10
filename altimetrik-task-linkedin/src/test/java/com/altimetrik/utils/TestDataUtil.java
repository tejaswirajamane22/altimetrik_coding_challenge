package com.altimetrik.utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataUtil {
	XSSFWorkbook wb;
	XSSFSheet sheet1;

	public TestDataUtil() {
		{
			File src = new File("./src/test/resources/testdata/LoginTestData.xlsx");
			try {
				FileInputStream fis = new FileInputStream(src);
				wb = new XSSFWorkbook(fis);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
	}

	public String getStringData(int sheetIndex, int row, int column) {

		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();

	}

	public String getStringData(String sheetName, int row, int column) {

		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();

	}

	public double getNumericData(String sheetName, int row, int column) {
		return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
	}
}