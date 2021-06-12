package controller;

import bo.BoFactory;
import bo.custom.CardBo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import dto.CardDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class CardFormController {

    public AnchorPane paneMainCard;
    public TextField txtCaID;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;
    public TextField txtNIC;
    public TextField txtDestination;
    public JFXComboBox cmbDuration;
    public JFXButton btnNew;
    public TextField txtPrice;
    public TextField txtCID;
    public TextField txttid;
    public JFXDatePicker lblexpDate;
    public TextField cmbCate;
    CardBo bo;


    public void initialize(){

        bo= BoFactory.getInstance().getBO(BoFactory.BoType.CARD);
        cmbDuration.getItems().addAll("1 Month","3 Months","6 Months","1 Year");

    }


   public void UpdateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String category = cmbCate.getText();
        String duration = cmbDuration.getValue() + "";

        boolean isUpdated = bo.updateCard(
                new CardDTO(txtCaID.getText(),
                        txttid.getText(),
                        txtNIC.getText(),
                        txtDestination.getText(),
                        cmbCate.getText(),
                        cmbDuration.getValue() + "",
                        lblexpDate.getValue()+"",
                        Double.parseDouble(txtPrice.getText()))
        );

        System.out.println(isUpdated);

    }


    public void DeleteOnAction(ActionEvent actionEvent) {
        boolean isDeleted= false;
        try {
            isDeleted = bo.deleteCard(txtCaID.getText());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(isDeleted);

    }

    public void searchOnAction(ActionEvent actionEvent) throws Exception {
            CardDTO cardDto = bo.getCard(txtCID.getText());
            if (txtCID.getText().trim().equals(cardDto.getCID())) {
                txtNIC.setText(cardDto.getNic());
                txttid.setText(cardDto.getTid());
                txtDestination.setText(cardDto.getDestination());
                cmbCate.setText(cardDto.getCategoryID());
                cmbDuration.getItems().addAll(cardDto.getDuration());
                cmbDuration.setValue(cardDto.getDuration());
                lblexpDate.setValue(LocalDate.parse(cardDto.getExpireDate()));
                txtPrice.setText(cardDto.getPrice() + "");

            }
    }

    public void NewOnAction(ActionEvent actionEvent) throws IOException {
        initUI("NewCardForm.fxml");
    }

    private void initUI(String location) throws IOException {
        this.paneMainCard.getChildren().clear();
        this.paneMainCard.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/"+location)));
    }

    public void setUI(String location) throws IOException {
        Stage stage = (Stage) paneMainCard.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/" + location))));
    }
}
