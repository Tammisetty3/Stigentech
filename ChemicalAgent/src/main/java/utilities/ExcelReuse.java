package utilities;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReuse {

	public static int getRowCount(String path,String sheetname) throws Throwable {
		FileInputStream fis=new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int rowCount = wb.getSheet(sheetname).getLastRowNum();
		return rowCount;
	}

	public static String getCellData(String path,String sheetname,int rownum,int colnum) throws Throwable {
		FileInputStream fis=new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fis);
		String cellValue = wb.getSheet(sheetname).getRow(rownum).getCell(colnum).toString();
		return cellValue;
	}

	public static Object[][] getData(String path,String sheetname) throws Throwable {
		FileInputStream fis=new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int totalrows = sh.getLastRowNum();
		int totalcols = sh.getRow(1).getLastCellNum();
		System.out.println(totalrows+" "+totalcols);

		Object[][] data=new Object[totalrows][totalcols];
		for(int i=1;i<=totalrows;i++) {
			for(int j=0;j<totalcols;j++) {
				data[i-1][j]=ExcelReuse.getCellData(path, sheetname, i, j);
			}
		}
		return data;
	}
	
}


