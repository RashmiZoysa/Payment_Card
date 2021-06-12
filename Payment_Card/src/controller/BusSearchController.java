package controller;

import bo.BoFactory;
import bo.custom.BusBo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import dto.BusDTO;
import dto.DriverDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import view.tm.BusOwnerTM;
import view.tm.BusTM;
import view.tm.DriverTM;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusSearchController {
    public AnchorPane paneBusSearch;
    public TableColumn colBusNo;
    public TableColumn colBusName;
    public TableColumn colRoute;
    public TableColumn colDate;
    public TableColumn colFacilities;
    public TableColumn colType;
    public TableColumn colOwnerName;
    public TableColumn colNIC;
    public TableColumn colAddress;
    public TableColumn colContactNo;
    public TableView<BusOwnerTM> tblOwner;
    public TableView<BusTM> tblBus;
    public JFXButton btnNew;
    public JFXButton btnSearch;
    public JFXButton btnDelete;
    public JFXButton btnUpdate;
    public JFXComboBox cmbBID;
    BusBo bo;

    public void initialize() throws Exception {

        bo= BoFactory.getInstance().getBO(BoFactory.BoType.BUS);
        loadBID();

        colBusNo.setCellValueFactory(new PropertyValueFactory("colBusNo"));
        colBusName.setCellValueFactory(new PropertyValueFactory("colBusName"));
        colRoute.setCellValueFactory(new PropertyValueFactory("colRoute"));
        colDate.setCellValueFactory(new PropertyValueFactory("colDate"));
        colFacilities.setCellValueFactory(new PropertyValueFactory("colFacilities"));
        colType.setCellValueFactory(new PropertyValueFactory("colType"));
        colOwnerName.setCellValueFactory(new PropertyValueFactory("OwnerName"));
        colNIC.setCellValueFactory(new PropertyValueFactory("NIC"));
        colAddress.setCellValueFactory(new PropertyValueFactory("Address"));
        colContactNo.setCellValueFactory(new PropertyValueFactory("ContactNo"));


        loadAllBus();

    }

    private void loadBID() throws SQLException, ClassNotFoundException {
        ObservableList<String> obList= FXCollections.observableArrayList();
        try {
            ArrayList<String> dto = bo.getbid();
            for(String s : dto){
                obList.add(s);
            }
            cmbBID.setItems(obList);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void SearchOnAction(ActionEvent actionEvent) {
        try {
            BusDTO dto=bo.getBus(cmbBID.getValue()+"");
            if (!dto.equals(null)){
                ObservableList<BusTM> tmList = FXCollections.observableArrayList();
                BusTM tm = new BusTM(dto.getName(), dto.getNo(),dto.getRoute(),dto.getDate(),dto.getFacilities(),dto.getType());
                tmList.add(tm);
                tblBus.setItems(tmList);

                ObservableList<BusOwnerTM> ownerList=FXCollections.observableArrayList();
                BusOwnerTM tm2=new BusOwnerTM(dto.getBID(),dto.getOwnerName(),dto.getOwnerNIC(),dto.getOwnerAddress(),dto.getOwnerContactNo());
                ownerList.add(tm2);
                tblOwner.setItems(ownerList);
            }




        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteOnAction(ActionEvent actionEvent) {
    }

    public void UpdateOnAction(ActionEvent actionEvent) {

    }

    private void loadAllBus() throws Exception {
        ObservableList<BusTM> busList = FXCollections.observableArrayList();
        ObservableList<BusOwnerTM> ownerList = FXCollections.observableArrayList();
        ArrayList<BusDTO> dt = bo.loadAllDetail();
        for(BusDTO dto : dt){
            busList.add(new BusTM(
                    dto.getNo(),dto.getName(),
                    dto.getRoute(),dto.getDate(),dto.getFacilities(),dto.getType()
            ));
            tblBus.setItems(busList);
        }
        
        for(BusDTO dto : dt){
            ownerList.add(new BusOwnerTM(
                    dto.getBID(),
                    dto.getOwnerName(),
                    dto.getOwnerNIC(),
                    dto.getOwnerAddress(),
                    dto.getOwnerContactNo()
                    )
            );
        }
        tblOwner.setItems(ownerList);
    }

    public void NewOnAction(ActionEvent actionEvent) throws IOException {
        initUI("BusForm.fxml");
    }

    private void initUI(String location) throws IOException {
        this.paneBusSearch.getChildren().clear();
        this.paneBusSearch.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/"+location)));
    }

}
