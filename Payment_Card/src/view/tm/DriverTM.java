package view.tm;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

public class DriverTM {
    private String colName;
    private String colNIC;
    private String colDOB;
    private String colAddress;
    private String colContactNo;
    private Button btn;

    public DriverTM() {
    }

    public DriverTM(String colName, String colNIC, String colDOB, String colAddress, String colContactNo, Button btn) {
        this.colName = colName;
        this.colNIC = colNIC;
        this.colDOB = colDOB;
        this.colAddress = colAddress;
        this.colContactNo = colContactNo;
        this.btn = btn;
    }

    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    public String getColNIC() {
        return colNIC;
    }

    public void setColNIC(String colNIC) {
        this.colNIC = colNIC;
    }

    public String getColDOB() {
        return colDOB;
    }

    public void setColDOB(String colDOB) {
        this.colDOB = colDOB;
    }

    public String getColAddress() {
        return colAddress;
    }

    public void setColAddress(String colAddress) {
        this.colAddress = colAddress;
    }

    public String getColContactNo() {
        return colContactNo;
    }

    public void setColContactNo(String colContactNo) {
        this.colContactNo = colContactNo;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

}
