module cs112.lab08 {
    requires javafx.controls;
    requires javafx.fxml;


    opens cs112.lab08 to javafx.fxml;
    exports cs112.lab08;
}