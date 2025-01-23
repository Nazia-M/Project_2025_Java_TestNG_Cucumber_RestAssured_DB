package restassured.modules;

import com.google.gson.Gson;
import restassured.pojos.*;

public class PayloadManager {


    //Serialization and Deserialization

    Gson gson;


    public String createUserComputerData_Serialziation(){

        tc12_POJOClass_1 obj = new tc12_POJOClass_1();
        obj.setName("Nazia M");

        tc12_POJOClass_2 data = new tc12_POJOClass_2();
        data.setYear("1991");
        data.setPrice("20543543535353");
        data.setCPU_model("Universe Got 22");
        data.setHard_disk_size("1 TB");
        obj.setData(data);

        // Serialization :  Java objects -> JSON string(Payload) : to.json(obj_ref)
        gson = new Gson();
        String jsonString = gson.toJson(obj);

        return jsonString;

    }

    public tc12_Response_POJO_Deserialization_1 createUserComputerData_DeSerialziation(String responseString){

        gson = new Gson();

        tc12_Response_POJO_Deserialization_1 response_des = gson.fromJson(responseString, tc12_Response_POJO_Deserialization_1.class);

        return response_des;
    }

    public String createBooking_Serialization(){

        Booking booking = new Booking();
        booking.setFirstname("Nazia");
        booking.setLastname("M");
        booking.setTotalprice(432433);
        booking.setDepositpaid(true);

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2025-21-01");
        bookingDates.setChecout("2025-21-01");

        booking.setBookingdates(bookingDates);
        booking.setAdditionalneeds("Breakfast");

        gson = new Gson();
        String jsonString = gson.toJson(booking);

        return jsonString;

    }

    public BookingResponse createBooking_Deserialization(String responseString){

        gson = new Gson();
        BookingResponse bookingResponse = gson.fromJson(responseString, BookingResponse.class);
        return bookingResponse;
    }


}
