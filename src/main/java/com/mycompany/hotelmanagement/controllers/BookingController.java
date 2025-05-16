package com.mycompany.hotelmanagement.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class BookingController {
    @FXML private Button checkoutPopupButton;
    @FXML private Button roomInfoButton;
    
    public void openPopup(String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL); // Popup phải được đóng trước khi quay lại main
            stage.showAndWait(); // Dùng show() nếu không cần đợi
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Popup Load Error");
            alert.setContentText("There was an error loading the popup.");
            alert.showAndWait();
        }
    }
    public void initialize() {
        if (checkoutPopupButton != null) {
            checkoutPopupButton.setOnAction(event -> openPopup("Checkout-popup.fxml", "Checkout Popup"));
        }

        if (roomInfoButton != null) {
            roomInfoButton.setOnAction(event -> openPopup("Room_info.fxml", "Room Infomation"));
        }
    }
}
