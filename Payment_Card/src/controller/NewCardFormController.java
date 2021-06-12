package controller;

import bo.BoFactory;
import bo.custom.CardBo;
import bo.custom.PaymentBo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import dto.CardDTO;
import dto.TransportCategoryDTO;
import dto.categoryDTO;
import dto.custom.carddetailDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.regex.Pattern;

public class NewCardFormController {

    public JFXComboBox cmbDuration;
    public JFXDatePicker datePicker;
    public Label lblId;
    public JFXComboBox cmbTransCat;
    public JFXComboBox cmbDestination;
    public Label lblPrice;
    public JFXComboBox cmbCategory1;
    public JFXButton btnCalcualte;
    public JFXButton btnSave;
    public TextField txtnic;
    public AnchorPane paneNewCard;
    public JFXComboBox cmbType;
    public TextField lblDesc;

    CardBo bo;
    PaymentBo bo2;

    public void initialize() throws SQLException, ClassNotFoundException {
        bo= BoFactory.getInstance().getBO(BoFactory.BoType.CARD);
        bo2= BoFactory.getInstance().getBO(BoFactory.BoType.PAYMENT);
        cmbDuration.getItems().addAll("1 Month","3 Months","6 Months","1 Year");
        cmbDestination.getItems().addAll("Matara","Colombo","Hikkaduwa","Udugama","Mapalagama");
        cmbTransCat.getItems().addAll("Only People","People and Items","People and Animals","Items Only");
        cmbCategory1.getItems().addAll("Children","Adult");
        cmbType.getItems().addAll("Card","Cash");
        loadId();
    }

    private void loadId() throws SQLException, ClassNotFoundException {
        String id= bo.getID();
        lblId.setText(id);
    }

    @FXML
    void calculateOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String transport=cmbTransCat.getValue()+"";
        String destination=cmbDestination.getValue()+"";
        TransportCategoryDTO dto=bo.getTID(destination);
        double pricePerMonth=0;
        switch (transport)
        {
            case "Only People" : pricePerMonth=dto.getPeoplePrice();break;
            case "People and Items" : pricePerMonth=dto.getPeopleItemPrice();break;
            case "People and Animals" : pricePerMonth=dto.getPeoplePetPrice();break;
            case "Items Only" : pricePerMonth=dto.getItemPrice();break;
        }

        String b=cmbDuration.getValue()+"";
        int a=0;
        switch(b)
        {
            case "1 Month":a=1;break;
            case "3 Months":a=3;break;
            case "6 Months":a=6;break;
            case "1 Year":a=12;break;
        }

        double price=0;
        switch (cmbCategory1.getValue()+""){
            case "Adult" : price=pricePerMonth*a;break;
            case "Children" : price=(pricePerMonth*a)/2;break;
        }
        lblPrice.setText(price+"");
    }

    public void saveOnAction(ActionEvent actionEvent) throws Exception {
        if (Pattern.compile("^[0-9]{9,10}(v)$").matcher(txtnic.getText()).matches()) {

            String transport = cmbTransCat.getValue() + "";
            String destination = cmbDestination.getValue() + "";
            TransportCategoryDTO dto = bo.getTID(destination);
            String TID = dto.getTID();
            String duration = cmbDuration.getValue() + "";
            String ExpireDate = datePicker.getValue() + "";
            String catID=bo.getCatId(cmbCategory1.getValue() + "");
            String PID=bo2.getID();

            boolean isSaved=bo.saveDetails(
                    new carddetailDTO(
                            lblId.getText(),
                            txtnic.getText(),
                            dto.getTID(),
                            destination,
                            catID,
                            duration,
                            ExpireDate,
                            Double.parseDouble(lblPrice.getText())+200,
                            PID,
                            LocalDate.now()+"",
                            LocalTime.now()+"",
                            cmbType.getValue()+""
                    )
            );
            if(isSaved)
            {
                new Alert(Alert.AlertType.INFORMATION,"Details Saved").show();

                initUI("FinishCard.fxml");
            }
            else{
                new Alert(Alert.AlertType.ERROR,"Try Again !").show();
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Pattern not Matched");
            alert.show();
        }

    }


    public void categoryOnAction(ActionEvent actionEvent) {

        try {
            String catID= bo.getCatId(cmbCategory1.getValue() + "");
            categoryDTO dto2 = bo.getCatDetails(catID);
            lblDesc.setText(dto2.getDescription());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void initUI(String location) throws IOException {
        this.paneNewCard.getChildren().clear();
        this.paneNewCard.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/"+location)));

    }
}