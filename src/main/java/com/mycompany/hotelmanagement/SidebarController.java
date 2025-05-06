package com.mycompany.hotelmanagement;

import java.io.IOException;
import javafx.fxml.FXML;

public class SidebarController {
    @FXML
    private void switchToLogin() throws IOException {
        App.setRoot("Login");
    }
}
