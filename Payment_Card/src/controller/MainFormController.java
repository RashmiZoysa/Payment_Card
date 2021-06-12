package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFormController {
    public JFXButton btnCustomer;
    public JFXButton btnCard;
    public JFXButton btnPayment;
    public ImageView imgBack;
    public AnchorPane paneDashBoard;
    public AnchorPane paneCounter;



    private void initUI(String location) throws IOException {
        this.paneCounter.getChildren().clear();
        this.paneCounter.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/"+location)));
    }

    public void CustomerOnAction(ActionEvent actionEvent) throws IOException {
        initUI("CustomerForm.fxml");
    }

    public void CardOnAction(ActionEvent actionEvent) throws IOException {
        initUI("CardForm.fxml");
    }

    public void PaymentOnAction(ActionEvent actionEvent) throws IOException {
        initUI("PaymentForm.fxml");
    }


    public void BackOnAction(MouseEvent mouseEvent) throws IOException {
        setUI("LoginForm.fxml");
    }

    public void ReportOnAction(ActionEvent actionEvent) throws IOException {
        initUI("ReportForm.fxml");
    }

    private void setUI(String location) throws IOException {
        Stage stage = (Stage) paneDashBoard.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/"+location))));
        stage.show();
    }

}
