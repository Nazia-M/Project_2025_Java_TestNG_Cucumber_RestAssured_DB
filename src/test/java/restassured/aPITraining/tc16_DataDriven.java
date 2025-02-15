package restassured.aPITraining;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import io.restassured.path.json.JsonPath;

public class tc16_DataDriven {

    RequestSpecification reqSpec;
    ValidatableResponse vr;
    Response response;

    @Test(priority = 0)
    public void dataDrivernTestCase(){

        String requestBody = "{\"name\":\"Learn Appium Automation\",\n" +
                "\"isbn\":\"fdfdsfsdfsf\",\n" +
                "\"aisle\":\"224\",\n" +
                "\"author\":\"John Joe\"\n" +
                "}";

        //Given
        System.out.println("-------------- Given ---------------------");
        reqSpec = RestAssured.given()
                .baseUri("http://216.10.245.166")
                .contentType("application/json")
                .body(requestBody)
                .log().all();


        //When
        System.out.println("-------------- When ---------------------");
        response = reqSpec.when().post("/Library/Addbook.php");


        //Then
        System.out.println("-------------- Then ---------------------");
        vr = response.then().log().all();


        //Validation - Status code
        System.out.println("-------Response StatusCode : "+response.statusCode());
        int status = 200;
        Assert.assertEquals(response.statusCode(), status);


        //Validate Reposnse Msg and ID

        String msg = response.jsonPath().get("Msg");
        System.out.println("-------Response Msg : "+msg);

        String id = response.jsonPath().get("ID");
        System.out.println("-------Response Id : "+id);


    }


    @Test(priority = 1)
    public void dataDriven() throws IOException {
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

        for(int i=0;i<=rowCount;i++)
        {
            System.out.println("---------------- In row "+i);
            XSSFRow currentRow = sheet.getRow(i);
            for(int j=0;j<colCount;j++)
            {
                String value = currentRow.getCell(j).toString();
                System.out.print(value+" ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------Data Driven Completed---------------------------------------------------------");
    }
}
