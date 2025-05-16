package com.mycompany.hotelmanagement.controllers;

import com.mycompany.hotelmanagement.App;
import java.io.IOException;
import javafx.fxml.FXML;

public class LoginController {

    @FXML
    private void switchToMain() throws IOException {
        App.setRoot("Main");
    }
}
