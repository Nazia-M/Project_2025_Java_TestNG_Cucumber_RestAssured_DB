package restAssured_API.aPITraining;

import org.json.JSONObject;

import java.util.HashMap;

public class tc07_POJOClass_1 {

    private String name;
    private tc07_POJOClass_2 data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public tc07_POJOClass_2 getData() {
        return data;
    }

    public void setData(tc07_POJOClass_2 data) {
        this.data = data;
    }
//    JSONObject jsonObject = new JSONObject();
//        jsonObject.put("name","Linda");
//
//    HashMap data = new HashMap();
//        data.put("year", 4324);
//        data.put("price", 43242);
//        data.put("CPU model", "Intel Core i9");
//        data.put("Hard disk size", "1 TB");
//
//        jsonObject.put("data", data);

}
