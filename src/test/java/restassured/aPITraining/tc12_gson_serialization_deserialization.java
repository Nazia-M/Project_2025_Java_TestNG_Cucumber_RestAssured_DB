package restassured.aPITraining;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import restassured.pojos.tc12_POJOClass_1;
import restassured.pojos.tc12_POJOClass_2;
import restassured.pojos.tc12_Response_POJO_Deserialization_1;

// Use jsonschema2pojo.org website to check how many POJO classes we need to create
//Step 1 : POST , URL[Base URI + base Path], Header, Body, Auth
//Step 2 : Prepare Payload(Java objects -> JSON String) , Send the request
//Step 3 : Valdiate Response(JSON string -> Java objects), Validate status code, response time, response data

public class tc12_gson_serialization_deserialization {

    RequestSpecification reqSpec;
    ValidatableResponse vr;
    Response response;
    Gson gson;

    @Test(groups = "qa")
    public void gson_serialization_deserialization(){

        tc12_POJOClass_1 obj = new tc12_POJOClass_1();
        obj.setName("Jim");

        tc12_POJOClass_2 data = new tc12_POJOClass_2();
        data.setYear("1991");
        data.setPrice("20543543535353");
        data.setCPU_model("Universe Got 22");
        data.setHard_disk_size("1 TB");
        obj.setData(data);

        // Serialization :  Java objects -> JSON string(Payload) : to.json(obj_ref)
        gson = new Gson();
        String jsonString = gson.toJson(obj);
        System.out.println(jsonString);
        System.out.println("----------------Serialization -----------------");

        //Given with url, headers, body
        reqSpec = RestAssured.given();
        reqSpec.baseUri("https://api.restful-api.dev");
        reqSpec.basePath("/objects");
        reqSpec.contentType(ContentType.JSON);
        reqSpec.body(jsonString).log().all();
        System.out.println("----------------Given -----------------");

        //When
        Response response = reqSpec.when().post();
        System.out.println("----------------When -----------------");

        //Then
        vr = response.then().log().all();
        System.out.println("----------------Then -----------------");

        //Validate Status code
        vr.statusCode(200);
        System.out.println("----------------Validate Status code -----------------");

        System.out.println("----------------3 ways to extract Response -----------------");
        //3 ways to extract Response
//            1. extract().path()
//            2. jsonPath
//            3. Deserialization  - This is used real time

        //1. Extract response using extract().path()
        System.out.println("----------------Extract Response Using extract().path() -----------------");
        String id = response.then().extract().path("id");
        System.out.println("id is : "+id);

        String name = response.then().extract().path("name");
        System.out.println("name is : "+name);

        String createdAt = response.then().extract().path("createdAt");
        System.out.println("createdAt is : "+createdAt);

        String year = response.then().extract().path("data.year");
        System.out.println("year is : "+year);

        String price = response.then().extract().path("data.price");
        System.out.println("price is : "+price);

        String CPUmodel = response.then().extract().path("data.CPU_model");
        System.out.println("CPUmodel is : "+CPUmodel);

        String Harddisksize = response.then().extract().path("data.Hard_disk_size");
        System.out.println("Harddisksize is : "+Harddisksize);


        //2. Extract Response Using jsonPath
        System.out.println("----------------Extract Response Using jsonPath -----------------");
        String id_jsonPath = response.jsonPath().getString("id");
        System.out.println("id is : "+id_jsonPath);

        String nameid_jsonPath = response.jsonPath().getString("name");
        System.out.println("name is : "+nameid_jsonPath);

        String createdAtid_jsonPath = response.jsonPath().getString("createdAt");
        System.out.println("createdAt is : "+createdAtid_jsonPath);

        int yearid_jsonPath = response.jsonPath().getInt("data.year");
        System.out.println("year is : "+yearid_jsonPath);

        double priceid_jsonPath = response.jsonPath().getDouble("data.price");
        System.out.println("price is : "+priceid_jsonPath);

        String CPUmodelid_jsonPath = response.jsonPath().getString("data.CPU_model");
        System.out.println("CPUmodel is : "+CPUmodelid_jsonPath);

        String Harddisksizeid_jsonPath = response.jsonPath().getString("data.Hard_disk_size");
        System.out.println("Harddisksize is : "+Harddisksizeid_jsonPath);

        //3. Extract Response Using DeSerialziation
        // DeSerialization :  JSON string(Payload) -> Java objects : from.json(jsonString, ClassName.class)

        System.out.println("----------------Extract Response Using DeSerialziation -----------------");
        String javaObject_Response = response.asString();
        tc12_Response_POJO_Deserialization_1 response_des = gson.fromJson(javaObject_Response, tc12_Response_POJO_Deserialization_1.class);

        String id_des = response_des.getId();
        System.out.println("id_des is : "+id_des);

        String name_des = response_des.getName();
        System.out.println("name_des is : "+name_des);

        String createdAt_des = response_des.getCreatedAt();
        System.out.println("createdAt_des is : "+createdAt_des);

        String year_des = response_des.getData().getYear();
        System.out.println("year_des is : "+year_des);

        String price_des = response_des.getData().getPrice();
        System.out.println("price_des is : "+price_des);

        String CPUmodel_des = response_des.getData().getCPU_model();
        System.out.println("CPUmodel_des is : "+CPUmodel_des);

        String Harddisksize_des = response_des.getData().getHard_disk_size();
        System.out.println("Harddisksize_des is : "+Harddisksize_des);

        //AssertJ


    }

}
