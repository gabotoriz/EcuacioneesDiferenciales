package org.example.ecuacionesjava;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

import static org.example.ecuacionesjava.Switcher.setScene;
import static org.example.ecuacionesjava.Switcher.switchTo;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        var scene = new Scene(new Pane());
        setScene(scene);
        switchTo(Views.Main);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}