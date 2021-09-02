package sample;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Window window = new Window();
        window.newWindow("scene.fxml",true);
    }

    public static void main(String[] args) {

        launch(args);
    }

}
