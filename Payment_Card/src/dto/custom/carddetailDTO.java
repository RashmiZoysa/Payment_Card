package dto.custom;

public class carddetailDTO {
    private String CID;
    private String NIC;
    private String TID;
    private String destination;
    private String categoryID;
    private String duration;
    private String expireDate;
    private double price;
    private String PID;
    private String PaidDate;
    private String PaidTime;
    private String PaymentType;

    public carddetailDTO() {
    }

    public carddetailDTO(String CID, String NIC, String TID, String destination, String categoryID, String duration, String expireDate, double price, String PID, String paidDate, String paidTime, String paymentType) {
        this.CID = CID;
        this.NIC = NIC;
        this.TID = TID;
        this.destination = destination;
        this.categoryID = categoryID;
        this.duration = duration;
        this.expireDate = expireDate;
        this.price = price;
        this.PID = PID;
        PaidDate = paidDate;
        PaidTime = paidTime;
        PaymentType = paymentType;
    }

    public String getCID() {
        return CID;
    }

    public void setCID(String CID) {
        this.CID = CID;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getTID() {
        return TID;
    }

    public void setTID(String TID) {
        this.TID = TID;
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

    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }

    public String getPaidDate() {
        return PaidDate;
    }

    public void setPaidDate(String paidDate) {
        PaidDate = paidDate;
    }

    public String getPaidTime() {
        return PaidTime;
    }

    public void setPaidTime(String paidTime) {
        PaidTime = paidTime;
    }

    public String getPaymentType() {
        return PaymentType;
    }

    public void setPaymentType(String paymentType) {
        PaymentType = paymentType;
    }
}
