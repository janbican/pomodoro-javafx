module com.github.janbican {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.github.janbican to javafx.fxml;
    exports com.github.janbican;
}