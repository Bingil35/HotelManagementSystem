package com.mycompany.hotelmanagement.controllers;

import com.mycompany.hotelmanagement.App;
import java.io.IOException;
import javafx.fxml.FXML;

public class SidebarController {
    @FXML
    private void switchToLogin() throws IOException {
        App.setRoot("Login");
    }
}
