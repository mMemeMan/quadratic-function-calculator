package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

    @FXML
    private Button teory;
    @FXML
    private Button praktik;


    @FXML
    void teorywindow(ActionEvent event) throws Exception { // название моей кнопки
        teory.getScene().getWindow().hide(); // закрываем текущее окно
        Window window = new Window();
        window.newWindow("scene1.fxml",true);
    }

    @FXML
    public void praktikwindow(ActionEvent evented) throws Exception {// название моей кнопки
        praktik.getScene().getWindow().hide(); // закрываем текущее окно
        Window window = new Window();
        window.newWindow("scene2.fxml",true);
    }

    }
