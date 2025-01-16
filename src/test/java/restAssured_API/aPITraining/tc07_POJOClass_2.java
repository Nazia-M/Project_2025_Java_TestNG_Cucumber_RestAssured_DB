package restAssured_API.aPITraining;

public class tc07_POJOClass_2 {


    private String year;
    private String price;

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

    private String CPU_model;
    private String Hard_disk_size;





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
