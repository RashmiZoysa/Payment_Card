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

public class AdminFormController {
    public JFXButton btnBus;
    public ImageView imgBack;
    public JFXButton btnReport;
    public AnchorPane paneAdmin;
    public ImageView imgCounter;
    public AnchorPane paneAdminDashBoard;
    public JFXButton btnDriver;
    public AnchorPane paneAdminForm;

    public void DriverOnAction(ActionEvent actionEvent) throws IOException {
        initUI("DriverSearch.fxml");
    }

    public void BusOnAction(ActionEvent actionEvent) throws IOException {
        initUI("BusSearch.fxml");
    }

    public void BackOnAction(MouseEvent mouseEvent) throws IOException {
        setUI("LoginForm.fxml");

    }

    public void ReportOnAction(ActionEvent actionEvent) throws IOException {
        initUI("ReportForm.fxml");
    }

    public void CounterOnAction(MouseEvent mouseEvent) throws IOException {
        setUI("MainForm.fxml");
    }

    private void initUI(String location) throws IOException {
        this.paneAdmin.getChildren().clear();
        this.paneAdmin.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/"+location)));

    }

    private void setUI(String location) throws IOException {
        Stage stage = (Stage) paneAdminForm.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/"+location))));
        stage.show();
    }
}
