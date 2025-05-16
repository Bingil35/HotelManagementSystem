module com.mycompany.hotelmanagement {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.hotelmanagement.controllers to javafx.fxml;
    exports com.mycompany.hotelmanagement;
}
