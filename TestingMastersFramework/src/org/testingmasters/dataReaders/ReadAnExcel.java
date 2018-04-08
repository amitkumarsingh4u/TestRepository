package org.testingmasters.dataReaders;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadAnExcel {

	public String readExcel(String filePath, int rowNum, int cellNum)
			throws IOException, EncryptedDocumentException, InvalidFormatException {
		String value = "";

		FileInputStream fis = new FileInputStream(filePath);

		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("TestSheet");
		for (int i = 0; i <= rowNum; i++) {
			Row row = sh.getRow(i);
			for (int j = 0; j < cellNum; j++) {
				Cell col = row.getCell(j);
				value = col.getStringCellValue();

			}
		}

		return value;

	}

	public static void main(String[] args) throws Exception {
		ReadAnExcel re = new ReadAnExcel();
		re.readExcel("./TestData/TestData.xlsx", 1, 1);
	}
}
