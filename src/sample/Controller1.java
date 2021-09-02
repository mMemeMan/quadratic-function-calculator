package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller1 {
    @FXML
    private Button glwindow;
    @FXML
    private Button praktik;

    @FXML
    void Glwindow(ActionEvent event) throws Exception { // название моей кнопки
        glwindow.getScene().getWindow().hide(); // закрываем текущее окно
        Window window = new Window();
        window.newWindow("scene.fxml",true);
    }
  @FXML
     void praktikwindow1(ActionEvent event) throws Exception {// название моей кнопки
        praktik.getScene().getWindow().hide(); // закрываем текущее окно
        Window window = new Window();
        window.newWindow("scene2.fxml",true);
    }
}
