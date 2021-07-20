package Interface;

import Interface.AutoHT.AutoFrameOne;
import Interface.Calc.CalcFrame;
import Interface.Calc.CalcFrameCopy;

import javax.swing.*;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    JButton butOne = new JButton("Задание с автомобилями");
    JButton butTwo = new JButton("Калькулятор v0.1");
    JButton butThree = new JButton("Калькулятор v0.2");
    JButton butFour = new JButton("(in dev)");
    JButton butExit = new JButton("Exit");
    JLabel user = new JLabel("Добро пожаловать ");

    public Menu() {
        this("");
    }

    public Menu(String name) {
        super("Меню выбора");
        setSize(400, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setUndecorated(true);

        JPanel jp = new JPanel(new GridLayout(2, 1));
        JPanel fl = new JPanel(new FlowLayout());
        JPanel exit = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        jp.add(butOne);
        jp.add(butTwo);
        jp.add(butThree);
        jp.add(butFour);


        user.setText(user.getText() + name);

        fl.add(user);
        exit.add(butExit);
        Container c = getContentPane();
        c.add(fl, BorderLayout.NORTH);
        c.add(jp, BorderLayout.CENTER);
        c.add(exit, BorderLayout.SOUTH);

        butOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AutoFrameOne().setVisible(true);
            }
        });

        butTwo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new CalcFrame().setVisible(true);
            }
        });

        butThree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new CalcFrameCopy().setVisible(true);
            }
        });

        butExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
