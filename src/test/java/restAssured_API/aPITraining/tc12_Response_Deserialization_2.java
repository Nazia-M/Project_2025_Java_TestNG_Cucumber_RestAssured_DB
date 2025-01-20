package restAssured_API.aPITraining;

public class tc12_Response_Deserialization_2 {

//    {
//            "id": "ff808181932badb60194824d09fe4b43",
//            "name": "Jim",
//            "createdAt": "2025-01-20T06:01:14.495+00:00",
//            "data": {
//                "year": "1991",
//                "price": "20543543535353",
//                "CPU_model": "Universe Got 22",
//                "Hard_disk_size": "1 TB"
//             }
//    }

    private String year;

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

    private String price;
    private String CPU_model;
    private String Hard_disk_size;




}
