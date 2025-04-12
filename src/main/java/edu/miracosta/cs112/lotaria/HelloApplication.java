package edu.miracosta.cs112.lotaria;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class HelloApplication extends Application {
    private Button drawCardButton;
    private Label messageLabel;
    private ImageView cardImageView;
    private ProgressBar gameProgressBar;

    private int drawnCount = 0; // how many cards drawn
    private final boolean[] drawnFlags = new boolean[LOTERIA_CARDS.length];
    private final java.util.Random rand = new java.util.Random();

   private double progress = 0.0; // progress bar value for timer

    private static final LoteriaCard[] LOTERIA_CARDS = {
            new LoteriaCard("Las matematicas", "1.png", 1),
            new LoteriaCard("Las ciencias", "2.png", 2),
            new LoteriaCard("La Tecnología", "8.png", 8),
            new LoteriaCard("La ingeniería", "9.png", 9),

    };

    @Override
    public void start(Stage stage) {
        VBox root = new VBox(10); //layout with spacing between elements
        root.setAlignment(Pos.CENTER);

        Label titleLabel = new Label("Welcome to Sarah's Loteria!");
        cardImageView = new ImageView();
        messageLabel = new Label("Click the button to draw a card.");
        drawCardButton = new Button("Draw a Card");

        gameProgressBar = new ProgressBar(0.0); //start at empty
        gameProgressBar.setPrefWidth(250);
        gameProgressBar.setStyle("-fx-accent: violet;");


        // set image view size
        cardImageView.setFitWidth(200);
        cardImageView.setFitHeight(300);
        cardImageView.setPreserveRatio(true);

        AnimationTimer timer = new AnimationTimer() {
            private long lastUpdate = 0;

            @Override
            public void handle(long nanoTime) {
                if (nanoTime - lastUpdate > 16_000_000) { //60 fps
                    autoDraw();
                    lastUpdate = nanoTime;
                }
            }
        };
        timer.start();

        drawCardButton.setOnAction(new EventHandler <ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                drawCard();
            }
        });

        root.getChildren().addAll(titleLabel, cardImageView, messageLabel, drawCardButton, gameProgressBar);


        Scene scene = new Scene(root, 350, 500);
        stage.setTitle("Livin' La Vida Loteria!!!");
        stage.setScene(scene);
        stage.show();
    }

    private void autoDraw() {
        if(drawnCount < LOTERIA_CARDS.length) {
            progress += 0.005;
            gameProgressBar.setProgress(progress);

            if (progress >= 1.0) {
                drawCard();
                progress = 0.0;
            }
        }
    }

    private void drawCard() {
        if(drawnCount == LOTERIA_CARDS.length) {
            // game over logic
            gameProgressBar.setStyle("-fx-accent: crimson;");
            messageLabel.setText("Game Over! No more cards.\nExit and run program again to reset ^_^");
            drawCardButton.setDisable(true);

            // show ECHALE logo
            cardImageView.setImage(new LoteriaCard().getImage());
            return;
        }
        int index;
        do {
            index = rand.nextInt(LOTERIA_CARDS.length);
        } while (drawnFlags[index]);

        drawnFlags[index] = true;
        drawnCount++;

        LoteriaCard drawnCard = LOTERIA_CARDS[index];
        cardImageView.setImage(drawnCard.getImage());
        messageLabel.setText("Card #" + drawnCard.getCardNum() + ": " + drawnCard.getCardName());

        gameProgressBar.setProgress((double) drawnCount / LOTERIA_CARDS.length);
    }

    public static void main(String[] args) {

        launch();
    }
}