package restassured.aPITraining;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.ArrayList;

public class tc16_DataDrivenTestCase {

    RequestSpecification reqSpec;
    ValidatableResponse vr;
    Response response;

    @Test(priority = 0)
    public void tc001_addBook_dataDrivenTestCase() throws IOException {

        //Get Data from Excel
        tc16_Excel_getData excel = new tc16_Excel_getData();
        ArrayList data = excel.getData("tc001_addBook");
        System.out.println("---------- TestCase Data From Excel pass it into POJO Class------------");
        for(int i=0;i<data.size();i++){
            System.out.println("Column i : "+i+" Data : "+data.get(i));
        }

        tc16_POJOClass pojoData = new tc16_POJOClass();
        pojoData.setName(data.get(1).toString());
        pojoData.setIsbn(data.get(2).toString());
        pojoData.setAisle(data.get(3).toString());
        pojoData.setAuthor(data.get(4).toString());

        // Serialization :  Java objects -> JSON string(Payload) : to.json(obj_ref)
        Gson gson = new Gson();
        String requestBody = gson.toJson(pojoData);
        System.out.println(requestBody);
        System.out.println("----------------Serialization -----------------");


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



}
