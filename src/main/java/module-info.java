module com.github.janbican {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens com.github.janbican to javafx.fxml;
    exports com.github.janbican;
}