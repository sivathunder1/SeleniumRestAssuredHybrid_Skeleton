package utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static void main(String[] args) {
		getRowCount();
		getCellDataString(0, 0);
	}

	public static String filepath = System.getProperty("user.dir");
	public static XSSFWorkbook workbook = null;
	public static XSSFSheet sheet = null;
	public static int rowCount = 0;
	public static int colCount = 0;

	public ExcelUtils(String excelPath, String sheetName) {
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}

	public static int getRowCount() {
		try {

			rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("Number of rows : " + rowCount);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		
		return rowCount;

	}
	public static int getColCount() {
		try {

			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("Number of columns : " + rowCount);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return colCount;

	}

	public static String getCellDataString(int rowNum, int colNum) {
		String cellData = null;
		try {

			cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			//System.out.println("Data in cell : " + cellData);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return cellData;

	}

	public static double getCellDataNumber(int rowNum, int colNum) {
		double cellData = 0;
		try {

			cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			System.out.println("Data in cell : " + cellData);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return cellData;

	}

}
