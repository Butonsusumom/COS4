module com.tsybulko.cos4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tsybulko.cos4 to javafx.fxml;
    exports com.tsybulko.cos4;
    exports com.tsybulko.cos4.calculations;
    opens com.tsybulko.cos4.calculations to javafx.fxml;
}