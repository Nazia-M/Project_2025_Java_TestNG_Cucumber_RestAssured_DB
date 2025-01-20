package restAssured_API.aPITraining;

public class tc12_Response_Deserialization_1 {

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

    private String id;
    private String name;
    private String createdAt;
    private tc12_Response_Deserialization_2 data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public tc12_Response_Deserialization_2 getData() {
        return data;
    }

    public void setData(tc12_Response_Deserialization_2 data) {
        this.data = data;
    }

}
