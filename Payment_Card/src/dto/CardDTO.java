package dto;


public class CardDTO{
    private String CID;
    private String nic;
    private String tid;
    private String destination;
    private String categoryID;
    private String duration;
    private String expireDate;
    private double price;

    public CardDTO() {
    }

    public CardDTO(String CID, String nic, String tid, String destination, String categoryID, String duration, String expireDate, double price) {
        this.CID = CID;
        this.nic = nic;
        this.tid = tid;
        this.destination = destination;
        this.categoryID = categoryID;
        this.duration = duration;
        this.expireDate = expireDate;
        this.price = price;
    }

    public String getCID() {
        return CID;
    }

    public void setCID(String CID) {
        this.CID = CID;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}



