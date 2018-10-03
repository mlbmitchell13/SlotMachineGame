import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * This class creates the rules page which comes
 * right after the opening scene
 * @author Mitchell Edward Peters
 * @version 1.0.0
 */
public class Opener extends Vegas {
    private Stage stage;
    private Scene rulesScene;

    /**
     * This is the constructor for the rules scene
     * @param stage the stage that will hold the scene
     */
    public Opener(Stage stage) {
        this.stage = stage;

        ImageView rulesImage = new ImageView("Rules.jpg");
        rulesImage.setFitHeight(600);
        rulesImage.setFitWidth(1000);
        Button goToGame = new Button("Go To Game");
        goToGame.setPrefWidth(350);
        goToGame.setPrefHeight(75);
        goToGame.relocate(615, 500);
        goToGame.setOnAction(event -> {
                Slot slot = new Slot(stage);
            });
        Pane rulesPane = new Pane();
        rulesPane.getChildren().addAll(rulesImage, goToGame);
        rulesScene = new Scene(rulesPane);
        stage.setScene(rulesScene);

    }

}
