package entity;

public class Bus implements SuperEntity {
    private String BID;
    private String No;
    private String Name;
    private String Route;
    private String Date;
    private String Facilities;
    private String Type;
    private String OwnerName;
    private String OwnerNIC;
    private String OwnerAddress;
    private String OwnerContactNo;

    public Bus() {
    }

    public Bus(String BID, String no, String name, String route, String date, String facilities, String type, String ownerName, String ownerNIC, String ownerAddress, String ownerContactNo) {
        this.BID = BID;
        No = no;
        Name = name;
        Route = route;
        Date = date;
        Facilities = facilities;
        Type = type;
        OwnerName = ownerName;
        OwnerNIC = ownerNIC;
        OwnerAddress = ownerAddress;
        OwnerContactNo = ownerContactNo;
    }

    public String getNo() {
        return No;
    }

    public void setNo(String no) {
        No = no;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getFacilities() {
        return Facilities;
    }

    public void setFacilities(String facilities) {
        Facilities = facilities;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String ownerName) {
        OwnerName = ownerName;
    }

    public String getOwnerNIC() {
        return OwnerNIC;
    }

    public void setOwnerNIC(String ownerNIC) {
        OwnerNIC = ownerNIC;
    }

    public String getOwnerAddress() {
        return OwnerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        OwnerAddress = ownerAddress;
    }

    public String getOwnerContactNo() {
        return OwnerContactNo;
    }

    public void setOwnerContactNo(String ownerContactNo) {
        OwnerContactNo = ownerContactNo;
    }

    public String getBID() {
        return BID;
    }

    public void setBID(String BID) {
        this.BID = BID;
    }

    public String getRoute() {
        return Route;
    }

    public void setRoute(String route) {
        Route = route;
    }

    }

