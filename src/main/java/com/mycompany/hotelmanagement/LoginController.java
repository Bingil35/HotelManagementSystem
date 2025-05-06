package com.mycompany.hotelmanagement;

import java.io.IOException;
import javafx.fxml.FXML;

public class LoginController {

    @FXML
    private void switchToDashboard() throws IOException {
        App.setRoot("Home");
    }
}
