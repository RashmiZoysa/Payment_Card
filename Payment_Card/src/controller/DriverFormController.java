package controller;

import bo.BoFactory;
import bo.custom.DriverBo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import dto.CustomerDto;
import dto.DriverDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.regex.Pattern;

public class DriverFormController {
    public AnchorPane paneNewDriver;
    public TextField txtDID;
    public JFXButton btnSave;
    public JFXTextField txtNIC;
    public JFXTextField txtAddress;
    public JFXTextField txtContactNo;
    public JFXDatePicker txtDOB;
    public JFXTextField txtName;
    DriverBo bo;

    public void initialize() throws SQLException, ClassNotFoundException {

        bo= BoFactory.getInstance().getBO(BoFactory.BoType.DRIVER);
        loadDID();
    }

    private void loadDID() throws SQLException, ClassNotFoundException {
        String did= bo.getdid();
        txtDID.setText(did);
    }

    public void SaveOnAction(ActionEvent actionEvent) {
        if (Pattern.compile("^[A-z ]{1,100}$").matcher(txtName.getText()).matches()) {
            if (Pattern.compile("^[0-9]{9,12}(v)$").matcher(txtNIC.getText()).matches()) {
                if (Pattern.compile("^[A-z ]{1,100}$").matcher(txtAddress.getText()).matches()) {
                    if (Pattern.compile("^[0-9]{10}$").matcher(txtContactNo.getText()).matches()) {

                        boolean isSaved = false;
                        try {
                            isSaved = bo.SaveDriver(
                                    new DriverDTO(txtDID.getText(),
                                            txtName.getText(),
                                            txtNIC.getText(),
                                            txtDOB.getValue() + "",
                                            txtAddress.getText(),
                                            txtContactNo.getText())
                            );
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }

                        System.out.println(isSaved);
                    } else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Pattern not Matched");
                        alert.show();
                        txtContactNo.setFocusColor(Paint.valueOf("red"));
                        txtContactNo.requestFocus();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Pattern not Matched");
                alert.show();
                txtAddress.setFocusColor(Paint.valueOf("red"));
                txtAddress.requestFocus();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Pattern not Matched");
            alert.show();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Pattern not Matched");
            alert.show();
            txtName.setFocusColor(Paint.valueOf("red"));
            txtName.requestFocus();
            }
        }


    public void searchOnAction(ActionEvent actionEvent) {

        try {
            DriverDTO driverDTO=bo.getDriver(txtDID.getText());
            if (txtDID.getText().trim().equals(driverDTO.getDID())){
            txtName.setText(driverDTO.getName());
            txtNIC.setText(driverDTO.getNIC());
            txtDOB.setValue(LocalDate.parse(driverDTO.getDOB()+""));
            txtAddress.setText(driverDTO.getAddress());
            txtContactNo.setText(driverDTO.getContactNo());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        }
    }



