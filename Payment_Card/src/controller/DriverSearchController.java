package controller;

import bo.BoFactory;
import bo.custom.DriverBo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import dto.DriverDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import org.hibernate.sql.Delete;
import view.tm.DriverTM;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DriverSearchController {
    public AnchorPane paneDriverSearch;
    public TableColumn colName;
    public TableColumn colNIC;
    public TableColumn colDOB;
    public TableColumn colAddress;
    public TableColumn colContactNo;
    public TableColumn colDelete;
    public JFXComboBox cmbDID;
    public JFXButton btnNew;
    public JFXButton btnSearch;
    public JFXButton btnUpdate;
    public JFXButton btnLoadAll;
    public TableView <DriverTM>tableDriver;
    DriverBo bo;


    public void initialize() throws Exception {

        bo= BoFactory.getInstance().getBO(BoFactory.BoType.DRIVER);
        getDID();
        colName.setCellValueFactory(new PropertyValueFactory("colName"));
        colNIC.setCellValueFactory(new PropertyValueFactory("colNIC"));
        colDOB.setCellValueFactory(new PropertyValueFactory("colDOB"));
        colAddress.setCellValueFactory(new PropertyValueFactory("colAddress"));
        colContactNo.setCellValueFactory(new PropertyValueFactory("colContactNo"));
        colDelete.setCellValueFactory(new PropertyValueFactory("btn"));

        loadAllDrivers();


    }

    private void getDID() throws SQLException, ClassNotFoundException {
        ObservableList<String> observableList=FXCollections.observableArrayList();
        ArrayList<String>arrayList=bo.getDID();
        for (String s: arrayList){
            observableList.add(s);
        }
        cmbDID.setItems(observableList);
    }

    public void SearchOnAction(ActionEvent actionEvent) {
        try {
            DriverDTO dto=bo.getDriver(cmbDID.getValue()+"");
            if (!dto.equals(null)){
                ObservableList<DriverTM> tmList = FXCollections.observableArrayList();
                List<DriverDTO> allDrivers = bo.getAllDrivers();
                    Button btn = new Button("Delete");
                    DriverTM tm = new DriverTM(dto.getName(), dto.getNIC(),
                            dto.getDOB(), dto.getAddress(),dto.getContactNo(),btn);
                    tmList.add(tm);
                    tableDriver.setItems(tmList);

                }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpdateOnAction(ActionEvent actionEvent) {
    }

    private void loadAllDrivers() throws Exception {
        ObservableList<DriverTM> tmList =
                FXCollections.observableArrayList();
        List<DriverDTO> allDrivers = bo.getAllDrivers();
        tmList.clear();
        for (DriverDTO dto : allDrivers)
        {
            Button btn = new Button("Delete");
            DriverTM tm = new DriverTM(dto.getName(), dto.getNIC(),
                    dto.getDOB(), dto.getAddress(),dto.getContactNo(),btn);
            tmList.add(tm);
            btn.setOnAction((e) -> {
                try {

                    ButtonType ok = new ButtonType("OK",
                            ButtonBar.ButtonData.OK_DONE);
                    ButtonType no = new ButtonType("NO",
                            ButtonBar.ButtonData.CANCEL_CLOSE);

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                            "Are You Sure ?", ok, no);
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.orElse(no) == ok) {
                        if (bo.deleteDriver(tm.getColName())) {
                            new Alert(Alert.AlertType.CONFIRMATION,
                                    "Deleted", ButtonType.OK).show();
                            loadAllDrivers();
                            return;
                        }
                        new Alert(Alert.AlertType.WARNING,
                                "Try Again", ButtonType.OK).show();
                    } else {
                    }


                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            });
        }
        tableDriver.setItems(tmList);

    }

    public void NewOnAction(ActionEvent actionEvent) throws IOException {
        initUI("DriverForm.fxml");
    }

    private void initUI(String location) throws IOException {
        this.paneDriverSearch.getChildren().clear();
        this.paneDriverSearch.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/"+location)));
    }

    public void LoadAllOnAction(ActionEvent actionEvent) {
    }
}
