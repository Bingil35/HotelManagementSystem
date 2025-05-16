package com.mycompany.hotelmanagement.controllers;

import com.mycompany.hotelmanagement.App;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import com.mycompany.hotelmanagement.utils.HoverImageHelper;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;


import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import javafx.scene.image.ImageView;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;



public class MainController implements Initializable {
    
    // sidebar and rootLayout
    @FXML private VBox leftSidebar, rightSidebar;
    @FXML private BorderPane rootLayout;
    @FXML private Pane contentCenter;
    
    // buttons and icons
    @FXML private Button homeButton;
    @FXML private ImageView homeIcon;
    
    @FXML private Button bookingButton;
    @FXML private ImageView bookingIcon;
    
    @FXML private Button checkinButton;
    @FXML private ImageView checkinIcon;
    
    @FXML private Button checkoutButton;
    @FXML private ImageView checkoutIcon;
    
    @FXML private Button serviceButton;
    @FXML private ImageView serviceIcon;
    
    @FXML private Button settingButton;
    @FXML private ImageView settingIcon;
    
    @FXML private Button infoButton;
    @FXML private ImageView infoIcon;
    
    @FXML private Button keyButton;
    @FXML private ImageView keyIcon;
    
    @FXML private Button logoutButton;
    @FXML private ImageView logoutIcon;
    
    // Xử lý Checkin Checkout hour
    @FXML private TextField checkinHour;
    @FXML private TextField checkoutHour;
    
    @FXML private CheckBox checkinTick;
    @FXML private CheckBox checkoutTick;
    
    
    // Xử lý chọn RoomType
    @FXML private CheckBox checkRoomtype;
    
    @FXML private ToggleGroup roomTypeGroup;
    @FXML private RadioButton singleBedType;
    @FXML private RadioButton doubleBedType;
    
   
    @FXML
    private void toggleBedType(ActionEvent event) {
        boolean isVisible = singleBedType.isVisible();
        
        singleBedType.setVisible(!isVisible);
        doubleBedType.setVisible(!isVisible);
    }
    
    @FXML
    private void selectBedType(ActionEvent event) {
        RadioButton selectedRadio = (RadioButton) roomTypeGroup.getSelectedToggle();
    }
    
    @FXML
    private void openCheckinHour(ActionEvent event) {
        boolean isVisible = checkinHour.isVisible();
        checkinHour.setVisible(!isVisible);
    }
    
    @FXML
    private void openCheckoutHour(ActionEvent event) {
        boolean isVisible = checkoutHour.isVisible();
        checkoutHour.setVisible(!isVisible);
    }
    
    
    private void expandSidebar() {
        if (leftSidebar == null) return;
        leftSidebar.setPrefWidth(210);
        for (Map.Entry<Button, String> entry : buttonTextMap.entrySet()) {
            entry.getKey().setText(entry.getValue());
        }
    }
    
    private void collapseSidebar() {
        if (leftSidebar == null) return;
        leftSidebar.setPrefWidth(70);
        for (Button b : buttonTextMap.keySet()) {
            b.setText("");
        }
    }
    
    // Xử lý sidebar
    @FXML
    private void toggleleftSidebar(ActionEvent event) {
        boolean isVisible = leftSidebar.isVisible();
        leftSidebar.setVisible(!isVisible);
    }
    
    @FXML
    private void togglerightSidebar(ActionEvent event) {
        boolean isVisible = rightSidebar.isVisible();
        rightSidebar.setVisible(!isVisible);
    }
    
    @FXML
    private void switchToLogin() throws IOException {
        App.setRoot("Login");
    }
    
    // Xử lý màn hình khi bật/tắt sidebar
    private void adjustLayout() {
        // Sau khi bật/tắt sidebar, điều chỉnh lại rootLayout
        if (leftSidebar.isVisible()) {
            rootLayout.setLeft(leftSidebar);
        } else {
            rootLayout.setLeft(null);
        }

        if (rightSidebar.isVisible()) {
            rootLayout.setRight(rightSidebar);
        } else {
            rootLayout.setRight(null);
        }
    
    }
    
    // Xử lý contentCenter
    @FXML
    private void loadHome() throws IOException {
        App.setRoot("Home");
    }
    
    @FXML
    private void loadCheckin() throws IOException {
        App.setRoot("Checkin");
    }
    
    @FXML
    private void loadBooking() throws IOException {
        App.setRoot("Booking");
    }
    
    @FXML
    private void loadCheckout() throws IOException {
        App.setRoot("Checkout");
    }
    
    @FXML
    private void loadService() throws IOException {
        App.setRoot("Service");
    }
    
    
    // Xử lý hover sidebar
    private Map<Button, String> buttonTextMap = new HashMap<>();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        HoverImageHelper.setupHoverEffect(homeButton, homeIcon, "Home-icon.png", "Home-icon-hover.png");
        HoverImageHelper.setupHoverEffect(bookingButton, bookingIcon, "Booking-icon.png", "Booking-icon-hover.png");
        HoverImageHelper.setupHoverEffect(checkinButton, checkinIcon, "Checkin-icon.png", "Checkin-icon-hover.png");
        HoverImageHelper.setupHoverEffect(checkoutButton, checkoutIcon, "Payment-icon.png", "Payment-icon-hover.png");
        HoverImageHelper.setupHoverEffect(serviceButton, serviceIcon, "Service-icon.png", "Service-icon-hover.png");
        HoverImageHelper.setupHoverEffect(settingButton, settingIcon,"Setting-icon.png", "Setting-icon-hover.png");
        HoverImageHelper.setupHoverEffect(infoButton, infoIcon, "Info-icon.png", "Info-icon-hover.png");
        HoverImageHelper.setupHoverEffect(keyButton, keyIcon, "Key-icon.png", "Key-icon-hover.png");
        HoverImageHelper.setupHoverEffect(logoutButton, logoutIcon, "Logout-icon.png", "Logout-icon-hover.png");
        
        buttonTextMap.put(homeButton, "Trang chủ");
        buttonTextMap.put(bookingButton, "Đặt phòng");
        buttonTextMap.put(checkinButton, "Check-in");
        buttonTextMap.put(checkoutButton, "Check-out");
        buttonTextMap.put(serviceButton, "Dịch vụ");
        buttonTextMap.put(settingButton, "Cài đặt");
        
        collapseSidebar();
        
        leftSidebar.setOnMouseEntered(e -> expandSidebar());
        leftSidebar.setOnMouseExited(e -> collapseSidebar());
        
    }
}
