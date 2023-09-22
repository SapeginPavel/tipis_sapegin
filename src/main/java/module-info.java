module com.example.tipis_sapegin {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tipis_sapegin to javafx.fxml;
    exports com.example.tipis_sapegin;
}