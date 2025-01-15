package RestAssured_API;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class POST_Method {

    RequestSpecification reqSpec;
    ValidatableResponse vr;
    Response response;
    String token;
    int bookingId;


    @Test
    public void test_POST_Method() throws JsonProcessingException {

        Employee emp = new Employee();
        emp.setFirstname("Tina");
        emp.setLastname("Smith");
        emp.setGender("Female");
        emp.setAge(12);
        emp.setSalary(434324234);


        //Using Jackson dependency for Serialization - Convert Java Object(emp) to JSON(empJson)
        ObjectMapper objMapper = new ObjectMapper();
        String empJson = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
        System.out.println("-------Converted Java to JSON----------- \n"+empJson);


        //Pre-Requisite [POST JSON object to API]
        reqSpec = RestAssured.given();
        reqSpec.baseUri("https://httpbin.org/post");
        reqSpec.contentType(ContentType.JSON);
        reqSpec.body(empJson);   //Passing JSON Payload

        //Method - POST Request Body store Response and print
        Response response = reqSpec.when().post();
        System.out.println("---------------Response Pretty Print Start ----------------------");
        response.prettyPrint();
        System.out.println("---------------Response Pretty Print End----------------------");

        //Validation - Status code
        response.then().log().all();
        Assert.assertEquals(response.statusCode(), 200, "Check for Status Code 200");

        //Using Jackson dependency for DeSerialization - Convert JSON(empJson) to Java Object(emp)
        Employee emp1 = objMapper.readValue(empJson, Employee.class);

        //Validate - Response data
        System.out.println("---------------Print Validation Response Start----------------------");
        System.out.println(emp1.getFirstname()+": Tina");
        System.out.println(emp1.getLastname()+ ": Smith");
        System.out.println(emp1.getGender()+": Female");
        System.out.println(emp1.getAge()+":  12");
        System.out.println(emp1.getSalary()+" : 434324234");
        System.out.println("---------------Print Validation Response Done----------------------");



    }


}
