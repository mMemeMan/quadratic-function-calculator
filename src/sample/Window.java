package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Window {
    private Stage primaryStage = new Stage();

    public void newWindow(String fxml,boolean a) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        primaryStage.setTitle("Kalkulator");
        primaryStage.setScene(new Scene (root, 1007, 542));
        primaryStage.show();
        primaryStage.setMaximized(a);
    }
}
