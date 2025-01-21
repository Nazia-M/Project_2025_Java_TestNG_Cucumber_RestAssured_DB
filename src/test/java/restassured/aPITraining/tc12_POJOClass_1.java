package restassured.aPITraining;

public class tc12_POJOClass_1 {

//    {
//        "name": "Apple MacBook Pro 16",
//            "data": {
//                "year": 2019,
//                "price": 1849.99,
//                "CPU model": "Intel Core i9",
//                "Hard disk size": "1 TB"
//        }
//    }

    private String name;
    private tc12_POJOClass_2 data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public tc12_POJOClass_2 getData() {
        return data;
    }

    public void setData(tc12_POJOClass_2 data) {
        this.data = data;
    }


}
