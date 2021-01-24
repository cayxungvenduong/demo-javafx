module frdp {
    requires kotlin.stdlib;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.web;

    opens com.demo.tunghoang.fxrdp to javafx.fxml;
    exports com.demo.tunghoang.fxrdp;
}