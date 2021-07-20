package game;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JFrame;

public class Okno extends JFrame {
    MyPanel panel;
    int counter = 0;

    public Okno(int s) throws IOException {
        setSize(800, 600);
        // setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Игра. Версия 1.0");
        panel = new MyPanel(s);
        Container c = getContentPane();
        c.add(panel);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                //System.out.println(keyCode);
                if (keyCode == 39) {//нажали клавишу вправо
                    panel.x += 10;
                } else if (keyCode == 37) {
                    panel.x -= 10;
                }
                if (panel.x > getContentPane().getWidth() - 20) {
                    panel.x = -40;
                } else if (panel.x <= -40) {
                    panel.x = getContentPane().getWidth() - 24;
                }
                if (panel.lives == 0) {
                    dispose();
                }
                System.out.println("x = " + panel.x + " x1 = " + panel.x1);
            }
        });
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
