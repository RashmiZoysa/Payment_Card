package controller;

import bo.BoFactory;
import bo.custom.BusBo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import dto.BusDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.regex.Pattern;

public class BusFormController {
    public AnchorPane paneBus;
    public JFXTextField txtOwnerName;
    public JFXTextField txtOwnerNIC;
    public JFXTextField txtOwnerAddress;
    public TextField txtBID;
    public JFXButton btnSave;
    public JFXDatePicker txtDate;
    public JFXTextField txtName;
    public JFXComboBox cmbType;
    public JFXTextField txtNo;
    public JFXTextField txtOwnerContactNo;
    public JFXComboBox cmbFacilities;
    public JFXComboBox cmbRoute;
    BusBo bo;

    public void initialize() throws SQLException, ClassNotFoundException {

        bo = BoFactory.getInstance().getBO(BoFactory.BoType.BUS);
        loadID();
        cmbRoute.getItems().addAll("Mathara","Hikkaduwa","Ambalangoda","Mathara","Hambanthota","Habaraduwa","Kaluthara");
        cmbFacilities.getItems().addAll("Air Condition","Non AirCondition","Semi Luxury","Normal");
        cmbType.getItems().addAll("CTB","Private","Highway CTB","Highway Private");

    }


    private void loadID() throws SQLException, ClassNotFoundException {
        String bid= bo.getBID();
        txtBID.setText(bid);
    }

    public void SaveOnAction(ActionEvent actionEvent) {
        if (Pattern.compile("^[A-z | 0-9]+$").matcher(txtNo.getText()).matches()) {
            if (Pattern.compile("^[A-z]{1,100}$").matcher(txtName.getText()).matches()) {
                if (Pattern.compile("^[A-z ]{1,100}$").matcher(txtOwnerName.getText()).matches()) {
                    if (Pattern.compile("^[0-9]{9,12}(v)$").matcher(txtOwnerNIC.getText()).matches()) {
                        if (Pattern.compile("^[A-z ]{1,100}$").matcher(txtOwnerAddress.getText()).matches()) {
                            if (Pattern.compile("^[0-9]{10}$").matcher(txtOwnerContactNo.getText()).matches()) {

                                boolean isSaved = false;
                                try {
                                    isSaved = bo.SaveBus(
                                            new BusDTO(txtBID.getText(),
                                                    txtNo.getText(),
                                                    txtName.getText(),
                                                    cmbRoute.getValue() + "",
                                                    txtDate.getValue() + "",
                                                    cmbFacilities.getValue()+"",
                                                    cmbType.getValue() + "",
                                                    txtOwnerName.getText(),
                                                    txtOwnerNIC.getText(),
                                                    txtOwnerAddress.getText(),
                                                    txtOwnerContactNo.getText())
                                    );
                                    System.out.println(isSaved);
                                } catch (SQLException throwables) {
                                    throwables.printStackTrace();
                                } catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                                }

                               // setUI("");


                            } else {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Pattern not Matched");
                                alert.show();
                                txtOwnerContactNo.setFocusColor(Paint.valueOf("red"));
                                txtOwnerContactNo.requestFocus();
                            }
                        } else {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Pattern not Matched");
                            alert.show();
                            txtOwnerAddress.setFocusColor(Paint.valueOf("red"));
                            txtOwnerAddress.requestFocus();
                        }
                    } else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Pattern not Matched");
                        alert.show();
                        txtOwnerNIC.setFocusColor(Paint.valueOf("red"));
                        txtOwnerNIC.requestFocus();
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Pattern not Matched");
                    alert.show();
                    txtOwnerName.setFocusColor(Paint.valueOf("red"));
                    txtOwnerName.requestFocus();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Pattern not Matched");
                alert.show();
                txtName.setFocusColor(Paint.valueOf("red"));
                txtName.requestFocus();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Pattern not Matched");
            alert.show();
            txtNo.setFocusColor(Paint.valueOf("red"));
            txtNo.requestFocus();
        }
    }


    public void searchOnAction(ActionEvent actionEvent) {
        try {
            BusDTO busDTO=bo.getBus(txtBID.getText());
            if (txtBID.getText().trim().equals(busDTO.getBID())){
                txtName.setText(busDTO.getName());
                cmbRoute.getItems().addAll(busDTO.getRoute());
                txtDate.setValue(LocalDate.parse(busDTO.getDate()));
                cmbFacilities.getItems().addAll(busDTO.getFacilities());
                cmbType.getItems().addAll(busDTO.getType());
                txtOwnerName.setText(busDTO.getOwnerName());
                txtOwnerNIC.setText(busDTO.getOwnerNIC());
                txtOwnerAddress.setText(busDTO.getOwnerAddress());
                txtOwnerContactNo.setText(busDTO.getOwnerContactNo());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    }
