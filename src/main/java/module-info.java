module org.example.ecuacionesjava {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires java.sql;
    requires MaterialFX;

    opens org.example.ecuacionesjava to javafx.fxml;
    exports org.example.ecuacionesjava;
    exports org.example.ecuacionesjava.Controllers;
    opens org.example.ecuacionesjava.Controllers to javafx.fxml;
}