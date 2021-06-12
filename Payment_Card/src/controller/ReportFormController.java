package controller;

import bo.BoFactory;
import bo.custom.BusBo;
import bo.custom.CardBo;
import bo.custom.CustomerBo;
import bo.custom.DriverBo;
import com.jfoenix.controls.JFXButton;
import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;/*
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;*/
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.HashMap;

public class ReportFormController {
    public Button btnCusReport;
    public Button btnCardReport;
    public Label lblCustomerCount;
    public Label lblCardCount;
    public AnchorPane PaneReport;
    public Button btnDriverReport;
    public Label lblDriverCount;
    public Button btnCusReport2;
    public Label lblBusCount;
    CustomerBo bo;
    CardBo bo2;
    DriverBo bo3;
    BusBo bo4;

    public void initialize() throws SQLException, ClassNotFoundException {
        bo = BoFactory.getInstance().getBO(BoFactory.BoType.CUSTOMER);
        bo2 = BoFactory.getInstance().getBO(BoFactory.BoType.CARD);
        bo3 = BoFactory.getInstance().getBO(BoFactory.BoType.DRIVER);
        bo4 = BoFactory.getInstance().getBO(BoFactory.BoType.BUS);

        int cardCount = bo2.getCardCount();
        lblCardCount.setText(cardCount + "");

        int customerCount = bo.getcustomerCount();
        lblCustomerCount.setText(customerCount + "");

        int driverCount = bo3.getDriverCount();
        lblDriverCount.setText(driverCount +"");

    }


    public void CusReportOnAction(ActionEvent actionEvent) throws JRException {

        try {
            InputStream is = this.getClass().getResourceAsStream("/reports/CusReport.jrxml");
            JasperReport jr = JasperCompileManager.compileReport(is);

            JasperPrint jp = JasperFillManager.fillReport(jr, null, DBConnection.getInstance().getConnection());
            //  JasperPrintManager.printReport(jp, true);
            JasperViewer.viewReport(jp, false);

        } catch (JRException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void CardReportOnAction(ActionEvent actionEvent) {
        try {
            InputStream is = this.getClass().getResourceAsStream("/reports/CardReport.jrxml");
            JasperReport jr = JasperCompileManager.compileReport(is);

            JasperPrint jp = JasperFillManager.fillReport(jr, null, DBConnection.getInstance().getConnection());
            //  JasperPrintManager.printReport(jp, true);
            JasperViewer.viewReport(jp, false);

        } catch (JRException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void DriverReportOnAction(ActionEvent actionEvent) {
        try {
            InputStream is = this.getClass().getResourceAsStream("/reports/DriverReport.jrxml");
            JasperReport jr = JasperCompileManager.compileReport(is);

            JasperPrint jp = JasperFillManager.fillReport(jr, null, DBConnection.getInstance().getConnection());
            //  JasperPrintManager.printReport(jp, true);
            JasperViewer.viewReport(jp, false);

        } catch (JRException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void BusReportOnAction(ActionEvent actionEvent) {
        try {
            InputStream is = this.getClass().getResourceAsStream("/reports/BusReport.jrxml");
            JasperReport jr = JasperCompileManager.compileReport(is);

            JasperPrint jp = JasperFillManager.fillReport(jr, null, DBConnection.getInstance().getConnection());
            //  JasperPrintManager.printReport(jp, true);
            JasperViewer.viewReport(jp, false);

        } catch (JRException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

