package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MyPanel extends JPanel {
    int x = 400;//координата шапки по оси X
    int x1 = 400;
    int y = 0;
    int lives = 3;
    Image shapka, fon, obj;//shapka - это элемент, который ловит падающие предметы
    int slogn;
    Timer timerDraw;
    Timer timerObj;
    int counter = 0;

    public MyPanel(int s) throws IOException {
        slogn = s;
        shapka = ImageIO.read(new File("C:\\Users\\Pavel\\IdeaProjects\\CourseNSK\\src\\game\\shapka.png"));
        fon = ImageIO.read(new File("C:\\Users\\Pavel\\IdeaProjects\\CourseNSK\\src\\game\\fon.png"));
        obj = ImageIO.read(new File("C:\\Users\\Pavel\\IdeaProjects\\CourseNSK\\src\\game\\obj.png"));

        timerDraw = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();//запускаем paintComponent, который отвечает за отображение элементов на фрейме
                y += 1;
                if (y >= 600) {
                    do {
                        x1 = (int) (Math.random() * 500);
                    } while (x1 % 10 != 0);
                    y = 0;
                }
                if (y == 0) {
                    lives--;
                    if (lives == 0) {
                        timerDraw.stop();
                        score();
                    }
                }
                if (x == x1 && y == 460) {
                    do {
                        x1 = (int) (Math.random() * 500);
                    } while (x1 % 10 != 0);
                    y = 0;
                    counter++;
                    repaint();
                }
            }
        });
        timerDraw.start();
    }

    public void score() {
        JOptionPane.showMessageDialog(null, "Ваш счет: " + counter);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(fon, 0, 0, null);
        g.drawImage(shapka, x, 460, null);
        g.drawImage(obj, x1, y, null);
    }
}
