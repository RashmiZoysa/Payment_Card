package entity;

public class Driver implements SuperEntity {
    private String DID;
    private String Name;
    private String NIC;
    private String DOB;
    private String Address;
    private String ContactNo;

    public Driver() {
    }

    public Driver(String DID, String name, String NIC, String DOB, String address, String contactNo) {
        this.DID = DID;
        Name = name;
        this.NIC = NIC;
        this.DOB = DOB;
        Address = address;
        ContactNo = contactNo;
    }

    public String getDID() {
        return DID;
    }

    public void setDID(String DID) {
        this.DID = DID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
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
}
