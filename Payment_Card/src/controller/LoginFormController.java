package controller;

import bo.BoFactory;
import bo.custom.UserBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.LoginDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    public AnchorPane paneLogin;
    public JFXTextField txtPassword;
    public JFXTextField txtName;
    public JFXButton btnLogin;
    UserBO bo;

    public void initialize(){
        bo= BoFactory.getInstance().getBO(BoFactory.BoType.USER);
    }
    public void LoginOnAction(ActionEvent actionEvent) throws Exception {
        LoginDTO loginDTO =bo.getAllDetails(txtName.getText());
        String designation ="";
        if (loginDTO.getPassword().equals(txtPassword.getText())){
            designation = loginDTO.getDesignation();
            switch (designation) {
                case "Admin":
                    setUI("AdminForm.fxml");
                    break;
                case "counter":
                    setUI("MainForm.fxml");
                    break;
            }
        }else {
            new Alert(Alert.AlertType.ERROR,"Incorrect password").show();
        }

    }


    public void setUI(String location) throws IOException {
        Stage stage = (Stage)paneLogin.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/"+location))));
        stage.show();
    }
}
