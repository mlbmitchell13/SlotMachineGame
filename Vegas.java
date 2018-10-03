import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

/**
 * I worked on this project by
 * myself and with no one else
 *
 * This class creates the open scene for game
 * @author Mitchell Edward Peters
 * @version 1.0.0
 */
public class Vegas extends Application {

    private ImageView background;
    private Scene main;

    /**
     * this is the main method that launches the program
     * @param args launches program
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * This is the start method which runs the program
     * @param primaryStage sets up the window
     * @throws Exception if images don't exist,
     * it catches the exception
     */
    public void start(Stage primaryStage) throws Exception {

        StackPane home = new StackPane();
        background = new ImageView("giphy.gif");
        background.setOnMouseClicked(event -> {
                Opener open = new Opener(primaryStage);
            });
        home.getChildren().add(background);
        main = new Scene(home);
        primaryStage.setScene(main);
        primaryStage.sizeToScene();
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}