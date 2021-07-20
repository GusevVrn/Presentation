package Interface.Calc;

import Interface.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Calculator ver 0.1
 * Некорректно работает "=", надо сперва нажать на какой-нибудь знак, а потом на =;
 */

public class CalcFrame extends JFrame {
    JTextField window = new JTextField(15);
    JLabel label = new JLabel();
    JButton num[] = new JButton[11];

    String signs[] = {"+", "-", "*", "/", "√"};
    JButton sign[] = new JButton[signs.length];

    JButton delBut = new JButton("<-");
    JButton enterBut = new JButton("=");
    JButton clearBut = new JButton("C");

    JButton backBut = new JButton("Back to menu");

    static double number = 0.0;
    static double res = 0;

    static String s = "";
    static String labelText = "";

    public CalcFrame() {
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
                    number = Double.parseDouble(s);
                    s = "";
                    window.setText(s);
                    JButton btn = (JButton) e.getSource();
                    if (btn.getText().equals("+")) {
                        res += number;
                        labelText = labelText + number + " + ";
                    } else if (btn.getText().equals("-")) {
                        res -= number;
                        labelText = labelText + number + " - ";
                    } else if (btn.getText().equals("*")) {
                        res *= number;
                        labelText = labelText + number + " * ";
                    } else if (btn.getText().equals("/")) {
                        res /= number;
                        labelText = labelText + number + " / ";
                    } else if (btn.getText().equals("√")) {
                        res = Math.sqrt(number);
                        labelText = btn.getText() + number + " = " + res;
                    }
                    label.setText(labelText);
                    System.out.println("num = " + number + " res = " + res); // Консоль для проверки
                }
            });
        }

        enterBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s = "";
                labelText = "";
                label.setText(s);
                window.setText(Double.toString(res));
            }
        });

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
                number = 0;
                window.setText(s);
                label.setText(s);
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
        middle.add(enterBut);

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
