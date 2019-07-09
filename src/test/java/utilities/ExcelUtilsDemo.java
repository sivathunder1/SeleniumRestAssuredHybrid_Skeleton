package utilities;

public class ExcelUtilsDemo {

	public static void main(String[] args) {
		String filepath = System.getProperty("user.dir");
		ExcelUtils excel = new ExcelUtils(filepath+"\\excel\\Data.xlsx","Sheet1");
		excel.getRowCount();
		excel.getCellDataString(0, 0);
		excel.getCellDataNumber(1, 1);
	}

}
