package dto;

public class PaymentDTO {
    private String PID;
    private String CID;
    private String date;
    private String time;
    private String type;
    private double price;

    public PaymentDTO() {
    }

    public PaymentDTO(String PID, String CID, String date, String time, String type, double price) {
        this.PID = PID;
        this.CID = CID;
        this.date = date;
        this.time = time;
        this.setType(type);
        this.price = price;
    }

    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }

    public String getCID() {
        return CID;
    }

    public void setCID(String CID) {
        this.CID = CID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
