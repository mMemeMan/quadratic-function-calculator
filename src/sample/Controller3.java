package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;


public class Controller3 {
    String str = "";
    int[] array = new int[10];
    int a = 1;
    @FXML
    private Label label;
    @FXML
    private RadioButton Rad;
    @FXML
    private RadioButton Rad1;
    @FXML
    private RadioButton Rad2;
    @FXML
    private RadioButton Rad3;
    @FXML
    private Button go_back;
    @FXML
    private Button go_ahead;
    @FXML
    private ProgressBar progress;


    @FXML
    private void goahead(ActionEvent actionEvent) {//переключение вперед
        if (Rad.isSelected()==false&Rad1.isSelected()==false&Rad2.isSelected()==false&Rad3.isSelected()==false){//проверка на постоновку ответа в пункте
            return;
        }
        if (a != 13) {
            if (a<11) {
                progress.setProgress(a * 0.1+0.1);
            }
            ++a;
            if (a == 2) {
                Test2();
                array[0] = Opredelitel(Rad.isSelected(), Rad1.isSelected(), Rad2.isSelected(), Rad3.isSelected());
                Opridelitel1(a).setSelected(true);
            } else if (a == 3) {
                Test3();
                array[1] = Opredelitel(Rad.isSelected(), Rad1.isSelected(), Rad2.isSelected(), Rad3.isSelected());
                Opridelitel1(a).setSelected(true);
            } else if (a == 4) {
                Test4();
                array[2] = Opredelitel(Rad.isSelected(), Rad1.isSelected(), Rad2.isSelected(), Rad3.isSelected());
                Opridelitel1(a).setSelected(true);
            } else if (a == 5) {
                Test5();
                array[3] = Opredelitel(Rad.isSelected(), Rad1.isSelected(), Rad2.isSelected(), Rad3.isSelected());
                Opridelitel1(a).setSelected(true);
            } else if (a == 6) {
                Test6();
                array[4] = Opredelitel(Rad.isSelected(), Rad1.isSelected(), Rad2.isSelected(), Rad3.isSelected());
                Opridelitel1(a).setSelected(true);
            } else if (a == 7) {
                Test7();
                array[5] = Opredelitel(Rad.isSelected(), Rad1.isSelected(), Rad2.isSelected(), Rad3.isSelected());
                Opridelitel1(a).setSelected(true);
            } else if (a == 8) {
                Test8();
                array[6] = Opredelitel(Rad.isSelected(), Rad1.isSelected(), Rad2.isSelected(), Rad3.isSelected());
                Opridelitel1(a).setSelected(true);
            } else if (a == 9) {
                Test9();
                array[7] = Opredelitel(Rad.isSelected(), Rad1.isSelected(), Rad2.isSelected(), Rad3.isSelected());
                Opridelitel1(a).setSelected(true);
            } else if (a == 10) {
                Test10();
                array[8] = Opredelitel(Rad.isSelected(), Rad1.isSelected(), Rad2.isSelected(), Rad3.isSelected());
                Opridelitel1(a).setSelected(true);
            } else if (a == 11) {
                array[9] = Opredelitel(Rad.isSelected(), Rad1.isSelected(), Rad2.isSelected(), Rad3.isSelected());
                check();
                go_ahead.setText("Выйти");
            } else if (a == 12) {
                go_ahead.getScene().getWindow().hide();
            }

        }
    }


    @FXML
    private void goback(ActionEvent actionEvent) {//переключение назад
        if (a != 1) {
            --a;
            if (a == 1) {
                Test1();
                Opridelitel1(a).setSelected(true);
            }
            if (a == 2) {
                Test2();
                Opridelitel1(a).setSelected(true);
            }
            if (a == 3) {
                Test3();
                Opridelitel1(a).setSelected(true);
            }
            if (a == 4) {
                Test4();
                Opridelitel1(a).setSelected(true);
            }
            if (a == 5) {
                Test5();
                Opridelitel1(a).setSelected(true);
            }
            if (a == 6) {
                Test6();
                Opridelitel1(a).setSelected(true);
            }
            if (a == 7) {
                Test7();
                Opridelitel1(a).setSelected(true);
            }
            if (a == 8) {
                Test8();
                Opridelitel1(a).setSelected(true);
            }
            if (a == 9) {
                Test9();
                Opridelitel1(a).setSelected(true);
            }
            if (a == 10) {
                Test10();
                Opridelitel1(a).setSelected(true);
            }
            if (a > 0) {
                progress.setProgress(a * 0.1);
            }
        }
    }


    private int Opredelitel(boolean Rad, boolean Rad1, boolean Rad2, boolean Rad3) { //сортировка данных массива
        int b = 1;
        if (Rad == true) {
            b = 1;
        } else if (Rad1 == true) {
            b = 2;
        } else if (Rad2 == true) {
            b = 3;
        } else if (Rad3 == true) {
            b = 4;
        }
        return b;
    }

    @FXML
    private RadioButton Opridelitel1(int a) {//используется для загрузки старых ответов
        if (array[a - 1] == 1) {
            return Rad;
        } else if (array[a - 1] == 2) {
            return Rad1;
        } else if (array[a - 1] == 3) {
            return Rad2;
        } else if (array[a - 1] == 4) {
            return Rad3;
        }
        return null;
    }


    //создание пунктов теста
    private void Test1() {
        label.setText("1)Какой из предложенных многочленов является квадратным трехчленом?");
        Rad.setText("8x²+x³+1=0");
        Rad1.setText("4x-5+2=0");
        Rad2.setText("x²+12x-2=0");
        Rad3.setText("5x⁶-x⁴+2=0");
    }

    private void Test2() {
        label.setText("2)Как называется график квадратичной функции?");
        Rad.setText("Прямая");
        Rad1.setText("Парабола");
        Rad2.setText("Гипербола");
        Rad3.setText("Кубическая парабола");
    }

    private void Test3() {
        label.setText("3)Сколько корней имеет функция 2x²=0?");
        Rad.setText("нет корней");
        Rad1.setText("1");
        Rad2.setText("2");
        Rad3.setText("нет правильного ответа");
    }

    private void Test4() {
        label.setText("4)Чему равен дискриминант уравнения 5x²+6x-7");
        Rad.setText("70");
        Rad1.setText("184");
        Rad2.setText("176");
        Rad3.setText("-184");
    }

    private void Test5() {
        label.setText("5)Какое из предложенных квадратных уравнений не имеет корней?");
        Rad.setText("4x²-3x-4=0");
        Rad1.setText("x²+4x+3=0");
        Rad2.setText("9x²+6x+1=0");
        Rad3.setText("5x²-x+1=0");
    }

    private void Test6() {
        label.setText("6)Чему равна сумма корней уравнения -2x²+1x+3=0");
        Rad.setText("0.5");
        Rad1.setText("1");
        Rad2.setText("-0.5");
        Rad3.setText("-1");
    }

    private void Test7() {
        label.setText("7)Чему равны корни уравнения 5x²+2x+4");
        Rad.setText("-2 и 6");
        Rad1.setText("-4 и 6");
        Rad2.setText("-2 и 2");
        Rad3.setText("нет правильного ответа");
    }

    private void Test8() {
        label.setText("8)Найдите произведение корней уравнения 2x²+3х-2=0");
        Rad.setText("-1");
        Rad1.setText("корней нет");
        Rad2.setText("-2.5");
        Rad3.setText("-10");
    }

    private void Test9() {
        label.setText("9)Найдите наименьший корень уравнения –x²+7х-10=0");
        Rad.setText("-5");
        Rad1.setText("2");
        Rad2.setText("корней нет");
        Rad3.setText("5");
        go_ahead.setText("--->");
    }

    private void Test10() {
        label.setText("10)Какая пара чисел является корнями уравнения 3x²-75=0");
        Rad.setText("0 и 25");
        Rad1.setText("25 и -25");
        Rad2.setText("0 и -5");
        Rad3.setText("5 и -5");
        go_ahead.setText("проверка");
        str = "Ошибки в номерах:";
    }


    private void check() {     //проверка правильности
        int[] array1 = {3, 2, 2, 3, 4, 1, 4, 1, 2, 4, 1};
        for (int i = 0; i < array.length; i++) {
            if (array1[i] != array[i]) {
                i = i + 1;
                str = str + " " + i;
                i = i - 1;
            }
        }
        label.setText(str);
    }

}

