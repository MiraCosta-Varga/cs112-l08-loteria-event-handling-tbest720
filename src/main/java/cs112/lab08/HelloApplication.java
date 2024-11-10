package cs112.lab08;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Random;

import java.io.IOException;


public class HelloApplication extends Application  {

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


    //UI elements
        Label titlelabel = new Label("Welcome to ECHALE STEM loteria!"); // Top Label Title
        Label cardName = new Label();
        ImageView imageView = new ImageView();
        Button drawCardButton = new Button("Draw Random Card");
        ProgressBar progressBar = new ProgressBar();

    //Setting Default image and image properties
        Image defaultImage = new Image(getClass().getResourceAsStream("/images/0.png"));
        imageView.setImage(defaultImage);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(280);


    //Set up VBox container with UI elements
        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(titlelabel, imageView, cardName, drawCardButton, progressBar);
        vbox.setAlignment(javafx.geometry.Pos.CENTER); //Center all elements

    //Create new Random Object to determine which card is selected
        Random random = new Random();

    //Array to track if card has been drawn already
        int[] printedCards = new int[LOTERIA_CARDS.length];

        int numCardsDrawn = 0; //Tracks total cards already drawn for progress bar
    //Event handling for button click
        drawCardButton.setOnAction(e -> {


            int cardSelectNum = -1;
            boolean isCardDrawn = false;

            while (!isCardDrawn) {
                cardSelectNum = random.nextInt(LOTERIA_CARDS.length);
                if (printedCards[cardSelectNum] == 0) {
                    printedCards[cardSelectNum] = 1;
                    isCardDrawn = true;


                }
            }


            LoteriaCard card = LOTERIA_CARDS[cardSelectNum];
            Image image = new Image(getClass().getResourceAsStream("/images/" + card.getImageName()));
            imageView.setImage(image);
            cardName.setText(card.getCardName());
        });

        double progress = (double) numCardsDrawn/LOTERIA_CARDS.length;
        progressBar.setProgress(progress);



        Scene scene = new Scene(vbox, 350, 500);

        stage.setTitle("ECHALE STEM LOTERIA");
        stage.setScene(scene);
        stage.show();



    }

    public static void main(String[] args) {
        launch();
    }
}