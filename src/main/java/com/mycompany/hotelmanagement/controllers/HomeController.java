package com.mycompany.hotelmanagement.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class HomeController {
    @FXML
    private TableView<?> homeTable;  // nhớ khai báo đúng kiểu

    @FXML
    public void initialize() {
        homeTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
}
