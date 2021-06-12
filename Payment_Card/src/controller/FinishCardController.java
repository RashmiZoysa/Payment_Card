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

public class FinishCardController {
    public AnchorPane paneCardRegistered;
    public ImageView imghome;
    public JFXButton btnlogout;

    public void homeOnAction(MouseEvent actionEvent) throws IOException {
        setUI("MainForm.fxml");
    }

    public void logoutOnAction(ActionEvent actionEvent) throws IOException {
        setUI("LoginForm.fxml");
    }

    private void setUI(String location) throws IOException {
        Stage stage=(Stage)paneCardRegistered.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/"+location))));
        stage.show();
    }
}
