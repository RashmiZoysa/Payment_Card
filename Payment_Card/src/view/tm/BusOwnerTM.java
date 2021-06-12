package view.tm;

public class BusOwnerTM {
    private String BID;
    private String OwnerName;
    private String NIC;
    private String Address;
    private String ContactNo;

    public BusOwnerTM() {
    }

    public BusOwnerTM(String BID, String ownerName, String NIC, String address, String contactNo) {
        this.BID = BID;
        OwnerName = ownerName;
        this.NIC = NIC;
        Address = address;
        ContactNo = contactNo;
    }

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String ownerName) {
        OwnerName = ownerName;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public void setContactNo(String contactNo) {
        ContactNo = contactNo;
    }

    public String getBID() {
        return BID;
    }

    public void setBID(String BID) {
        this.BID = BID;
    }
}
