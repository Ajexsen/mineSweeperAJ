package View;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by ajex on 30.04.17.
 */
class SettingPop extends Stage {
    
    SettingPop(View view){
        this.resizableProperty().setValue(Boolean.FALSE);
        this.setTitle("Setting");
        this.initModality(Modality.APPLICATION_MODAL);


        GridPane settingPane = new GridPane();
        TextField widthText = new TextField();
        TextField heightText = new TextField();
        TextField boomText = new TextField();
        Button submit = new Button("Submit");
        settingPane.add(new Label("Width:"),0,1,1,1);
        settingPane.add(widthText, 1, 1,1,1);

        settingPane.add(new Label("Height:"),0,2,1,1);
        settingPane.add(heightText, 1, 2,1,1);

        settingPane.add(new Label("Mines:"),0,3,1,1);
        settingPane.add(boomText, 1, 3,1,1);

        settingPane.add(submit, 1, 4,2,1);

        settingPane.setHgap(10);
        settingPane.setVgap(10);
        settingPane.setPadding(new Insets(5, 10, 5, 10));

        submit.setOnAction(event2 -> {
            int width = Integer.valueOf(widthText.getText());
            int height = Integer.valueOf(heightText.getText());
            int boomNr = Integer.valueOf(boomText.getText());
            view.restart(width, height, boomNr);
            this.close();
        });

        Scene settingScene = new Scene(settingPane);

        this.setScene(settingScene);
        
    }
    
}
