package controller;

import bo.BoFactory;
import bo.custom.CustomerBo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import dto.CustomerDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.regex.Pattern;

public class CustomerController {

    public JFXButton btnUpdate;
    public JFXButton btnSave;
    public AnchorPane paneCustomer;
    public JFXButton btnDelete;
    public TextField txtNIC;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtContactNo;
    public JFXTextField txtEmail;
    public JFXDatePicker txtDOB;
    CustomerBo bo;


    public void initialize(){

        bo= BoFactory.getInstance().getBO(BoFactory.BoType.CUSTOMER);
    }

    public void SaveOnAction(ActionEvent actionEvent) throws IOException {

        if (Pattern.compile("^[0-9]{9,12}(v)$").matcher(txtNIC.getText()).matches()) {
            if (Pattern.compile("^[A-z ]{1,100}$").matcher(txtName.getText()).matches()) {
                if (Pattern.compile("^[A-z ]{1,100}$").matcher(txtAddress.getText()).matches()) {
                    if (Pattern.compile("^[0-9]{10}$").matcher(txtContactNo.getText()).matches()) {


                            boolean isSaved = false;
                            try {
                                isSaved = bo.SaveCustomer(
                                        new CustomerDto(txtNIC.getText(),
                                                txtName.getText(),
                                                txtDOB.getValue()+"",
                                                txtAddress.getText(),
                                                txtContactNo.getText(),
                                                txtEmail.getText())
                                );
                                System.out.println(isSaved);
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            }

                        initUI("FinishCustomer.fxml");


                    }else{ Alert alert = new Alert(Alert.AlertType.INFORMATION, "Pattern not Matched");
                            alert.show();
                            txtEmail.setFocusColor(Paint.valueOf("red"));
                            txtEmail.requestFocus();
                        }
                    }else{
                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Pattern not Matched");
                        alert.show();
                        txtContactNo.setFocusColor(Paint.valueOf("red"));
                        txtContactNo.requestFocus();
                    }
                }else{
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Pattern not Matched");
                    alert.show();
                    txtAddress.setFocusColor(Paint.valueOf("red"));
                    txtAddress.requestFocus();
                }
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Pattern not Matched");
                alert.show();
                txtName.setFocusColor(Paint.valueOf("red"));
                txtName.requestFocus();
            }


    }

    public void UpdateOnAction(ActionEvent actionEvent) {
        boolean isSaved = false;
        try {
            isSaved = bo.UpdateCustomer(
                    new CustomerDto(txtNIC.getText(),
                            txtName.getText(),
                           txtDOB.getValue()+"",
                            txtAddress.getText(),
                            txtContactNo.getText(),
                            txtEmail.getText())
            );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(isSaved);

    }

    public void DeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        boolean isDeleted=bo.DeleteCustomer(txtNIC.getText());

        System.out.println(isDeleted);

    }





    public void searchOnAction(ActionEvent actionEvent) {
        try {
            CustomerDto customerDto=bo.getCustomer(txtNIC.getText());
            if (!customerDto.equals(null)){
                txtName.setText(customerDto.getCustomerName());
                txtDOB.setValue(LocalDate.parse(customerDto.getDob()+""));
                txtAddress.setText(customerDto.getAddress());
                txtContactNo.setText(customerDto.getContactNo());
                txtEmail.setText(customerDto.getEmail());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initUI(String location) throws IOException {
        this.paneCustomer.getChildren().clear();
        this.paneCustomer.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/"+location)));

    }
    }



