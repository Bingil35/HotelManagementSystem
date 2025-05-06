module com.mycompany.hotelmanagement {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.hotelmanagement to javafx.fxml;
    exports com.mycompany.hotelmanagement;
}
