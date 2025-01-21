package restassured.aPITraining;

public class tc12_POJOClass_2 {

//    {
//        "name": "Apple MacBook Pro 16",
//            "data": {
//                "year": 2019,
//                "price": 1849.99,
//                "CPU model": "Intel Core i9",
//                "Hard disk size": "1 TB"
//        }
//    }

    private String year;
    private String price;
    private String CPU_model;
    private String Hard_disk_size;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCPU_model() {
        return CPU_model;
    }

    public void setCPU_model(String CPU_model) {
        this.CPU_model = CPU_model;
    }

    public String getHard_disk_size() {
        return Hard_disk_size;
    }

    public void setHard_disk_size(String hard_disk_size) {
        Hard_disk_size = hard_disk_size;
    }



}
