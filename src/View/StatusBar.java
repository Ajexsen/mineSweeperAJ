package View;

import Controller.Controller;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

/**
 * Created by Ajex
 * github: https://github.com/Ajexsen/
 */
class StatusBar extends GridPane {
    private Controller controller;
    private Button startButt;


    private Counter boomNr;
    private Counter timerLabel;


    private int timeSeconds = 0;
    private int boomCount;

    private boolean isRunning = false;

    StatusBar(Controller controller) {
        this.controller = controller;


        startButt = new Button("Start");
        boomCount = controller.getBoomNr();
        boomNr = new Counter("BOOM:");
        boomNr.setCounter(boomCount);
        timerLabel = new Counter("TIME:");

        startButt.setOnAction(e -> {
            controller.getView().restart(30,30,50);
            Timeline timeline = controller.timeline;
            if (isRunning) {
                isRunning = false;
                timeline.pause();
            } else {
                isRunning = true;
                timerLabel.setCounter(timeSeconds);
                controller.timeline = new Timeline();
                timeline = controller.timeline;
                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.getKeyFrames().add(
                        new KeyFrame(Duration.seconds(1),
                                event -> {
                                    timeSeconds++;
                                    timerLabel.setCounter(timeSeconds);
                                    if (timeSeconds <= 0) {
                                        controller.timeline.stop();
                                    }
                                }));
                timeline.playFromStart();
            }
        });

        this.add(boomNr,0,0,1,1);
        this.add(startButt,1,0,1,1);
        this.add(timerLabel,2,0,1,1);

        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(10, 5, 15, 5));
    }

    public void setNr(int nr) {
        nr = boomCount - nr;
        System.out.println("" + nr);
        //boomNr.setText("" + nr);
    }
}
