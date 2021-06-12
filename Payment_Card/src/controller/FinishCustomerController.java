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

public class FinishCustomerController {
    public AnchorPane paneCustomerRegistered;
    public ImageView btnHome;
    public JFXButton btnLogOut;

    public void HomeOnAction(MouseEvent mouseEvent) throws IOException {
        setUI("MainForm.fxml");
    }


    public void LogOutOnAction(ActionEvent actionEvent) throws IOException {
        setUI("LoginForm.fxml");
    }

    private void setUI(String location) throws IOException {
        Stage stage = (Stage) paneCustomerRegistered.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/"+location))));
        stage.show();
    }
}
