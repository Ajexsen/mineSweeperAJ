import Controller.Controller;
import Model.Model;
import View.View;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by Ajex
 * github: https://github.com/Ajexsen/
 */

public class main extends Application {
    private Model model;
    private Controller controller;
    private View view;

    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("MineSweeper");
        model = new Model(15, 15, 15);
        controller = new Controller(model);
        view = new View(controller);

        Scene scene = new Scene(view);
        scene.setFill(Color.OLDLACE);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
