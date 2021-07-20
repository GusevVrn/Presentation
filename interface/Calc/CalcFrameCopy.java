package Interface.Calc;

import Interface.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Calculator ver 0.2
 * После нажатия "=", надо впустую прогнать число и знак, после этого продолжит корректно считать
 */

public class CalcFrameCopy extends JFrame {
    JTextField window = new JTextField(15);
    JLabel label = new JLabel();
    JButton num[] = new JButton[11];

    String signs[] = {"+", "-", "*", "/", "√", "="};
    JButton sign[] = new JButton[signs.length];

    JButton delBut = new JButton("<-");
    JButton clearBut = new JButton("C");

    JButton backBut = new JButton("Back to menu");

    static double number1 = 0.0;
    static double number2 = 0.0;
    static double res = 0;

    static String s = "";
    static String labelText = "";

    int operation = 0;
    int check = 0;

    public CalcFrameCopy() {
        super("Калькулятор");
        setSize(500, 500);
        setLocationRelativeTo(null);
        Container c = getContentPane();
        JPanel top = new JPanel(new GridLayout(2, 1));
        JPanel middle = new JPanel(new GridLayout(4, 4));
        JPanel right = new JPanel(new GridLayout(4, 2));
        JPanel bottom = new JPanel(new GridLayout(1, 2));

        for (int i = 0; i < num.length; i++) { //заполняем кнопки 0-9 и ".", навешиваем слушателя который считывает в строку что нажали
            num[i] = new JButton("" + i);
            if (i == num.length - 1) {
                num[i] = new JButton(".");
            }
            num[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton btn = (JButton) e.getSource();
                    s = s + btn.getText();
                    window.setText(s);
                }
            });
        }

        for (int i = 0; i < sign.length; i++) { //заполняем знаки и слушателя,
            sign[i] = new JButton(signs[i]);
            right.add(sign[i]);
            sign[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    number1 = Double.parseDouble(s);
                    if (check == 0) {
                        res += number1;
                    }
                    s = "";
                    window.setText(s);
                    labelText = labelText + " " + number1 + " ";

                    switch (operation) {
                        case 1:
                            res += number1;
                            break;
                        case 2:
                            res -= number1;
                            break;
                        case 3:
                            res *= number1;
                            break;
                        case 4:
                            if (number1 == 0) {
                                window.setText("На 0 делить нельзя");
                            } else {
                                res /= number1;
                            }
                            break;
                        case 5:
                            break;
                        case 6:
                            labelText = labelText + " = " + res;
                            label.setText(labelText + " " + res);

                            break;
                    }

                    System.out.println("num = " + number1 + " res = " + res); // Консоль для проверки


                    JButton btn = (JButton) e.getSource();
                    if (btn.getText().equals("+")) {
                        operation = 1;
                        labelText += " + ";
                        check = 1;
                    } else if (btn.getText().equals("-")) {
                        operation = 2;
                        labelText += " - ";
                        check = 1;
                    } else if (btn.getText().equals("*")) {
                        operation = 3;
                        labelText += " * ";
                        check = 1;
                    } else if (btn.getText().equals("/")) {
                        operation = 4;
                        labelText += " / ";
                        check = 1;
                    } else if (btn.getText().equals("√")) {
                        res = Math.sqrt(number1);
                        labelText = btn.getText() + number1 + " = " + res;
                    } else if (btn.getText().equals("=")) {
                        operation = 6;
                        labelText = labelText + " = " + res;
                        check = 1;
                    }
                    label.setText(labelText);
                }
            });
        }

        delBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char c[] = s.toCharArray();
                s = new String(c, 0, c.length - 1);
                window.setText(s);
            }
        });

        clearBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s = "";
                labelText = "";
                res = 0;
                number1 = 0;
                window.setText(s);
                label.setText(s);
                check = 0;
            }
        });

        backBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Menu().setVisible(true);
            }
        });

        top.add(label);
        top.add(window);

        middle.add(num[7]);
        middle.add(num[8]);
        middle.add(num[9]);
        middle.add(num[4]);
        middle.add(num[5]);
        middle.add(num[6]);
        middle.add(num[1]);
        middle.add(num[2]);
        middle.add(num[3]);
        middle.add(num[0]);
        middle.add(num[num.length - 1]);
        middle.add(sign[sign.length - 1]);

        right.add(clearBut);
        right.add(delBut);

        bottom.add(backBut);

        c.add(top, BorderLayout.NORTH);
        c.add(middle, BorderLayout.CENTER);
        c.add(right, BorderLayout.EAST);
        c.add(bottom, BorderLayout.SOUTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
