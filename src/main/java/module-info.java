module com.example.comp228_f22_lab5 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires java.sql.rowset;

    opens com.example.comp228_f22_lab5 to javafx.fxml;
    exports com.example.comp228_f22_lab5;
}