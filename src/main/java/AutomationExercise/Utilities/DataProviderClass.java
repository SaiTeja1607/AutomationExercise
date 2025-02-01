package AutomationExercise.Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	//This Data Provider returns one userEmail, password for each test run
	@DataProvider(name="loginData")
	public Object[][] loginData() throws IOException
	{

		DataFormatter format = new DataFormatter();
		FileInputStream fis = new FileInputStream("C:\\Users\\masineni.s.teja.INTIMETEC\\eclipse-workspace\\AutomationExercise\\TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
	XSSFSheet sheet=	workbook.getSheetAt(0);
	XSSFRow row =	sheet.getRow(0);
	int rowsCount = sheet.getPhysicalNumberOfRows();
   int columnsCount =	row.getLastCellNum();
   Object[][] loginData = new Object[rowsCount-1][columnsCount-1];
   
   for(int i=0; i<rowsCount-1; i++)
   {
	 XSSFRow currentRow =  sheet.getRow(i+1);
	 for(int j=0; j<columnsCount-1; j++)
	 {
		XSSFCell cell = currentRow.getCell(j+1);
		loginData[i][j]= format.formatCellValue(cell);
		 
	 }
	   
   }
	
 return loginData;
		
	}
	
	
}
