package controller;

import bo.BoFactory;
import bo.custom.PaymentBo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;
import dto.CustomerDto;
import dto.PaymentDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.regex.Pattern;

public class PaymentFormController {
    public AnchorPane panePayment;
    public TextField txtPrice;
    public JFXButton btnPrintBill;
    public TextField txtPID;
    public JFXButton btnPay;
    public JFXDatePicker txtDate;
    public JFXTimePicker txtTime;
    public JFXComboBox cmbPayType;
    public TextField txtCID;
    PaymentBo bo;

    public void initialize() throws SQLException, ClassNotFoundException {

        bo= BoFactory.getInstance().getBO(BoFactory.BoType.PAYMENT);
        loadId();
        cmbPayType.getItems().addAll("Cash Payment","Card Payment");

    }

    private void loadId() throws SQLException, ClassNotFoundException {
        String id= bo.getID();
        txtPID.setText(id);
    }

    public void PayOnAction(ActionEvent actionEvent) {

            if (Pattern.compile("^(C)[0-9]{3,4}$").matcher(txtCID.getText()).matches()) {

                   Alert alert=new Alert(Alert.AlertType.INFORMATION,"Pattern matched ");
                   alert.show();


                   try {
                       boolean isSaved=bo.savePayment(
                               new PaymentDTO(
                                       txtPID.getText(),
                                       txtCID.getText(),
                                       txtTime.getValue()+"",
                                       txtDate.getValue()+"",
                                       cmbPayType.getValue()+"",
                                       Double.parseDouble(txtPrice.getText())
                               )

                       );
                       System.out.println(isSaved);

                   } catch (Exception e) {
                       e.printStackTrace();
                   }
                            }else{
                                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Pattern not Matched");
                                alert.show();
                            }
    }

    public void BillOnAction(ActionEvent actionEvent) {
    }


    public void SearchOnAction(ActionEvent actionEvent) {
        try {
            PaymentDTO paymentDTO=bo.getPayment(txtPID.getText());
            if (!paymentDTO.equals(null)){
                txtCID.setText(paymentDTO.getCID());
                txtDate.setValue(LocalDate.parse(paymentDTO.getDate()+""));
                txtTime.setValue(LocalTime.parse(paymentDTO.getTime()+""));
                cmbPayType.setValue(paymentDTO.getType());
                txtPrice.setText(paymentDTO.getPrice()+"");;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
