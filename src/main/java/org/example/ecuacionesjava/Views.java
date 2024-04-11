package org.example.ecuacionesjava;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@AllArgsConstructor
public enum Views {
    Main("main-view.fxml"),
    Theory("teoria-view.fxml"),
    Examples("ejemplos-view.fxml"),
    Cuestionary("form-view.fxml");
    String FileName;
}
