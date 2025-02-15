package restassured.aPITraining;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class tc16_Excel_getData {

    public ArrayList<String> getData(String testcaseName) throws IOException {
        System.out.println("-------------------------------------Data Driven Start---------------------------------------------------------");
        FileInputStream fis = new FileInputStream("C:\\Users\\Salim\\Desktop\\Project_2025_Java_TestNG_Cucumber_RestAssured_DB\\Test Data\\APITestData.xlsx");
        System.out.println("Opened FIS");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        System.out.println("Opened Workbook");
        XSSFSheet sheet = wb.getSheet("Sheet1");
        System.out.println("Opened Sheet");

        int rowCount = sheet.getLastRowNum();
        System.out.println("Row Count"+rowCount);
        int colCount = sheet.getRow(0).getLastCellNum();
        System.out.println("Col Count "+colCount);

        ArrayList data = new ArrayList();
        for(int i=1;i<=rowCount;i++)
        {
            System.out.println("---------------- In row "+i);
            XSSFRow currentRow = sheet.getRow(i);
            for(int j=0;j<colCount;j++)
            {
                String value = currentRow.getCell(j).toString();
                System.out.print(value+" ");
                if(j==0 && !value.equalsIgnoreCase(testcaseName)){
                    System.out.print("----------- NOT Value equals Testcase Name");
                    break;

                }
                data.add(value);
            }
            System.out.println();
        }
        System.out.println("------------- ArrayList");
        for(int i=0;i<data.size();i++){
            System.out.println("Column i : "+i+" Data : "+data.get(i));
        }
        System.out.println("-------------------------------------Data Driven Completed---------------------------------------------------------");

        return data;
    }
}
