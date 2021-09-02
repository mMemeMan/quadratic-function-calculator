package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Function;

import static java.lang.StrictMath.sqrt;

public class Controller2 implements Initializable {
    double a;
    double b;
    double c;
    double D;
    double x1;
    double x2;

    @FXML
    private LineChart<Double, Double> lineGraph;

    @FXML
    private AreaChart<Double, Double> areaGraph;

    @FXML
    private Button lineGraphButton;

    @FXML
    private Button areaGraphButton;

    @FXML
    private TextField tx_rasmer;

    @FXML
    private Button btn_rasmer;

    @FXML
    private NumberAxis NA1;

    @FXML
    private NumberAxis NA2;

    @FXML
    private NumberAxis NA3;

    @FXML
    private NumberAxis NA4;

    @FXML
    private TextField text1;

    @FXML
    private TextField text2;

    @FXML
    private TextField text3;

    @FXML
    private TextArea TextArea;

    @FXML
    private Button teory;

    @FXML
    private Button glwindow;

    @FXML
    private Button btn_test;


    private MyGraph mathsGraph;
    private MyGraph areaMathsGraph;


    @FXML                  //система контроля размера графика
    private void rasmer(final ActionEvent event) {
        rasmer1();
    }


    public void rasmer1() {
        int Os = 10;                              // Os - ось
        try {
            Os = Integer.parseInt(tx_rasmer.getText());
        } catch (RuntimeException e) {
            tx_rasmer.clear();
        }
        NA1.setUpperBound(Os);                    //NA- Number
        NA1.setLowerBound(-1 * Os);

        NA2.setUpperBound(Os);
        NA2.setLowerBound(-1 * Os);

        NA3.setUpperBound(Os);
        NA3.setLowerBound(-1 * Os);

        NA4.setUpperBound(Os);
        NA4.setLowerBound(-1 * Os);

        MyGraph(Os);
        clear();
        Btn_start1();
    }

    @Override
    public void initialize(final URL url, final ResourceBundle rb) {//инициализация
        MyGraph(10); //размер графика по умолчанию
    }

    public void MyGraph(int Os) {
        areaMathsGraph = new MyGraph(areaGraph, Os);
        mathsGraph = new MyGraph(lineGraph, Os);
    }


    @FXML
    private void handleLineGraphButtonAction(final ActionEvent event) {//включение линейного графика
        lineGraph.setVisible(true);
        areaGraph.setVisible(false);
        Btn_start1();
    }

    @FXML
    private void handleAreaGraphButtonAction(final ActionEvent event) {//включение ареаграфика
        areaGraph.setVisible(true);
        lineGraph.setVisible(false);
        Btn_start1();
    }


    private void plotLine(Function<Double, Double> function) {
        if (lineGraph.isVisible()) {
            mathsGraph.plotLine(function);
        } else {
            areaMathsGraph.plotLine(function);
        }
    }

    @FXML
    private void Btn_start(ActionEvent actionEvent) {
        boolean run = true;
        while (run) {
            try {
                a = Double.parseDouble(text1.getText());
            } catch (RuntimeException e) {
                TextArea.setText("Ошибка, значение а обязательно");
                run = false;
                break;
            }
            Btn_start1();
            TextArea.clear();
            pojasnenie(x1, x2, a, b, c, D);
            run = false;
        }
    }

    private void Btn_start1() {
        clear();
        boolean run = true;
        while (run) {
            try {
                a = Double.parseDouble(text1.getText());
            } catch (RuntimeException e) {
                run = false;
                break;
            }
            try {
                b = Double.parseDouble(text2.getText());
            } catch (RuntimeException e) {
                b = 0;
            }
            try {
                c = Double.parseDouble(text3.getText());
            } catch (RuntimeException e) {
                c = 0;
            }
            D = Math.pow(b, 2) - 4 * a * c;

            x1 = ((-b) + sqrt(D)) / (2 * a);//нахождение х1
            x1 = Math.round(x1 * 100) / 100.00;//округление


            x2 = ((-b) - sqrt(D)) / (2 * a);//нахождение х2
            x2 = Math.round(x2 * 100) / 100.00;//округление

            graphik(a, b, c, D);
            run = false;
        }
    }

    private void pojasnenie(double x1, double x2, double a, double b, double c, double D) {
        boolean run = true;
        String ob_opr = "";
        while (run) {
            if (a * Math.pow(1, 2) + b * 1 + c == a * Math.pow(-1, 2) + b * -1 + c) {
                ob_opr = "четная";
            } else if (a * Math.pow(1, 2) + b * 1 + c != a * Math.pow(-1, 2) + b * -1 + c) {
                ob_opr = "нечетная";
            }
            if (D > 0) {
                TextArea.setText("дискриминант=" + D + ">0 (2 корня)");
                if (a > 0) {
                    TextArea.setText(TextArea.getText() + "\na=" + a + ">0 (ветви вверх)");
                    TextArea.setText(TextArea.getText() + "\nнайдем нули функции:(" + -b + "±√" + D + ")/(" + 2 * a + ")" + "\nx1= " + x2 + " x2= " + x1);
                    TextArea.setText(TextArea.getText() + "\n1)D(y)= (-∞;+∞)");
                    TextArea.setText(TextArea.getText() + "\n2)E(y)= [" + -(Math.pow(b, 2) - 4 * a * c) / (4 * a) + ";+∞)");
                    TextArea.setText(TextArea.getText() + "\n3)Функция " + ob_opr);
                    TextArea.setText(TextArea.getText() + "\n4)нули функции:" + x2 + ", " + x1);
                    TextArea.setText(TextArea.getText() + "\n5)Промежутки знакопостоянства:(-∞;" + x2 + ")(" + x1 + "+∞)>0 (" + x2 + ";" + x1 + ")<0");
                    TextArea.setText(TextArea.getText() + "\n6)Промежутки монотонности:↓[-∞;" + -b / (2 * a) + "] ↑[" + -b / (2 * a) + ";+∞)");
                    TextArea.setText(TextArea.getText() + "\n7)Наибольшее и наименьшее значения функции: yнаиб= —; yнаим=" + -b / (2 * a));
                } else if (a < 0) {
                    TextArea.setText(TextArea.getText() + "\na=" + a + "<0 (ветви вниз)");
                    TextArea.setText(TextArea.getText() + "\nнайдем нули функции:(" + -b + "±√" + D + ")/(" + 2 * a + ")" + "\nx1= " + x2 + " x2= " + x1);
                    TextArea.setText(TextArea.getText() + "\n1)D(y)= (-∞;+∞)");
                    TextArea.setText(TextArea.getText() + "\n2)E(y)= (-∞;" + -(Math.pow(b, 2) - 4 * a * c) / (4 * a) + "]");
                    TextArea.setText(TextArea.getText() + "\n3)Функция " + ob_opr);
                    TextArea.setText(TextArea.getText() + "\n4)нули функции:" + x2 + ", " + x1);
                    TextArea.setText(TextArea.getText() + "\n5)Промежутки знакопостоянства:(-∞;" + x2 + ")(" + x1 + "+∞)>0 (" + x2 + ";" + x1 + ")<0");
                    TextArea.setText(TextArea.getText() + "\n6)Промежутки монотонности:↓[\"+-b/(2*a)+\";+∞) ↑[-∞;" + -b / (2 * a) + "]");
                    TextArea.setText(TextArea.getText() + "\n7)Наибольшее и наименьшее значения функции: yнаиб= " + -b / (2 * a) + "; yнаим=—");
                }
                run = false;
            } else {
                if (D == 0) {
                    x1 = (-b) / (2 * a);
                    x1 = Math.round(x1 * 100) / 100.00;//округление
                    TextArea.setText(TextArea.getText() + "дискриминант=0 (1 корень)");
                    if (a > 0) {
                        TextArea.setText(TextArea.getText() + "\na=" + a + ">0 (ветви вверх)");
                        TextArea.setText(TextArea.getText() + "\nнайдем нули функции:(" + -b + "±√" + D + ")/(" + 2 * a + ")" + "\nx1= " + x2 + " x2= " + x1);
                        TextArea.setText(TextArea.getText() + "\n1)D(y)= (-∞;+∞)");
                        TextArea.setText(TextArea.getText() + "\n2)E(y)= [" + -(Math.pow(b, 2) - 4 * a * c) / (4 * a) + ";+∞)");
                        TextArea.setText(TextArea.getText() + "\n3)Функция " + ob_opr);
                        TextArea.setText(TextArea.getText() + "\n4)нули функции:" + x1);
                        TextArea.setText(TextArea.getText() + "\n5)Промежутки знакопостоянства:(-∞;" + x1 + ")(" + x1 + "+∞)>0");
                        TextArea.setText(TextArea.getText() + "\n6)Промежутки монотонности:↓[-∞;" + -b / (2 * a) + "] ↑[" + -b / (2 * a) + ";+∞)");
                        TextArea.setText(TextArea.getText() + "\n7)Наибольшее и наименьшее значения функции: yнаиб= —; yнаим=" + -b / (2 * a));
                    } else if (a < 0) {
                        TextArea.setText(TextArea.getText() + "\na=" + a + "<0 (ветви вниз)");
                        TextArea.setText(TextArea.getText() + "\nнайдем нули функции:(" + -b + "±√" + D + ")/(" + 2 * a + ")" + "\nx1= " + x2 + " x2= " + x1);
                        TextArea.setText(TextArea.getText() + "\n1)D(y)= (-∞;+∞)");
                        TextArea.setText(TextArea.getText() + "\n2)E(y)= (-∞;" + -(Math.pow(b, 2) - 4 * a * c) / (4 * a) + "]");
                        TextArea.setText(TextArea.getText() + "\n3)Функция " + ob_opr);
                        TextArea.setText(TextArea.getText() + "\n4)нули функции:" + x1);
                        TextArea.setText(TextArea.getText() + "\n5)Промежутки знакопостоянства:(-∞;" + x1 + ")(" + x1 + "+∞)<0");
                        TextArea.setText(TextArea.getText() + "\n6)Промежутки монотонности:↓[\"+-b/(2*a)+\";+∞) ↑[-∞;" + -b / (2 * a) + "]");
                        TextArea.setText(TextArea.getText() + "\n7)Наибольшее и наименьшее значения функции: yнаиб= " + -b / (2 * a) + "; yнаим=—");
                    }
                    run = false;
                }
                if (D < 0) {
                    TextArea.setText(TextArea.getText() + "\nдискриминант=" + D + "<0 (0 кореней)");
                    if (a > 0) {
                        TextArea.setText(TextArea.getText() + "\na=" + a + ">0 (ветви вверх)");
                        TextArea.setText(TextArea.getText() + "\nуравнение не имеет смысла");
                    } else if (a < 0) {
                        TextArea.setText(TextArea.getText() + "\na=" + a + "<0 (ветви вниз)");
                        TextArea.setText(TextArea.getText() + "\nуравнение не имеет смысла");
                    }
                    run = false;
                }
            }
        }
    }

    public void graphik(double a, double b, double c, double D) {

        if (D > 0) {
            plotLine(x -> (a) * Math.pow(x, 2) + (b) * x + c);
        } else if (D == 0) {
            plotLine(x -> (a) * Math.pow(x, 2) + (b) * x + c);
        } else if (D < 0) {
            plotLine(x -> (a) * Math.pow(x, 2) + (b) * x + c);
            plotLine(x -> -1 * ((a) * Math.pow(x, 2) + (b) * x + c));
        }
    }


    private void clear() {                 //метод очистки
        if (lineGraph.isVisible()) {
            mathsGraph.clear();
        } else {
            areaMathsGraph.clear();
        }
    }

    @FXML
    void Glwindow(ActionEvent event) throws Exception { // название кнопки
        glwindow.getScene().getWindow().hide(); // закрываем текущее окно
        Window window = new Window();
        window.newWindow("scene.fxml", true);
    }

    @FXML
    void teorywindow(ActionEvent event) throws Exception {
        teory.getScene().getWindow().hide(); // закрываем текущее окно
        Window window = new Window();
        window.newWindow("scene1.fxml", true);
    }

    @FXML
    void test(ActionEvent event) throws Exception {
        try {
            Window window = new Window();
            window.newWindow("scene3.fxml", false);
        } catch (InvocationTargetException e) {

        }
    }
}
