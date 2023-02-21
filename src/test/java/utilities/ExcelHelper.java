package utilities;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelHelper {
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public ExcelHelper(){

    }

    public static void excelSetup(){
        try {
            //access excel workbook
            workbook = new XSSFWorkbook("src/test/java/data/data.xlsx");
            sheet = workbook.getSheet("TestData");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getCellDataString(int rowNum, int cellNum){
        //go to Excel sheet
        excelSetup();

        //get string cell data
        XSSFRow row = sheet.getRow(rowNum);
        String cellData = "";
        if(row != null){
            cellData =  row.getCell(cellNum).getStringCellValue();
        }

        return cellData;
    }

    public static int getCellDataInt(int rowNum, int cellNum){
        //got to Excel sheet
        excelSetup();

        //get int cell data
        int cellData = (int) sheet.getRow(rowNum).getCell(cellNum).getNumericCellValue();
        return cellData;
    }


}
