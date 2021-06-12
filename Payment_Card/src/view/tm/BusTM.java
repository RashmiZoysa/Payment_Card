package view.tm;

import javafx.scene.control.TableColumn;

public class BusTM {
    private String colBusNo;
    private String colBusName;
    private String colRoute;
    private String colDate;
    private String colFacilities;
    private String colType;

    public BusTM() {
    }

    public BusTM(String colBusNo, String colBusName, String colRoute, String colDate, String colFacilities, String colType) {
        this.colBusNo = colBusNo;
        this.colBusName = colBusName;
        this.colRoute = colRoute;
        this.colDate = colDate;
        this.colFacilities = colFacilities;
        this.colType = colType;
    }


    public String getColBusNo() {
        return colBusNo;
    }

    public void setColBusNo(String colBusNo) {
        this.colBusNo = colBusNo;
    }

    public String getColBusName() {
        return colBusName;
    }

    public void setColBusName(String colBusName) {
        this.colBusName = colBusName;
    }

    public String getColRoute() {
        return colRoute;
    }

    public void setColRoute(String colRoute) {
        this.colRoute = colRoute;
    }

    public String getColDate() {
        return colDate;
    }

    public void setColDate(String colDate) {
        this.colDate = colDate;
    }

    public String getColFacilities() {
        return colFacilities;
    }

    public void setColFacilities(String colFacilities) {
        this.colFacilities = colFacilities;
    }

    public String getColType() {
        return colType;
    }

    public void setColType(String colType) {
        this.colType = colType;
    }
}
