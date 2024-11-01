package cs112.lab08;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    //CONSTANTS

    //array of LoteriaCards to use for game:
    private static final LoteriaCard[] LOTERIA_CARDS = {
            new LoteriaCard("Las matematicas", "1.png", 1),
            new LoteriaCard("Las ciencias", "2.png", 2),
            new LoteriaCard("La Tecnología", "8.png", 8),
            new LoteriaCard("La ingeniería", "9.png", 9),
    };


    @Override
    public void start(Stage stage) throws IOException {
        //removed FXML code, fill this in with components, scene, stage, etc.
    }

    public static void main(String[] args) {
        launch();
    }
}