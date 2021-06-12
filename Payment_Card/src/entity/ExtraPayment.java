package entity;

public class ExtraPayment implements SuperEntity {
    private String SID;
    private String CID;
    private String cmbRoute;
    private String price;

    public ExtraPayment() {
    }

    public ExtraPayment(String SID, String CID, String cmbRoute, String price) {
        this.SID = SID;
        this.CID = CID;
        this.cmbRoute = cmbRoute;
        this.price = price;
    }

    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID;
    }

    public String getCID() {
        return CID;
    }

    public void setCID(String CID) {
        this.CID = CID;
    }

    public String getCmbRoute() {
        return cmbRoute;
    }

    public void setCmbRoute(String cmbRoute) {
        this.cmbRoute = cmbRoute;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
