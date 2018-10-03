import java.util.Random;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javafx.scene.layout.CornerRadii;
import javafx.geometry.Insets;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Background;

/**
 * This class creates the slot machine game in regular mode
 * @author Mitchell Edward Peters
 * @version 1.0.0
 */
public class Slot extends Vegas {

    private TextField betField;
    private StackPane home = new StackPane();
    private Pane pane = new Pane();
    private Rectangle leftRectangle;
    private Rectangle midRectangle;
    private Rectangle rightRectangle;
    private Rectangle backGroundRec;
    private Rectangle moneyRec;
    private Stage stage;
    private ImageView background;
    private ImageView spinButton;
    private ImageView youLose;
    private Text money;
    private Scene rulesScene;
    private static int bet;
    private static int balance = 100;
    private static Scene main;

    /**
     * This is a constructor for the Slot game
     * @param stage inputs the stage to display that game on
     */
    public Slot(Stage stage) {
        this.stage = stage;

        //**** Creating the Bet Label ****\\
        Rectangle betRec = new Rectangle(50, 35);
        betRec.setFill(Color.BLACK);
        betRec.relocate(165, 435);
        Text betLabel = new Text("Bet: ");
        betLabel.setFont(Font.font("American Typewriter", 20));
        betLabel.setFill(Color.YELLOW);
        betLabel.relocate(170, 440);
        betField = new TextField("Place bet here");
        betField.relocate(220, 440);
        pane.getChildren().addAll(betRec, betLabel, betField);
        //********************************\\

        //*********** MenuBar ***********\\
        Menu file = new Menu("File");
        MenuItem exitbutton = new MenuItem("Exit");
        exitbutton.setOnAction(e -> {
                Platform.exit();
                System.exit(0);
            });
        file.getItems().add(exitbutton);

        Menu options = new Menu("Mode");
        MenuItem test = new MenuItem("Test");
        options.setOnAction(event -> {
                Test testing = new Test(stage);
            });
        options.getItems().addAll(test);

        Menu help = new Menu("Rules");
        MenuItem rules = new MenuItem("Rules");
        help.getItems().add(rules);
        ImageView rulesImage = new ImageView("Rules.jpg");
        rulesImage.setFitHeight(600);
        rulesImage.setFitWidth(1000);
        Pane rulesPane = new Pane();
        Button goToGame = new Button("Go To Game");
        goToGame.setPrefWidth(350);
        goToGame.setPrefHeight(75);
        goToGame.relocate(615, 500);
        goToGame.setOnAction(event -> {
                stage.setScene(main);
            });
        rulesPane.getChildren().addAll(rulesImage, goToGame);
        rulesScene = new Scene(rulesPane);
        rules.setOnAction(event -> {
                stage.setScene(rulesScene);
            });

        MenuBar menubar = new MenuBar(file, options, help);
        VBox mainmenu = new VBox();
        //********************************\\

        //*********** Spin Button **********\\
        spinButton = new ImageView("SpinButton.png");
        spinButton.relocate(625, 225);
        spinButton.setFitWidth(150);
        spinButton.setFitHeight(150);
        //***********************************\\

        //************ Slot Format *************\\
        leftRectangle = new Rectangle(100, 150);
        leftRectangle.setFill(Color.WHITE);
        leftRectangle.relocate(185, 225);
        midRectangle = new Rectangle(100, 150);
        midRectangle.setFill(Color.WHITE);
        midRectangle.relocate(295, 225);
        rightRectangle = new Rectangle(100, 150);
        rightRectangle.setFill(Color.WHITE);
        rightRectangle.relocate(405, 225);
        backGroundRec = new Rectangle(360, 200);
        backGroundRec.setFill(Color.BLACK);
        backGroundRec.relocate(165, 200);
        pane.getChildren().addAll(backGroundRec, leftRectangle,
                midRectangle, rightRectangle, spinButton);
        //**************************************\\

        //****** Creating Money Label *******\\
        money = new Text("Current Balance: $" + balance);
        money.setFont(Font.font("American Typewriter", 57));
        money.setFill(Color.YELLOW);
        money.relocate(120, 35);
        moneyRec = new Rectangle(800, 100);
        moneyRec.setFill(Color.BLACK);
        moneyRec.relocate(100, 20);
        pane.getChildren().addAll(moneyRec, money);
        //***********************************\\

        //**** Creating the Regular Mode Label****\\
        Rectangle modeRec = new Rectangle(200, 50);
        modeRec.setFill(Color.BLACK);
        modeRec.relocate(760, 525);
        Text regular = new Text("MODE: Regular");
        regular.setFont(Font.font("American Typewriter", 25));
        regular.setFill(Color.YELLOW);
        regular.relocate(770, 535);
        pane.getChildren().addAll(modeRec, regular);
        //****************************************\\

        //***** Functionality of Spin Button *****\\
        spinButton.setOnMouseClicked(event -> {
                int first = randomNumber();
                int second = randomNumber();
                int third = randomNumber();
                int[] numberList = {first, second, third};
                String image;
                int multiplier;
                for (int i = 0; i < numberList.length; i++) {
                    switch (numberList[i]) {
                    case 1: image = "Grapes.jpg";
                        ImageView grape = new ImageView(image);
                        switch (i) {
                        case 0: grape.relocate(185, 225);
                                        grape.setFitHeight(150);
                                        grape.setFitWidth(100);
                                        pane.getChildren().add(grape);
                                        break;

                        case 1: grape.relocate(295, 225);
                                        grape.setFitHeight(150);
                                        grape.setFitWidth(100);
                                        pane.getChildren().add(grape);
                                        break;

                        case 2: grape.relocate(405, 225);
                                        grape.setFitHeight(150);
                                        grape.setFitWidth(100);
                                        pane.getChildren().add(grape);
                                        break;
                        default:
                        }
                            break;
                    case 2: image = "Cherries.jpg";
                        ImageView cherries = new ImageView(image);
                        switch (i) {
                        case 0: cherries.relocate(185, 225);
                                        cherries.setFitHeight(150);
                                        cherries.setFitWidth(100);
                                        pane.getChildren().add(cherries);
                                        break;

                        case 1: cherries.relocate(295, 225);
                                        cherries.setFitHeight(150);
                                        cherries.setFitWidth(100);
                                        pane.getChildren().add(cherries);
                                        break;

                        case 2: cherries.relocate(405, 225);
                                        cherries.setFitHeight(150);
                                        cherries.setFitWidth(100);
                                        pane.getChildren().add(cherries);
                                        break;
                        default:

                        }
                            break;
                    case 3: image = "Bell.jpg";
                        ImageView bell = new ImageView(image);
                        switch (i) {
                        case 0: bell.relocate(185, 225);
                                        bell.setFitHeight(150);
                                        bell.setFitWidth(100);
                                        pane.getChildren().add(bell);
                                        break;

                        case 1: bell.relocate(295, 225);
                                        bell.setFitHeight(150);
                                        bell.setFitWidth(100);
                                        pane.getChildren().add(bell);
                                        break;

                        case 2: bell.relocate(405, 225);
                                        bell.setFitHeight(150);
                                        bell.setFitWidth(100);
                                        pane.getChildren().add(bell);
                                        break;
                        default:
                        }
                            break;
                    default: image = "Bar.jpg";
                        ImageView bar = new ImageView(image);
                        switch (i) {
                        case 0: bar.relocate(185, 225);
                                        bar.setFitHeight(150);
                                        bar.setFitWidth(100);
                                        pane.getChildren().add(bar);
                                        break;

                        case 1: bar.relocate(295, 225);
                                        bar.setFitHeight(150);
                                        bar.setFitWidth(100);
                                        pane.getChildren().add(bar);
                                        break;

                        case 2: bar.relocate(405, 225);
                                        bar.setFitHeight(150);
                                        bar.setFitWidth(100);
                                        pane.getChildren().add(bar);
                                        break;
                        default:
                        }
                            break;
                    }
                }


                if (numberList[0] == 3 && numberList[1] == 3
                        && numberList[2] == 3) { // bell bell bell
                    multiplier = 10;
                } else if (numberList[0] == 1
                        && numberList[1] == 1
                        && numberList[2] == 1) { // grape grape grape
                    multiplier = 7;
                } else if (numberList[0] == 2
                        && numberList[1] == 2
                        && numberList[2] == 2) { // cherry cherry cherry
                    multiplier = 5;
                } else if (numberList[0] == 2
                        && numberList[1] == 2) { // cherry cherry *
                    multiplier = 3;
                } else if (numberList[0] == 2
                        && numberList[2] == 2) { // cherry * cherry
                    multiplier = 3;
                } else if (numberList[1] == 2
                        && numberList[2] == 2) { // * cherry cherry
                    multiplier = 3;
                } else if (numberList[0] == 2
                        && numberList[1] == numberList[2]) { // cherry * *
                    multiplier = 1;
                } else if (numberList[1] == 2
                        && numberList[0] == numberList[2]) { // * cherry *
                    multiplier = 1;
                } else if (numberList[2] == 2
                        && numberList[0] == numberList[1]) { // * * cherry
                    multiplier = 1;
                } else {
                    multiplier = -1;
                }

                String betString = betField.getText();

                if (betString.length() == 0) {
                    bet = 1;
                } else {
                    try {
                        bet = Integer.parseInt(betString);
                    } catch (Exception e) {
                        bet = 1;
                    }
                }

                if (bet > balance) {
                    bet = balance;
                }
                if (bet < 0) {
                    bet = Math.abs(bet);
                }

                balance = balance + (bet * multiplier);
                money.setText("Current Balance: $" + balance);

                betField.clear();
                bet = 0;

                if (balance <= 0) {
                    Button exit = new Button("Exit");
                    exit.setOnAction(event1 -> {
                            System.exit(0);
                        });
                    exit.setPrefHeight(35);
                    exit.setPrefWidth(75);
                    exit.relocate(468, 400);
                    youLose = new ImageView("Backup-Background.gif");
                    youLose.setFitWidth(1000);
                    youLose.setFitHeight(600);
                    Text outOfMoney = new Text("OUT OF MONEY");
                    Text gameOver = new Text("GAME OVER");
                    Rectangle gameOverRec = new Rectangle(700, 400);
                    gameOverRec.setFill(Color.BLACK);
                    gameOverRec.relocate(150, 100);
                    outOfMoney.setFont(Font.font("American Typewriter", 75));
                    outOfMoney.setFill(Color.YELLOW);
                    outOfMoney.relocate(210, 190);
                    gameOver.setFont(Font.font("American Typewriter", 75));
                    gameOver.setFill(Color.YELLOW);
                    gameOver.relocate(270, 280);
                    pane.getChildren().addAll(youLose, gameOverRec,
                            exit, gameOver, outOfMoney);
                }
            });
        //****************************************\\

        background = new ImageView("Backup-Background.gif");
        background.setFitHeight(600);
        background.setFitWidth(1000);
        home.getChildren().addAll(background, pane);
        mainmenu.getChildren().addAll(menubar, home);
        main = new Scene(mainmenu);
        stage.setScene(main);
        stage.setResizable(false);
        stage.show();

    }

    /**
     * This is a method that generates a random number
     * for generating the choice of symbols for slot
     * machine
     * @return a random integer
     */
    public int randomNumber() {
        Random rn = new Random();
        int num = rn.nextInt(8) + 1;
        if (num >= 4) {
            num = 4;
        }
        return num;
    }
}
